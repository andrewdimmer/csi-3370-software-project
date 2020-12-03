package edu.oakland.test.admin;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;
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

  public String receiveGpsSignal(Satellite satelliteSignal) {
    return "";
  }

  public SatelliteSignalCheckRequest reportGpsSignalLoss(Satellite satelliteSignal) {
    return null;
  }

  public SatelliteSignalCheckRequest recheckSignalStrength(Satellite satelliteSignal) {
    return null;
  }

  public SatelliteSignalCheckRequest checkSignalStrength(Satellite satelliteSignal) {
    return null;
  }

}