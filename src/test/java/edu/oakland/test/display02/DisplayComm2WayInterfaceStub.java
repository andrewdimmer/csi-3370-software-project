package edu.oakland.test.display02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.display02.DisplayComm2WayInterface;
import edu.oakland.production.display02.DisplayCommInterface;

/**
* Stub Method of DisplayComm2WayInterface.
* Used solely for testing.
*/
public class DisplayComm2WayInterfaceStub implements DisplayComm2WayInterface {
  
  /**
  * Stub method, recieves the rfid
  * and returns a blank TrackData.
  */
  public TrackData passRfidRequest(int rfid) {
    TrackData trackStub = new TrackData(new LocationDataPoint[0]);
    trackStub.setStatusMessage(String.valueOf(rfid));
    return trackStub;
  }
}
