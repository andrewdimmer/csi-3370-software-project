package edu.oakland.test.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.database.DatabaseCommInterface;
import edu.oakland.production.database.DatabaseCommInterfaceImplementation;
import edu.oakland.production.database.DatabasePersistentStorage;
import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DatabaseCommInterfaceImplementation Unit Tests")
public class DatabaseCommInterfaceTest {

  @Test
  @DisplayName("rfid going in is Rfid coming Out")
  void rfidInIsRfidOut() {
    int i = (int) (Math.random() * 100);
    DatabaseCommManagerStub dcm = new DatabaseCommManagerStub(i);
    DatabaseCommInterfaceImplementation dci = new DatabaseCommInterfaceImplementation(dcm);
    assertEquals(i, dci.receiveGetRfidRequest());
  }
  
  @Test
  @DisplayName("Offset matches Datapoint")
  void offsetMatchDataPoint() {

    int i = (int) (Math.random() * 100);
    DatabaseCommManagerStub dcm = new DatabaseCommManagerStub(i);
    DatabaseCommInterfaceImplementation dci = new DatabaseCommInterfaceImplementation(dcm);

    float lat = (float) (Math.random() * 360 - 180);
    float lng = (float) (Math.random() * 360 - 180);
    LocationDataPoint ldp = new LocationDataPoint(lat, lng,
        LocalDateTime.of((int) (Math.random() * 50 + 1970),
        (int) (Math.random() * 12 + 1),
        (int) (Math.random() * 28 + 1), (int) (Math.random() * 24),
        (int) (Math.random() * 60)));
    dcm.storeLocationDataPoint(ldp); 
    assertEquals(ldp, dci.receiveGetLocationDataPointRequest(i));
  }
  
  @Test
  @DisplayName("Offset matches TrackData")
  void offsetMatchTrackData() {
    
    int i = (int) (Math.random() * 100);
    DatabaseCommManagerStub dcm = new DatabaseCommManagerStub(i);
    DatabaseCommInterfaceImplementation dci = new DatabaseCommInterfaceImplementation(dcm);
    //TrackData td = new TrackData(generateRandomLocationDataPointsArray(10));
    dci.receiveGetTrackDataRequest(i);
    assertEquals(i, dcm.getIndex());  
  }
  
  @Test
  @DisplayName("TrackData In is same as TrackData Out")
  void trackDataInIsTrackDataOut() {

    int i = (int) Math.random();
    DatabaseCommManagerStub dcm = new DatabaseCommManagerStub(i);
    DatabaseCommInterfaceImplementation dci = new DatabaseCommInterfaceImplementation(dcm);
    TrackData td = new TrackData(generateRandomLocationDataPointsArray(10));
    dci.storeTrackDataRequest(td);
    assertEquals(td, dci.receiveGetTrackDataRequest(i));


  }

  @Test
  @DisplayName("Mode in is mode out")
  void modeInIsModeOut() {
    
    int i = (int) (Math.random() * 100);
    DatabaseCommManagerStub dcms = new DatabaseCommManagerStub(i);
    DatabaseCommInterfaceImplementation dci = new DatabaseCommInterfaceImplementation(dcms);
    String m = "normal";
    dcms.storeMode(m);
    assertEquals(m, dci.receiveGetModeRequest());
  }
  
  
  @Test
  @DisplayName("Database Comm Manager is not Null")
  void databaseCommManagerNotNull() {

    assertThrows(IllegalArgumentException.class, () -> {
      new DatabaseCommInterfaceImplementation(null);
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
