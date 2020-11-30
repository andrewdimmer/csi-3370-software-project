package edu.oakland.production.display01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;
import java.lang.IllegalArgumentException;

public class DisplayGpsReceiverImplementation implements DisplayGpsReceiver {

  private Satellite satelliteSignal;

  /**
   * Measures GPS Signal Strength.
   *
   * @param satelliteSignal GPS signal to measure.
   */
  public void measureGpsSignalStrength(Satellite satelliteSignal) {

    Integer i = satelliteSignal.getStrength();
    String s = i.toString();
    if (s == null) {
      throw new IllegalArgumentException("Signal strength cannot be null");
    }
    this.satelliteSignal = satelliteSignal;
  }

  /**
   * Checks for origin GPS satellite of received signal.
   *
   * @param satelliteSignal GPS satellite to determine origin of signal.
   * @return Request to reconnect to satellite.
   */
  public SatelliteSignalCheckRequest measureSignal(Satellite satelliteSignal) {
        
    return null;

  }

}
