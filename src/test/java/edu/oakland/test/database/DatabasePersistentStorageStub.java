package edu.oakland.test.database;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.database.DatabasePersistentStorage;

public class DatabasePersistentStorageStub implements DatabasePersistentStorage {

  public int locateRfidData() {
    return 0;
  }

  public LocationDataPoint getLocationDataPoint(int offset) {
    return null;
  }

  public void storeLocationDataPoint(LocationDataPoint locationDataPoint) {

  }

  public TrackData getTrackData(int offset) {
    return null;
  }

  public void storeTrackData(TrackData trackData) {

  }

  public String getMode() {
    return "";
  }

  public void storeMode(String mode) {

  }

  public String getNextSat(String currentSat) {
    return "";
  }

}