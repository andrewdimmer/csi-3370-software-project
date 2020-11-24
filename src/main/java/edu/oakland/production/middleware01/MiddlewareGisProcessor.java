package edu.oakland.production.middleware01;

import edu.oakland.helper.admin.Satellite;

public interface MiddlewareGisProcessor {
    
  public String evaluateGpsSignalStrength(Satellite satelliteSignal);

  public String measureGpsSignalStrength(Satellite satelliteSignal);

}
