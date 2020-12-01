package edu.oakland.test.display02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.display02.DisplayComm2WayInterface;
import edu.oakland.production.display02.DisplayCommManager;

public class DisplayCommManagerStub implements DisplayCommManager {
  /**
  * Stub method, recieves the rfid
  * and returns a blank TrackData.
  */
  public TrackData requestRfid(int rfid) {
    TrackData trackStub = new TrackData(new LocationDataPoint[0]);
    trackStub.setStatusMessage(String.valueOf(rfid));
    return trackStub;
  }
}
