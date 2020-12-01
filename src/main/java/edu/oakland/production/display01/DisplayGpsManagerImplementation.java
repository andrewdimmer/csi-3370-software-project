package edu.oakland.production.display01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;

public class DisplayGpsManagerImplementation implements DisplayGpsManager {
  
  public DisplayGpsManager manager;

  public DisplayGpsManagerImplementation(DisplayGpsManager manager) {
    this.manager = manager;
  }

  psSignalStrength(Satellite satelliteSignal) {
  
  }

  public SatelliteSignalCheckRequest passGpsSignalStrength(Satellite satelliteSignal) {
    return null;

  }

}
