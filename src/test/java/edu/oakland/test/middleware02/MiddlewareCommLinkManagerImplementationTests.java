package edu.oakland.test.middleware02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.production.middleware02.MiddlewareCommLinkManagerImplementation;
import edu.oakland.production.middleware02.MiddlewareCommLinkManager;
import edu.oakland.test.middleware01.MiddlewareGisManagerStub;
import edu.oakland.helper.admin.TrackData;
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
    assertEquals("hello", trackData.getStatusMessage()); //write prod code to trigger
  }
  @Test 
  @DisplayName("Store Request Sent")
  void storeRequestSent() {
    int rfid3 = (int) (Math.floor(100000 + Math.random() * 900000));
    LocationDataPoint ranLocationDataPoint = generateRandomLocationDataPoint();
    MiddlewareCommLinkManager mid03Interface = new MiddlewareCommLinkManagerImplementation(
        new MiddlewareCommDatabaseInterfaceStub(rfid3),
        new MiddlewareGisManagerStub()
    );
    
    

    mid03Interface.recieveStoreRequest();
  }
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
  @DisplayName("Comm Database Interface is not Null")
  void commDatabaseInterfaceIsNotNull() {
      
  }
  @Test 
  @DisplayName("Gis Manager is Not Null")
  void gisManagerIsNotNull() {
      assertThrows(IllegalArgumentException.class, () -> {
      new MiddlewareCommLinkManagerImplementation(
          new MiddlewareCommDatabaseInterfaceStub(0), 
          null
      );
    });
  }
  @Test 
  @DisplayName("Stored data is Stored data")
  void storedTrackDataCheck() {
      assertThrows(IllegalArgumentException.class, () -> {
      new MiddlewareCommLinkManagerImplementation(null, new MiddlewareGisManagerStub());
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