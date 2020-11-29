package edu.oakland.test.middleware01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.middleware01.MiddlewareGisProcessor;

public class MiddlewareGisProcessorStub implements MiddlewareGisProcessor {
    
  public String evaluateGpsSignalStrength(Satellite satelliteSignal) {
    return satelliteSignal.getSatelliteName();      
  }

  public String measureGpsSignalStrength(Satellite satelliteSignal) {
    return satelliteSignal.getSatelliteName();
  }

}
