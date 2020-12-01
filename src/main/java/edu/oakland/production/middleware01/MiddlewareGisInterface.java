package edu.oakland.production.middleware01;

import edu.oakland.helper.admin.Satellite;

public interface MiddlewareGisInterface {
    
  public String receiveGpsSignalStrengthUc1(Satellite satelliteSignal);

  public String receiveGpsSignalStrengthUc2(Satellite satelliteSignal);

}
