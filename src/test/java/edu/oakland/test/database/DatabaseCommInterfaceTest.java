package edu.oakland.test.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.database.DatabaseCommInterface;
import edu.oakland.production.database.DatabaseCommInterfaceClass;
import edu.oakland.production.database.DatabasePersistentStorage;
import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Database CommInterface Test")
public class DatabaseCommInterfaceTest {

  @Test
  @DisplayName("rfid going in is Rfid coming Out")
    void rfidInIsRfidOut() {
      int i = 10;
      DatabaseCommManagerStub dcm = new DatabaseCommManagerStub();
      assertEquals(i, dcm.passGetRfidRequest());
  }
  
  @Test
  @DisplayName("Offset matches Datapoint")
  void offsetMatchDataPoint() {
    
    DatabaseCommManagerStub dcm = new DatabaseCommManagerStub();

    float lat = (float) (Math.random() * 360 - 180);
    float lng = (float) (Math.random() * 360 - 180);
    LocationDataPoint ldp = new LocationDataPoint(lat, lng,
                                LocalDateTime.of((int) (Math.random() * 50 + 1970),
                                 (int) (Math.random() * 12 + 1),
                                (int) (Math.random() * 28 + 1), (int) (Math.random() * 24),
                                 (int) (Math.random() * 60)));
    ldp = null;    
    int i = (int) Math.random();    
    assertEquals(ldp, dcm.passGetLocationDataPointRequest(i));
  }
  
  @Test
  @DisplayName("Offset matches TrackData")
  void offsetMatchTrackData() {
    

    DatabaseCommManagerStub dcm = new DatabaseCommManagerStub();

    TrackData td = new TrackData(generateRandomLocationDataPointsArray(10));
    int i = (int) (Math.random() * 7);
    assertEquals(null, dcm.passGetTrackDataRequest(i));  
  }
  
  @Test
  @DisplayName("TrackData In is same as TrackData Out")
  void trackDataInIsTrackDataOut() {
   
    DatabaseCommManagerStub dcm = new DatabaseCommManagerStub();
    
    TrackData td = new TrackData(generateRandomLocationDataPointsArray(10));
    td = null;
    int i = (int) Math.random();
    assertEquals(td, dcm.passGetTrackDataRequest(i));


  }

  @Test
  @DisplayName("Mode in is mode out")
  void modeInIsModeOut() {

    DatabaseCommManagerStub dcms = new DatabaseCommManagerStub();
    DatabaseCommInterfaceClass dci = new DatabaseCommInterfaceClass(dcms);
    dci.receiveGetModeRequest();
    assertEquals("", dcms.passGetModeRequest());
  }
  
  
  @Test
  @DisplayName("Database Comm Manager is not Null")
  void databaseCommManagerNotNull() {

    assertThrows(IllegalArgumentException.class, () -> {
      new DatabaseCommInterfaceClass(null);
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
