package edu.oakland.production.middleware01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.middleware01.MiddlewareGisProcessor;

public class MiddlewareGisProcessorImplementation implements MiddlewareGisProcessor {

  private MiddlewareGisManager middlewareGisManager;

  public MiddlewareGisProcessorImplementation(MiddlewareGisManager middlewareGisManager) {
    if (this.middlewareGisManager == null) {
      throw new IllegalArgumentException("manager cannot be null");
    }        
    this.middlewareGisManager = middlewareGisManager;
  }

  public String evaluateGpsSignalStrength(Satellite satelliteSignal) {
    return middlewareGisManager.receiveGpsSignalStrength(satelliteSignal);
  }

  public String measureGpsSignalStrength(Satellite satelliteSignal) {
    // UNCOMMENT LATER int signal = satelliteSignal.strengthIsValid(satelliteSignal.getStrength());
    int signal = 5;
    return middlewareGisManager.evaluateGpsSignalStrength(signal);
  }   
}