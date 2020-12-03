package edu.oakland.test.middleware02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.database.DatabaseCommInterface;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterface;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterfaceImplementation;
import edu.oakland.test.middleware02.DatabaseCommInterfaceStub;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("MiddlewareCommDatabaseInterfaceImplementation Unit Tests")
public class MiddlewareCommDatabaseInterfaceImplementationTests {
  
  @Test
  @DisplayName("Rfid In Is the same Rfid Out")
    void rfidInIsRfIdOut() {
    int ranRfid = (int) (Math.floor(100000 + Math.random() * 900000));
    MiddlewareCommDatabaseInterface mid02DatabaseInterface = 
        new MiddlewareCommDatabaseInterfaceImplementation(new DatabaseCommInterfaceStub(ranRfid));
    assertEquals(ranRfid, mid02DatabaseInterface.checkCurrentRfid());
  }

  @Test
  @DisplayName("Mode In is same as Mode Out")
  void modeInIsModeOut() {
    MiddlewareCommDatabaseInterface mid02DatabaseInterface = 
        new MiddlewareCommDatabaseInterfaceImplementation(new DatabaseCommInterfaceStub("normal"));
    assertEquals("normal", mid02DatabaseInterface.requestMode());
  }

  @Test
  @DisplayName("LocationDataPoint In is same as LocationDataPoint Out")
  void locationDataPointInIsLocationDataPointOut() {
    LocationDataPoint locationDataPoint = generateRandomLocationDataPoint();
    MiddlewareCommDatabaseInterface mid02DatabaseInterface = 
        new MiddlewareCommDatabaseInterfaceImplementation(new DatabaseCommInterfaceStub(
            locationDataPoint
        ));
    TrackData td = new TrackData(generateRandomLocationDataPointsArray(10));
    mid02DatabaseInterface.storeTrackData(td);
    assertEquals(locationDataPoint, mid02DatabaseInterface.getLocationDataPoint(0));
  }

  @Test
  @DisplayName("TrackData In is same as TrackData Out")
  void trackDataInIsTrackDataOut() {
    MiddlewareCommDatabaseInterface mid02DatabaseInterface = 
        new MiddlewareCommDatabaseInterfaceImplementation(new DatabaseCommInterfaceStub());
    TrackData td = new TrackData(generateRandomLocationDataPointsArray(10));
    mid02DatabaseInterface.storeTrackData(td);
    assertEquals(td, mid02DatabaseInterface.getTrackData());
  }

  @Test 
  @DisplayName("Verifies if middlewareManager is set to Null")
  void nullCheck() {
    assertThrows(IllegalArgumentException.class, () -> {
      new MiddlewareCommDatabaseInterfaceImplementation(null);
    });
  }

  private LocationDataPoint[] generateRandomLocationDataPointsArray(int length) {
    LocationDataPoint[] locations = new LocationDataPoint[length];
    for (int index = 0; index < locations.length; index++) {
      locations[index] = generateRandomLocationDataPoint();
    }
    return locations;
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
}
