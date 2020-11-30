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
    return dps.locateRfidData();
  }

  public LocationDataPoint passGetLocationDataPointRequest(int offset) {
    return dps.getLocationDataPoint(offset);
  }

  public TrackData passGetTrackDataRequest(int offset) {
    return dps.getTrackData(offset);
  }

  public void passStoreTrackDataRequest(TrackData trackData) {
    dps.storeTrackData(trackData);
  }

  public String passGetModeRequest() {
    return dps.getMode();
  }
}
