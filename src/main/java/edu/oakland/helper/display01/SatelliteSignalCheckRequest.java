package edu.oakland.helper.display01;

import java.lang.IllegalArgumentException;

/**
 * A common helper class to check name and type of the Satellite Signal for the Secure Lock
 * Tracking Software shipping container.
 *
 * @author John Akroush, Steven Catherman
 */

public class SatelliteSignalCheckRequest {

  final String satelliteName;
  final String checkType;

  /**
   * Creates a SatelliteSignalCheckRequest to check the satellite name and type of the
   * Satellite Signal for Secure Lock Tracking Software shipping container.
   *
   * @param satelliteName  The name of the satellite of the Secure Lock
    * Tracking Software shipping container.
   * @param checkType  The type of the Secure Lock Tracking Software shipping container.
   */

  public SatelliteSignalCheckRequest(String satelliteName, String checkType) {
    //Validate name and type
    if (satelliteName == null) {
      throw new IllegalArgumentException("name cannot be null");
    }

    if (checkType == null) {
      throw new IllegalArgumentException("type cannot be null");
    }

    if (satelliteName.length() == 0) {
      throw new IllegalArgumentException("sattellite name cannot be empty");
    }
    if (checkType.length() == 0) {
      throw new IllegalArgumentException("check type cannot be empty");
    }
    
    
    this.satelliteName = satelliteName;
    this.checkType = checkType;
  }

  /**
   * Gets the Name of the satellite of the Secure Lock Tracking Software shipping container.
   *
   * @return The name of the satellite of the Secure Lock Tracking Software shipping container.
   */
  public String getSatelliteName() {
    return satelliteName;
  }

  /**
   * Gets the type of the satellite of the Secure Lock Tracking Software shipping container.
   *
   * @return The type of the satellite of the Secure Lock Tracking Software shipping container.
   */
  public String getCheckType() {
    return checkType;
  }
}
