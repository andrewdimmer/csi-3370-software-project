package edu.oakland.test.middleware02;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.helper.middleware02.TrackDataCalculator;
import edu.oakland.production.middleware01.MiddlewareGisManager;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterface;
import edu.oakland.production.middleware02.MiddlewareCommLinkManager;
import edu.oakland.production.middleware02.MiddlewareCommLinkManagerImplementation;
import edu.oakland.test.middleware01.MiddlewareGisManagerStub;
import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("MiddlewareCommLinkManagerImplementation Unit Tests")
public class MiddlewareCommLinkManagerImplementationTests {

  @Test 
  @DisplayName("Rfid Does Not Match")
  void rfidDoesNotMatchStopsTestCase() {
    int rfid1 = (int) (Math.floor(100000 + Math.random() * 900000));
    int rfid2 = (int) (Math.floor(100000 + Math.random() * 900000));
    MiddlewareCommLinkManager mid02Interface = new MiddlewareCommLinkManagerImplementation(
        new MiddlewareCommDatabaseInterfaceStub(rfid1),
        new MiddlewareGisManagerStub()
    );
    
    TrackData trackData = mid02Interface.parseRfid(rfid2);
    assertEquals(
        "The system RFID does not match the requested RFID.",
        trackData.getStatusMessage()
    );
  }

  @Test 
  @DisplayName("Store Request Sent When RFIDs Match and In Normal Mode")
  void storeRequestSentWhenRfidsMatch() {
    int rfid = (int) (Math.floor(100000 + Math.random() * 900000));

    LocationDataPoint ranLocationDataPoint = generateRandomLocationDataPoint();
    MiddlewareCommDatabaseInterfaceStub stub1 = new MiddlewareCommDatabaseInterfaceStub(
        rfid,
        "normal",
        generateRandomLocationDataPointArray(5),
        new TrackData(generateRandomLocationDataPointArray(4))
    );
    MiddlewareGisManagerStub stub2 = new MiddlewareGisManagerStub(
        ranLocationDataPoint
    );
    MiddlewareCommLinkManager mid02Manager = new MiddlewareCommLinkManagerImplementation(
        stub1,
        stub2
    );
    mid02Manager.parseRfid(rfid);
    assertEquals(ranLocationDataPoint, stub2.getLocation2());
  }

  @Test 
  @DisplayName("Does Not Store Request Sent When RFIDs Do Not Match")
  void doesNotStoreRequestSentWhenRfidsDoNotMatch() {
    int rfid1 = (int) (Math.floor(100000 + Math.random() * 900000));
    int rfid2 = (int) (Math.floor(100000 + Math.random() * 900000));

    LocationDataPoint ranLocationDataPoint = generateRandomLocationDataPoint();
    MiddlewareCommDatabaseInterfaceStub stub1 = new MiddlewareCommDatabaseInterfaceStub(
        rfid1,
        "normal",
        generateRandomLocationDataPointArray(5),
        new TrackData(generateRandomLocationDataPointArray(4))
    );
    MiddlewareGisManagerStub stub2 = new MiddlewareGisManagerStub(
        ranLocationDataPoint
    );
    MiddlewareCommLinkManager mid02Manager = new MiddlewareCommLinkManagerImplementation(
        stub1,
        stub2
    );
    mid02Manager.parseRfid(rfid2);
    assertEquals(null, stub2.getLocation2());
  }

  @Test 
  @DisplayName("Does Not Store Request Sent When RFIDs When Not In Normal Mode")
  void doesNotStoreRequestSentWhenNotInNormalMode() {
    int rfid = (int) (Math.floor(100000 + Math.random() * 900000));

    LocationDataPoint ranLocationDataPoint = generateRandomLocationDataPoint();
    MiddlewareCommDatabaseInterfaceStub stub1 = new MiddlewareCommDatabaseInterfaceStub(
        rfid,
        "degraded",
        generateRandomLocationDataPointArray(5),
        new TrackData(generateRandomLocationDataPointArray(4))
    );
    MiddlewareGisManagerStub stub2 = new MiddlewareGisManagerStub(
        ranLocationDataPoint
    );
    MiddlewareCommLinkManager mid02Manager = new MiddlewareCommLinkManagerImplementation(
        stub1,
        stub2
    );
    mid02Manager.parseRfid(rfid);
    assertEquals(null, stub2.getLocation2());
  }

  @Test 
  @DisplayName("Empty Database Returns Empty Track Data")
  void emptyDatabaseReturnsEmptyTrackData() {
    int rfid = (int) (Math.floor(100000 + Math.random() * 900000));

    LocationDataPoint[] locationDataPoints = generateRandomLocationDataPointArray(0);
    MiddlewareCommDatabaseInterfaceStub stub1 = new MiddlewareCommDatabaseInterfaceStub(
        rfid,
        "normal",
        locationDataPoints,
        new TrackData(generateRandomLocationDataPointArray(4))
    );
    MiddlewareGisManagerStub stub2 = new MiddlewareGisManagerStub(
        generateRandomLocationDataPoint()
    );
    MiddlewareCommLinkManager mid02Manager = new MiddlewareCommLinkManagerImplementation(
        stub1,
        stub2
    );
    TrackData result = mid02Manager.parseRfid(rfid);
    assertTrue(result.getStatusMessage().contains("normal mode, but there's not enough data"));
    assertArrayEquals(locationDataPoints, result.getLocationDataPoints());
  }

