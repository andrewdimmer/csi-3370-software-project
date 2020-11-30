package edu.oakland.production.middleware02;

import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.middleware02.MiddlewareCommInterface;
/** 
* This class shall recieve the RFID from display and pass it to MiddlwareCommLinkManager.
*
*/
public class MiddlewareCommInterfaceImplementation implements MiddlewareCommInterface {
  int rfid;
  
  private MiddlewareCommLinkManager middlewareManager;
  /** 
   * Creates a MiddlewareCommInterfaceImplementation to recive the Rfid.
   * 
   * @param middlewareManager the class that this class will pass the Rfid to.
   * 
  */

  public MiddlewareCommInterfaceImplementation(MiddlewareCommLinkManager middlewareManager) {
    if(middlewareManager == null) {
    throw new IllegalArgumentException("middlewareManager cannot be null");
    }
    this.middlewareManager = middlewareManager;
  }

  /**
   * Receives the rfid for Use Case 1.
   * 
   * @return rfid.
   */

  public TrackData requestRfid(int rfid) {
    return middlewareManager.checkCurrentRfid(rfid);
  }

} 
