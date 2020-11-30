package edu.oakland.test.database;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.production.database.DatabasePersistentStorage;

public class DatabasePersistentStorageStub implements DatabasePersistentStorage {

  private LocationDataPoint ldp;
  private String mode;

  public String getNextSat(String currentSat) {
    return currentSat;
  }

  public LocationDataPoint getLocationDataPoint() {
    return ldp;
  }

  public void storeLocationDataPoint(LocationDataPoint locationDataPoint) {
    ldp = locationDataPoint;
  }

  public void storeMode(String mode) {
    this.mode = mode;
  }

  public String getMode() {
    return mode;
  }
  
  public TrackData getTrackData(int offset) {
    TrackData td = null;
    return td;
  }
  
  public int locateRfidData() {
    return 10;
  }

  public void storeTrackData(TrackData trackData) {
    
  }
  
 
}
