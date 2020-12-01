package edu.oakland.production.middleware02;

import edu.oakland.helper.admin.TrackData;

public interface MiddlewareCommLinkManager {

  public TrackData checkCurrentRfid(int rfid);

}
