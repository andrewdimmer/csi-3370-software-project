package edu.oakland.helper.admin;

import edu.oakland.helper.admin.LocationDataPoint;
import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;

/**
 * A common helper class to store simulate satellite connections to the Secure Lock Tracking
 * Software shipping container.
 *
 * @author Tessa Peruzzi
 * @version %I%, %G%
 */
public class Satellite {
  private String satelliteName;
  private int strength;
  private static float incrementLatAmount;
  private static float incrementLngAmount;
  private static LocationDataPoint initLocationDataPoint;
  private static int countGetLocationCalls = -1;

  /**
   * Creates a new Satellite object with the given name and strength.
   *
   * @param satelliteName The satellite name (this is immutable, and should be unique).
   * @param strength The satellite signal strength from 1 to 10 (this can be changed later).
   */
  public Satellite(String satelliteName, int strength) {
    if (!strengthIsValid(strength)) {
      throw new IllegalArgumentException("Strength must be between one and ten");
    }
    this.satelliteName = satelliteName;
    this.strength = strength;
  }

  /**
   * Gets the name of the satellite. This should be unique to this object.
   *
   * @return The name of the satellite.
   */
  public String getSatelliteName() {
    return satelliteName;
  }

  /**
   * Gets the current signal strength of this satellite in relation to the of the Secure Lock
   * Tracking System shipping container.
   *
   * @return The current signal strength.
   */
  public int getStrength() {
    return strength;
  }

  /**
   * Allows the user to update the single strength of this satellite's connection to the Secure
   * Lock Tracking System shipping container.
   *
   * @param strength The new strength of the satellite connection (between 1 and 10).
   */
  public void setStrength(int strength) {
    if (!strengthIsValid(strength)) {
      throw new IllegalArgumentException("Strength must be between one and ten");
    }
    this.strength = strength;
  }

  /**
   * Generates the next location that the Secure Lock Tracking System shipping container is at.
   * For sake of simplicity when simulating the satellite connection, we currently assume that
   * the shipping container appears to be moving in the same direction and at the same speed no
   * matter which satellites it is connected to.
   */
  public LocationDataPoint getLocation() {
    countGetLocationCalls++;
    float lat = generateNewLocationDataPointLat();
    float lng = generateNewLocationDataPointLng();
    LocalDateTime time = generateNewLocationDataPointTime();
    LocationDataPoint thePoint = new LocationDataPoint(lat, lng, time);
    return thePoint;
  }

  /**
   * Validates that the signal strength is between 1 and 10 inclusive.
   *
   * @param strength The signal strength to validate.
   * @return true if the singal strength is valid (between 1 and 10 inclusive); false otherwise.
   */
  private boolean strengthIsValid(int strength) {
    return strength >= 1 && strength <= 10;
  }

  /**
   * Sets the initial speed and direction configuration for the group of satellites that is
   * connected to the Secure Lock Tracking System shipping container. Note that this configuration
   * is shared across all satellites, but can be reset for all satellites by calling this method
   * again.
   *
   * @param incLatA The amount to increment the latitude for each hour the shipping container is
   *                traveling.
   * @param incLngA The amount to increment the longitude for each hour the shipping container is
   *                traveling.
   * @param initPoint The inital LocationDataPoint of the shipping container the first time it
   *                  connects to the Secure Lock Tracking System after coming online.
   */
  public static void satelliteInit(float incLatA, float incLngA, LocationDataPoint initPoint) {
    countGetLocationCalls = -1;
    incrementLatAmount = incLatA;
    incrementLngAmount = incLngA;
    initLocationDataPoint = initPoint;
  }

  /**
   * Creates the new latitude of the shipping container based on how much simulated time has
   * passed. It is assumed to be 1 hour between each ping for simplicity.
   */
  private static float generateNewLocationDataPointLat() {
    return initLocationDataPoint.getLat() + (incrementLatAmount * countGetLocationCalls);
  }

  /**
   * Creates the new longitude of the shipping container based on how much simulated time has
   * passed. It is assumed to be 1 hour between each ping for simplicity.
   */
  private static float generateNewLocationDataPointLng() {
    return initLocationDataPoint.getLng() + (incrementLngAmount * countGetLocationCalls);
  }

  /**
   * Creates the new timestamp of the shipping container location based on how much simulated time
   * has passed. It is assumed to be 1 hour between each ping for simplicity.
   */
  private static LocalDateTime generateNewLocationDataPointTime() {
    LocalDateTime theNewTime = initLocationDataPoint.getTime();
    return theNewTime.plusHours(countGetLocationCalls);
  }
}