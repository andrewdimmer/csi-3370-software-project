package edu.oakland.production.middleware02;

import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.middleware01.MiddlewareGisManager;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterface;

public class MiddlewareCommLinkManagerImplementation implements MiddlewareCommLinkManager {

  public MiddlewareCommLinkManagerImplementation(
      MiddlewareCommDatabaseInterface midDatabaseInterface,
      MiddlewareGisManager gisManager
  ) {
    
  }

  public TrackData checkCurrentRfid(int rfid) {
    return null;
  }

}
