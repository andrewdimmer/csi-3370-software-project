package edu.oakland.test.middleware02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.database.DatabaseCommInterface;

public class DatabaseCommInterfaceStub implements DatabaseCommInterface {
  private int rfid;
  private String mode;
  private LocationDataPoint locationDataPoint;
  private TrackData trackData;
  
  public DatabaseCommInterfaceStub() {

  }

  public DatabaseCommInterfaceStub(int rfid) {
    this.rfid = rfid;
  }

  public DatabaseCommInterfaceStub(String mode) {
    this.mode = mode;
  }

  public DatabaseCommInterfaceStub(LocationDataPoint locationDataPoint) {
    this.locationDataPoint = locationDataPoint;
  }
  
  public int receiveGetRfidRequest() {
    return rfid;
  }
  
  public String receiveGetModeRequest() {
    return mode;
  }
  
  public void storeTrackDataRequest(TrackData trackData) {
      this.trackData = trackData;
  }
  
  public LocationDataPoint receiveGetLocationDataPointRequest(int offset) {
    return locationDataPoint;
  }
  
  public TrackData receiveGetTrackDataRequest(int offset) {
    return trackData;
  }
}
