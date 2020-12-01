package edu.oakland.test.display01;


import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;
import edu.oakland.production.display01.DisplayGpsManager;


public class DisplayGpsManagerStub implements DisplayGpsManager {

  private String checkType = "oreo";
  
  /**
   * Receives Gps Signal Strength and pulls satellite name.
   *
   * @param satelliteSignal passes satellite object to pull name and checktype from
   */
  public String receiveGpsSignalStrength(Satellite satelliteSignal) {
    return satelliteSignal.getSatelliteName();
  }

  /**
   * Receives Gps Signal Strength and pulls satellite name.
   *
   * @param satelliteSignal passes satellite object to pull name and checktype from
   */
  public SatelliteSignalCheckRequest passGpsSignalStrength(Satellite satelliteSignal) {
    SatelliteSignalCheckRequest ssrc = 
        new SatelliteSignalCheckRequest(satelliteSignal.getSatelliteName(), checkType);
    return ssrc;           
  }

}
