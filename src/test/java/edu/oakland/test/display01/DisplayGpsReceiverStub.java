package edu.oakland.test.display01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;
import edu.oakland.production.display01.DisplayGpsReceiver;

public class DisplayGpsReceiverStub implements DisplayGpsReceiver {

  /** 
   * Measures GPS Signal Strength.
   *
   * @param satelliteSignal GPS signal to measure.
   * @return Status of GPS signal measured.
   */
  public String measureGpsSignalStrength(Satellite satelliteSignal) {
    Satellite s = satelliteSignal;
    return s.getSatelliteName();

  }

  /**
   * Checks for origin GPS satellite of received signal.
   *
   * @param satelliteSignal GPS satellite to determine origin of signal.
   * @return Request to reconnect to satellite.
   */
  public SatelliteSignalCheckRequest measureSignal(Satellite satelliteSignal) {
    SatelliteSignalCheckRequest request;
    request = new SatelliteSignalCheckRequest(satelliteSignal.getSatelliteName(), "Type 2");
    return request;

  }

}
