package edu.oakland.production.middleware01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.middleware01.MiddlewareGisInterface;
import edu.oakland.production.middleware01.MiddlewareGisProcessor;

/**
 * This class shall recieve that GPS signal from display and pass it to GIS processor.
 *
 */
public class MiddlewareGisInterfaceImplementation implements MiddlewareGisInterface {

  private MiddlewareGisProcessor middlewareGisProcessor;

  /**
   * Creates a MiddlewareGisInterfaceImplementation to receive the Satellite signal.
   *
   * @param middlewareGisProcessor  The class that this class will pass the Satellite signal to.
   *
   */
  public MiddlewareGisInterfaceImplementation(MiddlewareGisProcessor middlewareGisProcessor) {
    if (middlewareGisProcessor == null) {
      throw new IllegalArgumentException("processor cannot be null");
    }
    this.middlewareGisProcessor = middlewareGisProcessor;
  }

  /**
   * Receives the Signal Strength for Use Case 1.
   *
   * @return The Signal Strength.
   */
  public String receiveGpsSignalStrengthUc1(Satellite satelliteSignal) {
    return middlewareGisProcessor.evaluateGpsSignalStrength(satelliteSignal);
  }

  /**
   * Receives the Signal Strength for Use Case 2.
   *
   * @return The Signal Strength.
   */
  public String receiveGpsSignalStrengthUc2(Satellite satelliteSignal) {
    return middlewareGisProcessor.measureGpsSignalStrength(satelliteSignal);
  }
}
