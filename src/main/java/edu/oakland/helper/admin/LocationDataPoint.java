package edu.oakland.helper.admin;

import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;

/**
 * A common helper class to store the latitude and longitude of the Secure Lock Tracking Software
 * shipping container at a given point in time.
 *
 * @author Andrew Dimmer
 * @version %I%, %G%
 */
public class LocationDataPoint {

  final float lat;
  final float lng;
  final LocalDateTime time;

  /**
   * Creates a LocationDataPoint to store the latitude and longitude of the Secure Lock Tracking
   * Software shipping container at a given point in time.
   *
   * @param lat  The latitude of the Secure Lock Tracking Software shipping container.
   * @param lng  The longitude of the Secure Lock Tracking Software shipping container.
   * @param time The time at which the location of the Secure Lock Tracking Software shipping
   *             container was saved.
   */
  public LocationDataPoint(float lat, float lng, LocalDateTime time) {
    // Validate time
    if (time == null) {
      throw new IllegalArgumentException("time cannot be null");
    }

    // Normalize lat and lng if go around the planet entirely
    float[] normalized = normalizeLatAndLng(lat, lng);

    this.lat = normalized[0];
    this.lng = normalized[1];
    this.time = time;
  }

  /**
   * Gets the latitude of the Secure Lock Tracking Software shipping container when this
   * LocationDataPoint was created.
   *
   * @return The latitude of the Secure Lock Tracking Software shipping container.
   */
  public float getLat() {
    return lat;
  }

  /**
   * Gets the longitude of the Secure Lock Tracking Software shipping container when this
   * LocationDataPoint was created.
   *
   * @return The longitude of the Secure Lock Tracking Software shipping container.
   */
  public float getLng() {
    return lng;
  }
  
  /**
   * Gets the time that the location of the Secure Lock Tracking Software shipping container was
   * stored.
   *
   * @return The time this LocationDataPoint was created.
   */
  public LocalDateTime getTime() {
    return time;
  }

  /**
   * Normalizes the latitude and longitude of the Secure Lock Tracking Software shipping container
   * if it passes over a pole or the antimeridian.
   *
   * @param lat The original latitude of the Secure Lock Tracking Software shipping container.
   * @param lng The original longitude of the Secure Lock Tracking Software shipping container.
   * @return The normalized [latitude,longitude] of the Secure Lock Tracking Software shipping
   *         container.
   */
  private float[] normalizeLatAndLng(float lat, float lng) {
    float[] normalized = new float[]{lat, lng};

    // Normalize lat; in doing so it changes the lng
    while (normalized[0] < -90 || normalized[0] > 90) {
      // We always perform the normalization on a postive number then flip it back when done.
      int northSouthDeterminate = normalized[0] < 0 ? -1 : 1;

      // Calculate the supplementary angle to determine what the resulting lat will be
      normalized[0] = northSouthDeterminate * (180 - (northSouthDeterminate * normalized[0]));

      // Switch between the eastern and western hemispheres when we cross the pole
      normalized[1] += 180;
    }

    // Normalize lng
    normalized[1] = normalizeLng(normalized[1]);

    return normalized;
  }

  /**
   * Normalizes the longitude of the Secure Lock Tracking Software shipping container if it passes
   * over the antimeridian.
   *
   * @param lng The original longitude of the Secure Lock Tracking Software shipping container.
   * @return The original longitude of the Secure Lock Tracking Software shipping container.
   */
  private float normalizeLng(float lng) {
    // Note: Because Java only has a remainder not a true modulo
    // We always perform the normalization on a postive number then flip it back when done.
    int makeLngPositive = lng < 0 ? -1 : 1;

    // Shift the range of lng to 0 to 360
    // Take the remainder of the degree; i.e. remove the complete trips around the Earth
    // Shift the range of lng back to -180 to 180
    return makeLngPositive * ((((makeLngPositive * lng) + 180) % 360) - 180);
  }
}