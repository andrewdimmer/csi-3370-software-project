package edu.oakland.production.middleware01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.middleware01.MiddlewareGisProcessor;
import java.lang.IllegalArgumentException;

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
    boolean signal = satelliteSignal.strengthIsValid(satelliteSignal.getStrength());
    return middlewareGisManager.evaluateGpsSignalStrength(signal);
  }   
}