package edu.oakland.production.middleware01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.middleware01.MiddlewareGisProcessor;
import java.lang.IllegalArgumentException;

/**
 * This class shall evaluate and measure the Satellite 
 * Signal strength passed in from the MiddlewareGisInterface.
 *
 */

public class MiddlewareGisProcessorImplementation implements MiddlewareGisProcessor {

  private MiddlewareGisManager middlewareGisManager;

  /**
   * Creates a MiddlewareGisProcessorImplementation to receive the Satellite signal.
   *
   * @param middlewareGisManager  The class that this class will pass the Satellite signal to.
   *
   */
  public MiddlewareGisProcessorImplementation(MiddlewareGisManager middlewareGisManager) {
    this.middlewareGisManager = middlewareGisManager;
    if (this.middlewareGisManager == null) {
      throw new IllegalArgumentException("manager cannot be null");
    }        
  }
  
  /**
   * Evaluates the Gps Signal Strength.
   *
   * @return The Signal Strength.
   */
  public String evaluateGpsSignalStrength(Satellite satelliteSignal) {
    return middlewareGisManager.receiveGpsSignalStrength(satelliteSignal);
  }

  /**
   * Measures the Gps Signal Strength.
   *
   * @return The Signal Strength.
   */
  public String measureGpsSignalStrength(Satellite satelliteSignal) {
    boolean signal = isStrongEnough(satelliteSignal.getStrength());
    return middlewareGisManager.evaluateGpsSignalStrength(signal);
  }

  /**
   * Is the signal strength strong enough.
   *
   * @return True or false.
   */
  private boolean isStrongEnough(int strength) {
    return strength >= 1 && strength <= 10;
  }
}