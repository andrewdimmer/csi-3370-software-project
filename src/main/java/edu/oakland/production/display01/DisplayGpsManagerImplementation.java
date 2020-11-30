package edu.oakland.production.display01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;

public class DisplayGpsManagerImplementation implements DisplayGpsManager {
    
  public String receiveGpsSignalStrength(Satellite satelliteSignal) {
    if (satelliteSignal.getStrength() > 4) {
      return "Acceptable";
    }
    else {
      return "Poor";
  }
}
  public SatelliteSignalCheckRequest passGpsSignalStrength(Satellite satelliteSignal) {
    return null;

  }

}
