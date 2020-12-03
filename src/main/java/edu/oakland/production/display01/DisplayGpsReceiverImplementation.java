package edu.oakland.production.display01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.display01.DisplayGpsManager;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;
import java.lang.IllegalArgumentException;

public class DisplayGpsReceiverImplementation implements DisplayGpsReceiver {

  private DisplayGpsManager displayGpsManager;

  /**
   * Checks whether or not passed displayGpsManager value is null.
   *
   * @param displayGpsManager Calls on displayGpsManager to check value for null.
   */
  public DisplayGpsReceiverImplementation(DisplayGpsManager displayGpsManager) {
    if (displayGpsManager == null) {
      throw new IllegalArgumentException("displayGpsManager cannot be null");
    }
    this.displayGpsManager = displayGpsManager;
  }

  /**
   * Measures GPS Signal Strength.
   *
   * @param satelliteSignal GPS signal to measure.
   */
  public String measureGpsSignalStrength(Satellite satelliteSignal) {
    if (satelliteSignal == null) {
      throw new IllegalArgumentException("satelliteSignal cannot be null");
    }
    return displayGpsManager.receiveGpsSignalStrength(satelliteSignal);
  }

  /**
   * Checks for origin GPS satellite of received signal.
   *
   * @param satelliteSignal GPS satellite to determine origin of signal.
   * @return Request to reconnect to satellite.
   */
  public SatelliteSignalCheckRequest measureSignal(Satellite satelliteSignal) {
    if (satelliteSignal == null) {
      throw new IllegalArgumentException("satelliteSignal cannot be null");
    }
    return displayGpsManager.passGpsSignalStrength(satelliteSignal);
  }
}
