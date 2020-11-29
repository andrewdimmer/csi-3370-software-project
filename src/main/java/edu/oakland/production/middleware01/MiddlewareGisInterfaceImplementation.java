package edu.oakland.production.middleware01;

import edu.oakland.production.middleware01.MiddlewareGisInterface;
import edu.oakland.helper.admin.Satellite;

public class MiddlewareGisInterfaceImplementation implements MiddlewareGisInterface {

  private MiddlewareGisProcessor middlewareGisProcessor;

  public MiddlewareGisInterfaceImplementation(MiddlewareGisProcessor middlewareGisProcessor){
    this.middlewareGisProcessor = middlewareGisProcessor;
    if (this.middlewareGisProcessor == null) {
      throw new IllegalArgumentException("processor cannot be null");
    }
  }

  public String receiveGpsSignalStrengthUc1(Satellite satelliteSignal) {
    return middlewareGisProcessor.evaluateGpsSignalStrength(satelliteSignal);
  }

  public String receiveGpsSignalStrengthUc2(Satellite satelliteSignal) {
    return middlewareGisProcessor.measureGpsSignalStrength(satelliteSignal);
  }
}