package edu.oakland.production.middleware01;

import edu.oakland.helper.admin.Satellite;

public interface MiddlewareGisManager {
    
  public String receiveGpsSignalStrength(Satellite satelliteSignal);
    
  public void storeLocationDataPoint();
    
  public String evaluateGpsSignalStrength(Satellite satellite);

}
