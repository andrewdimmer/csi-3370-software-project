package edu.oakland.test.database;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.database.DatabasePersistentStorage;

public class DatabasePersistentStorageStub implements DatabasePersistentStorage {
  private String mode;
  private LocationDataPoint ldp;
  private int rfid;
  private TrackData trackData;
  
  public DatabasePersistentStorageStub(){

  }

  public DatabasePersistentStorageStub(int rfid) {
    this.rfid = rfid;
  }
  
  public int locateRfidData() {
    return rfid;
  }

  public LocationDataPoint getLocationDataPoint(int offset) {
    return ldp;
  }

  public void storeLocationDataPoint(LocationDataPoint locationDataPoint) {
    ldp = locationDataPoint;
  }

  public TrackData getTrackData(int offset) {
    return trackData;
  }

  public void storeTrackData(TrackData trackData) {
    this.trackData = trackData;
  }

  public String getMode() {
    return mode;
  }

  public void storeMode(String mode) {
    this.mode = mode;
  }

  public String getNextSat(String currentSat) {
    return currentSat;
  }

}

