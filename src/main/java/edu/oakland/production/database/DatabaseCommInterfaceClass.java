package edu.oakland.production.database;

import edu.oakland.production.database.DatabaseCommManager;
import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;

public class DatabaseCommInterfaceClass {
  
  DatabaseCommManager databaseCommManager;

  public DatabaseCommInterfaceClass(DatabaseCommManager databaseCommManager) {
    if (databaseCommManager == null) {
      throw new IllegalArgumentException("manager cannot be null");
    }
    
    this.databaseCommManager = databaseCommManager;
  }
  
  public int receiveGetRfidRequest() {
    return databaseCommManager.passGetRfidRequest();
  }
  
  public LocationDataPoint receiveGetLocationDataPointRequest(int offset) {
    return databaseCommManager.passGetLocationDataPointRequest(offset);
  }
  
  public TrackData receiveGetTrackDataRequest(int offset) {
    return databaseCommManager.passGetTrackDataRequest(offset);
  }
  
  public void storeTrackDataRequest(TrackData trackData) {
    databaseCommManager.passStoreTrackDataRequest(trackData);
  }
  
  public String receiveGetModeRequest() {
    return databaseCommManager.passGetModeRequest(); 
  }
  
}
