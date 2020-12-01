package edu.oakland.test.display01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;

public class DisplayGpsReceiverStub {

  /** 
   * Measures GPS Signal Strength.
   *
   * @param satelliteSignal GPS signal to measure.
   * @return Status of GPS signal measured.
   */
  public String measureGpsSignalStrength(Satellite satelliteSignal) {
    Satellite s = satelliteSignal;
    return s.getName();

  }

  /**
   * Checks for origin GPS satellite of received signal.
   *
   * @param satelliteSignal GPS satellite to determine origin of signal.
   * @return Request to reconnect to satellite.
   */
  public SatelliteSignalCheckRequest measureSignal(Satellite satelliteSignal) {
    SatelliteSignalCheckRequest request = new SatelliteSignalCheckRequest(satelliteSignal.getName(),"Type 2");
    return request;

  }

}
