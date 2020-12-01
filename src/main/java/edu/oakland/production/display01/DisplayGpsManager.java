package edu.oakland.production.display01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;

public interface DisplayGpsManager {

  public String receiveGpsSignalStrength(Satellite satelliteSignal);

  public SatelliteSignalCheckRequest passGpsSignalStrength(Satellite satelliteSignal);

}