  @Test 
  @DisplayName("Partial data Returns Partial Track Data")
  void notEnoughDataReturnsPartialTrackData() {
    int rfid = (int) (Math.floor(100000 + Math.random() * 900000));

    LocationDataPoint[] locationDataPoints = generateRandomLocationDataPointArray(
        (int) (Math.random() * 4 + 1)
    );
    MiddlewareCommDatabaseInterfaceStub stub1 = new MiddlewareCommDatabaseInterfaceStub(
        rfid,
        "normal",
        locationDataPoints,
        new TrackData(generateRandomLocationDataPointArray(0))
    );
    MiddlewareGisManagerStub stub2 = new MiddlewareGisManagerStub(
        generateRandomLocationDataPoint()
    );
    MiddlewareCommLinkManager mid02Manager = new MiddlewareCommLinkManagerImplementation(
        stub1,
        stub2
    );
    TrackData result = mid02Manager.parseRfid(rfid);
    assertTrue(result.getStatusMessage().contains("normal mode, but there's not enough data"));
    assertArrayEquals(locationDataPoints, result.getLocationDataPoints());
  }

  @Test 
  @DisplayName("Enough Data Returns Full Data")
  void enoughTrackDataReturnsFullData() {
    int rfid = (int) (Math.floor(100000 + Math.random() * 900000));

    LocationDataPoint[] locationDataPoints = generateRandomLocationDataPointArray(5);
    MiddlewareCommDatabaseInterfaceStub stub1 = new MiddlewareCommDatabaseInterfaceStub(
        rfid,
        "normal",
        locationDataPoints,
        new TrackData(generateRandomLocationDataPointArray(0))
    );
    MiddlewareGisManagerStub stub2 = new MiddlewareGisManagerStub(
        generateRandomLocationDataPoint()
    );
    MiddlewareCommLinkManager mid02Manager = new MiddlewareCommLinkManagerImplementation(
        stub1,
        stub2
    );
    TrackData result = mid02Manager.parseRfid(rfid);
    assertTrue(result.getStatusMessage().contains("normal mode and has enough data"));
    assertArrayEquals(locationDataPoints, result.getLocationDataPoints());
    assertEquals(TrackDataCalculator.calculateSpeed(locationDataPoints), result.getSpeed());
    assertEquals(
        TrackDataCalculator.calculateDirection(locationDataPoints),
        result.getCourseDirection()
    );
  }

  @Test
  @DisplayName("Stored data is Stored data") 
  void storedTrackDataCheck() {
    int rfid = (int) (Math.floor(100000 + Math.random() * 900000));

    TrackData trackData = new TrackData(generateRandomLocationDataPointArray(0));
    MiddlewareCommDatabaseInterfaceStub stub1 = new MiddlewareCommDatabaseInterfaceStub(
        rfid,
        "degraded",
        generateRandomLocationDataPointArray(5),
        trackData
    );
    MiddlewareGisManagerStub stub2 = new MiddlewareGisManagerStub(
        generateRandomLocationDataPoint()
    );
    MiddlewareCommLinkManager mid02Manager = new MiddlewareCommLinkManagerImplementation(
        stub1,
        stub2
    );
    TrackData result = mid02Manager.parseRfid(rfid);
    assertTrue(result.getStatusMessage().contains("degraded mode ... getting historical data"));
    assertEquals(trackData, result);
  }

  @Test
  @DisplayName("Verifies that MiddlewareCommDatabaseInterface cannot be set to null")
  void nullMiddwareCommDatabaseInterfaceIsNotAllowed() { 
    MiddlewareGisManager middlewareGisManager = new MiddlewareGisManagerStub();
    assertThrows(IllegalArgumentException.class, () -> {
      new MiddlewareCommLinkManagerImplementation(null, middlewareGisManager);
    });
  }

  @Test
  @DisplayName("Verifies that MiddlewareGisManager cannot be set to null")
  void nullMiddwareGisManagerIsNotAllowed() { 
    MiddlewareCommDatabaseInterface commDbInterface = new MiddlewareCommDatabaseInterfaceStub(0);
    assertThrows(IllegalArgumentException.class, () -> {
      new MiddlewareCommLinkManagerImplementation(commDbInterface, null);
    });
  }

  private LocationDataPoint generateRandomLocationDataPoint() {
    return new LocationDataPoint(
    (float) (Math.random() * 180 - 90),
    (float) (Math.random() * 360 - 180),
    LocalDateTime.of(
      (int) (Math.random() * 50 + 1970),
      (int) (Math.random() * 12 + 1),
      (int) (Math.random() * 28 + 1),
      (int) (Math.random() * 24),
      (int) (Math.random() * 60)
      )
    );
  }

  private LocationDataPoint[] generateRandomLocationDataPointArray(int length) {
    Satellite.satelliteInit(
        (float) (Math.random() - .5),
        (float) (Math.random() - .5),
        generateRandomLocationDataPoint()
    );
    Satellite satellite = new Satellite("Test", 5);
    LocationDataPoint[] locations = new LocationDataPoint[length];
    for (int index = locations.length - 1; index >= 0; index--) {
      // Eat up extra locations to change the time and distance traveled
      locations[index] = satellite.getLocation();
    }
    return locations;
  }
}