package edu.oakland.test.database;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.database.DatabaseCommInterface;
import edu.oakland.production.database.DatabasePersistentStorage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Database CommInterface Test")
public class DatabaseCommInterfaceTest {

  @Test
  @DisplayName("rfid going in is rfid coming out")
  void rfidInIsrRfidOut(){
    DatabaseCommManager dcm = new DatabaseCommManager();
    int i = (int)Math.random();
    assertEquals(i, dcm.receiveGetRfidRequest());
  }
  
  @Test
  @DisplayName("Offset matches Datapoint")
  void offsetMatchDataPoint(){
    DatabaseCommManager dcm = new DatabaseCommManager();
    LocationDataPoint ldp = new LocationDataPoint();
    ldp = null;
    int i = (int)Math.random();
    assertEquals(ldp, dcm.receiveGetLocationDataPointRequest(i));
  }
  
  @Test
  @DisplayName("Offset matches TrackData")
  void offsetMatchTrackData(){
    DatabaseCommManager dcm = new DatabaseCommManager();
    TrackData td = new TrackData();
    td = null;
    int i = (int)Math.random();
    assertEquals(td, dcm.receiveGetTrackDataRequest(i));
  }
  
  @Test
  @DisplayName("TrackData In is same as TrackData Out")
  void trackDataInIsTrackDataOut(){
    DatabaseCommManager dcm = new DatabaseCommManager();
    TrackData td = new TrackData();
    int i = (int)Math.random();  
    dcm.passStoreTrackDataRequest(td);
    assertEquals(td, dcm.storeGetTrackDataRequest(i));  
  }
  
  @Test
  @DisplayName("Database Persistent Storage is not Null")
  void databasePersistentStorageIsNotNull(){
    DatabaseCommManager dcm = new DatabaseCommManager();
    String n = "normal";
    assertEquals(n, dcm.receiveGetModeRequest());    
  }
  
}