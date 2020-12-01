package edu.oakland.test.middleware02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.database.DatabaseCommInterface;

public class DatabaseCommInterfaceStub implements DatabaseCommInterface {
  private int rfid;
  public DatabaseCommInterfaceStub(int rfid){
    this.rfid = rfid;
  }
  public int receiveGetRfidRequest() {
    return rfid;
  }
  public String receiveGetModeRequest() {
    return null;
  }
  public void storeTrackDataRequest(TrackData trackData) {
      
  }
  public LocationDataPoint receiveGetLocationDataPointRequest(int offset) {
    return null;
  }
  public TrackData receiveGetTrackDataRequest(int offset) {
    return null;
  }
}
