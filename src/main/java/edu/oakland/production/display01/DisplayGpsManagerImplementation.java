package edu.oakland.production.display01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;
import edu.oakland.production.middleware01.MiddlewareGisInterface;
import java.lang.IllegalArgumentException;

public class DisplayGpsManagerImplementation implements DisplayGpsManager {
  
  private MiddlewareGisInterface gisInterface;

  public DisplayGpsManagerImplementation(MiddlewareGisInterface gisInterface) {
    if (gisInterface == null) {
      throw new IllegalArgumentException("middelewareGisInterface cannot be null");
    }
    this.gisInterface = gisInterface;
  }

  public String receiveGpsSignalStrength(Satellite satelliteSignal) {
    return gisInterface.receiveGpsSignalStrengthUc1(satelliteSignal);
  }

  public SatelliteSignalCheckRequest passGpsSignalStrength(Satellite satelliteSignal) {
    return null;

  }

}
