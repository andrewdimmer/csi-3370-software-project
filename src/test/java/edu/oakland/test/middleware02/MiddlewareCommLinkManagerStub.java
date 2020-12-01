package edu.oakland.test.middleware02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.middleware02.MiddlewareCommLinkManager;

/**
*<p>
*This class shall get the current rfid and set it in trackdata.
*</p>
*/

public class MiddlewareCommLinkManagerStub implements MiddlewareCommLinkManager {
  
  /**
   *<p>
   * This class set the status message in track data to a string of Rfid.
   *</p>
  */

  public TrackData checkCurrentRfid(int rfid) {
    TrackData trackD = new TrackData(new LocationDataPoint[0]);
    trackD.setStatusMessage(String.valueOf(rfid));
    return trackD;

  }
    
}
