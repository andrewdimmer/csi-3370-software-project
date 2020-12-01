package edu.oakland.test.admin;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.display01.DisplayGpsInterface;
import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;

/**
 * A test class to act as a stub for DisplayGpsInterface.
 *
 * @author Brendan Fraser
 * @version %I%, %G%
 */
public class DisplayGpsInterfaceStub implements DisplayGpsInterface {

  public boolean receiveGpsSignal(Satellite satelliteSignal) {
    return true;
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