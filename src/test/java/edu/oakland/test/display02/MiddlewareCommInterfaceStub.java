package edu.oakland.test.display02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.display02.DisplayCommManager;
import edu.oakland.production.middleware02.MiddlewareCommInterface;

/*
* Stub Method of MiddlewareCommInterface.
* Used solely for testing.
*/
public class MiddlewareCommInterfaceStub implements MiddlewareCommInterface {
  
  /*
  * Stub method, recieves the rfid
  * and returns a blank TrackData.
  */
  public TrackData requestRfid(int rfid) {
    TrackData trackStub = new TrackData(new LocationDataPoint[0]);
    trackStub.setStatusMessage(String.valueOf(rfid));
    return trackStub;
  }
}
