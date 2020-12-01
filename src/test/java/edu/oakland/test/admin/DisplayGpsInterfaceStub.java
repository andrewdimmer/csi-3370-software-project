package edu.oakland.test.admin;

import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.display01.DisplayGpsInterface;

/**
 * A test class to act as a stub for DisplayGpsInterface
 *
 * @author Brendan Fraser
 * @version %I%, %G%
 */
public class DisplayGpsInterfaceStub implements DisplayGpsInterface {

  public boolean receiveGpsSignal(Satellite satelliteSignal) {
    if(satelliteSignal.getStrength() < 5){
      return true;
    } else {
      return false;
    }
  }

  public String reportGpsSignalLoss(Satellite satelliteSignal) {
    return "";
  }

  public int recheckSignalStrength(Satellite satelliteSignal) {
    return 0;
  }

  public int checkSignalStrength(Satellite satelliteSignal) {
    return 0;
  }

}