package edu.oakland.production.display01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;

public class DisplayGpsReceiverImplementation {

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
   * @param satelliteName GPS satellite for origin of signal.
   * @return Request to reconnect to satellite.
   */
  public SatelliteSignalCheckRequest measureSignal(String satelliteName) {
        
    return null;

  }

}
