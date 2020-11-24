package edu.oakland.production;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;

public interface DisplayGpsManager {

  public String receiveGpsSignalStrengths(Satellite satelliteSignal);

  public SatelliteSignalCheckRequest passGpsSignalStrength(String satelliteName);

}
