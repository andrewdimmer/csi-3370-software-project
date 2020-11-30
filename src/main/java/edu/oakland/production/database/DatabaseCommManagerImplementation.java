package edu.oakland.production.database;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;

public class DatabaseCommManagerImplementation implements DatabaseCommManager {

  DatabasePersistentStorage dps;

  public DatabaseCommManagerImplementation(DatabasePersistentStorage dps) {

    if (dps == null){
      throw new IllegalArgumentException("DatabasePersistentStorage cannot be null");
    }
  }

  public int passGetRfidRequest() {
    return 0;
  }

  public LocationDataPoint passGetLocationDataPointRequest(int offset) {
    return null;
  }

  public TrackData passGetTrackDataRequest(int offset) {
    return null;
  }

  public void passStoreTrackDataRequest(TrackData trackData) {

  }

  public String passGetModeRequest() {
    return "";
  }
}
