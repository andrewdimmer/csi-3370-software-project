package edu.oakland.test.database;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.database.DatabaseCommManager;

public class DatabaseCommManagerStub implements DatabaseCommManager {
  private int rfid;
  LocationDataPoint ldp = null;

  public int passGetRfidRequest() {
    return rfid;
  }

  public LocationDataPoint passGetLocationDataPointRequest(int offset) {
    return ldp;
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
