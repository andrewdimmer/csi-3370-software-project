package edu.oakland.production.display01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;

public interface DisplayGpsReceiver {
    
  public String measureGpsSignalStrength(Satellite satelliteSignal);
    
  public SatelliteSignalCheckRequest measureSignal(Satellite satelliteSignal);

}