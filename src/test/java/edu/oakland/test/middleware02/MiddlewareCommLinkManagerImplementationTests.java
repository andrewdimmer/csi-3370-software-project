package edu.oakland.test.middleware02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
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

  // @Test 
  // @DisplayName("Rfid Does Not Match")
  // void rfidDoesNotMatchStopsTestCase() {
  //   int rfid1 = (int) (Math.floor(100000 + Math.random() * 900000));
  //   int rfid2 = (int) (Math.floor(100000 + Math.random() * 900000));
  //   MiddlewareCommLinkManager mid02Interface = new MiddlewareCommLinkManagerImplementation(
  //       new MiddlewareCommDatabaseInterfaceStub(rfid1),
  //       new MiddlewareGisManagerStub()
  //   );
  //   
  //   TrackData trackData = mid02Interface.parseRfid(rfid2);
  //   assertEquals("hello", trackData.getStatusMessage()); //write prod code to trigger
  // }

  // @Test 
  // @DisplayName("Store Request Sent")
  // void storeRequestSent() {
  //   int rfid3 = (int) (Math.floor(100000 + Math.random() * 900000));
  //   LocationDataPoint ranLocationDataPoint = generateRandomLocationDataPoint();
  //   MiddlewareGisManagerStub stub2 = new MiddlewareGisManagerStub(
  //       generateRandomLocationDataPoint()
  //     );
  //   MiddlewareCommLinkManager mid02Manager = new MiddlewareCommLinkManagerImplementation(
  //       new MiddlewareCommDatabaseInterfaceStub(rfid3),
  //       new MiddlewareGisManagerStub(generateRandomLocationDataPoint())
  //   );
  //   stub2.storeLocationDataPoint();
  //   assertEquals(mid02Manager, ranLocationDataPoint);
  // }

  @Test 
  @DisplayName("Empty Database Returns Empty Track Data")
  void emptyDatabaseReturnsEmptyTrackData() {
      
  }

  @Test 
  @DisplayName("Partial data Returns Partial Track Data")
  void notEnoughDataReturnsPartialTrackData() {
      
  }

  @Test 
  @DisplayName("Enough Data Returns Full Data")
  void enoughTrackDataReturnsFullData() {
      
  }

  @Test
  @DisplayName("Stored data is Stored data") 
  void storedTrackDataCheck() {
      
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
}