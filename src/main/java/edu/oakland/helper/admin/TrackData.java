package edu.oakland.helper.admin;

import edu.oakland.helper.admin.LocationDataPoint;

public class TrackData {

  final LocationDataPoint[] points;
  final float courseDirection;
  final float speed;
  final boolean validData;

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
    if (points.length > 360) {
      throw new IllegalArgumentException("courseDirection must be less than 360 degrees");
    }

    this.points = points;
    this.courseDirection = courseDirection;
    this.speed = speed;
    this.validData = true;
  }

  public boolean isValid() {
    return validData;
  }

  public float getCourseDirection() {
    return courseDirection;
  }

  public float getSpeed() {
    return speed;
  }

  public LocationDataPoint[] getLocationDataPoints() {
    return points;
  }

  public String getStatusMessage() {
    return "";
  }

  public void setStatusMessage(String statusMessage) {

  }
}