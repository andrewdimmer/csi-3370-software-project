package edu.oakland.test.middleware02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterface;

public class MiddlewareCommDatabaseInterfaceStub implements MiddlewareCommDatabaseInterface {

  private int rfid;

  public MiddlewareCommDatabaseInterfaceStub(int rfid) {
    this.rfid = rfid;
  }

  public int checkCurrentRfid() {
    return rfid;
  }

  public String requestMode() {
    String st = "String";
    return st;
  }

  public TrackData getTrackData() {
    int offset = 0;
    return null;
  }
  
}