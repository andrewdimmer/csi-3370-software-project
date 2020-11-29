package edu.oakland.helper.admin;

import edu.oakland.helper.admin.LocationDataPoint;

/**
 * Stores the important calculated data like speed, course direction, raw data points, and system
 * status message of the Secure Lock Tracking Software shipping container.
 *
 * @author Andrew Dimmer
 * @version %I%, %G%
 */
public class TrackData {

  final LocationDataPoint[] points;
  final float courseDirection;
  final float speed;
  final boolean validData;
  String statusMessage = "";

  /**
   * Creates a TrackData object for cases where there are not enough data points to calculate the
   * other attributes typically stored like speed and course direction.
   *
   * @param points A list of the most recent LocationDataPoints stored by the Secure Lock Tracking
   *               Software. Note: these data points will not be enough to calculate the speed
   *               and course direction, but are still stored to be plotted by the Display system.
   */
  public TrackData(LocationDataPoint[] points) {
    // Validate points array
    if (points == null) {
      throw new IllegalArgumentException("points array cannot be null");
    }
    if (points.length == 5) {
      throw new IllegalArgumentException("No valid data should not have a course and speed set");
    }

    this.points = points;
    this.courseDirection = 0;
    this.speed = 0;
    this.validData = false;
  }

  /**
   * Creates a TrackData object for cases where there are enough data points to calculate the speed
   * and course direction of the Secure Lock Tracking System shipping container. 
   *
   * @param points A list of the most recent LocationDataPoints stored by the Secure Lock Tracking
   *               Software. Note: there should be exactly 5 points to use this constructor.
   * @param courseDirection The direction in degrees from 0 to <360 of which the Secure Lock
   *                        Tracking System shipping container is moving.
   * @param speed The speed at which the Secure Lock Tracking System shipping container is moving.
   */
  public TrackData(LocationDataPoint[] points, float courseDirection, float speed) {
    // Validate points array
    if (points == null) {
      throw new IllegalArgumentException("points array cannot be null");
    }
    if (points.length < 5) {
      throw new IllegalArgumentException("Not enough points to create a valid TrackData object");
    }
    if (points.length > 5) {
      throw new IllegalArgumentException("Somehow you have TOO much data for a TrackData object");
    }

    // Validate Speed
    if (speed < 0) {
      throw new IllegalArgumentException("speed cannot be negative");
    }
    
    // Validate courseDirection
    if (courseDirection < 0) {
      throw new IllegalArgumentException("courseDirection cannot be negative");
    }
    if (courseDirection > 360) {
      throw new IllegalArgumentException("courseDirection must be less than 360 degrees");
    }

    this.points = points;
    this.courseDirection = courseDirection;
    this.speed = speed;
    this.validData = true;
  }

  /**
   * Informs the user if there was enough data to calculate the speed and course direction.
   *
   * @return true if there are 5 data points and the calculated fields have been stored;
   *         false otherwise.
   */
  public boolean isValid() {
    return validData;
  }

  /**
   * Gets the direction that the  Secure Lock Tracking System shipping container is moving. Note
   * that this is measured in degrees, and 0 degrees is due east.
   *
   * @return The direction in degrees from 0 to <360 of which the Secure Lock Tracking System
   *         shipping container is moving.
   */
  public float getCourseDirection() {
    return courseDirection;
  }

  /**
   * Gets the speed the  Secure Lock Tracking System shipping container is moving in knots.
   *
   * @return The speed at which the Secure Lock Tracking System shipping container is moving.
   */
  public float getSpeed() {
    return speed;
  }

  /**
   * Gets the original data points used to calculate the speed and course direction of the
   * Secure Lock Tracking System shipping container. This is guarenteed to be not null, but may
   * have between 0 and 5 data points depending on what data was available at the time of this
   * object's creation.
   *
   * @return The original LocationDataPoint array used to calculate the speed and course direction.
   */
  public LocationDataPoint[] getLocationDataPoints() {
    return points;
  }

  /**
   * Gets the status message associated with the current data in this TrackData object. Note that
   * this message is NOT persistent, and relates to the current usage of the data, not the data
   * itself. If no message is set, it defaults to the empty string.
   *
   * @return The status message associated with the current usage of this TrackData object.
   */
  public String getStatusMessage() {
    return statusMessage;
  }

  /**
   * Sets the status message associated with the current data in this TrackData object. Note that
   * this message is NOT persistent, and relates to the current usage of the data, not the data
   * itself. It should be set again every time this TrackData object is accessed in a new context.
   *
   * @param statusMessage The status message associated with the current usage of this TrackData
   *                      object.
   */
  public void setStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
  }
}