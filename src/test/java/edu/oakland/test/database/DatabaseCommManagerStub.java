package edu.oakland.test.database;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.database.DatabaseCommManager;

public class DatabaseCommManagerStub implements DatabaseCommManager {
  private int rfid;
  private LocationDataPoint ldp = null;
  private int index = 0;
  private TrackData td = null;
  private String mode = "";

  public DatabaseCommManagerStub(int rfid) {
    this.rfid = rfid;
  }

  public int passGetRfidRequest() {
    return rfid;
  }

  public LocationDataPoint passGetLocationDataPointRequest(int offset) {
    return ldp;
  }

  public TrackData passGetTrackDataRequest(int offset) {
    index = offset;
    return td;
  }

  public void passStoreTrackDataRequest(TrackData trackData) {
    td = trackData;
  }

  public String passGetModeRequest() {
    return mode;
  }
  
  public void storeMode(String m) {
    mode = m;
  }
  
  public int getIndex() {
    return index;
  }
  
  public void storeLocationDataPoint(LocationDataPoint locationDataPoint) {
    ldp = locationDataPoint;
  }
  
}
