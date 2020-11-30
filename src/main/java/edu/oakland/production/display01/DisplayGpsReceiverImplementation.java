package edu.oakland.production.display01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;

public class DisplayGpsReceiverImplementation implements DisplayGpsReceiver {

  /** 
   * Measures GPS Signal Strength.
   *
   * @param satelliteSignal GPS signal to measure.
   * @return Status of GPS signal measured.
   */
  public String measureGpsSignalStrength(Satellite satelliteSignal) {

    return "";

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
