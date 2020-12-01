package edu.oakland.test.admin;

import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.display02.DisplayCommInterface;

/**
 * A test class to act as a stub for DisplayGpsInterface
 *
 * @author Tessa Peruzzi
 * @version %I%, %G%
 */
public class DisplayCommInterfaceStub implements DisplayCommInterface {

  public TrackData receiveRfidRequest(int rfidNum) {
    return null;  
  }
   
}
