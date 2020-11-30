package edu.oakland.production.middleware02;

import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.middleware02.MiddlewareCommInterface;

public class MiddlewareCommInterfaceImplementation implements MiddlewareCommInterface {
  int rfid;
  
  private MiddlewareCommLinkManager middlewareManager;

  public MiddlewareCommInterfaceImplementation(MiddlewareCommLinkManager middlewareManager) {
    if(middlewareManager == null) {
      throw new IllegalArgumentException("middlewareManager cannot be null");
    }
    this.middlewareManager = middlewareManager;
  }

  public TrackData requestRfid(int rfid) {
    return middlewareManager.checkCurrentRfid(rfid);
  }

} 
