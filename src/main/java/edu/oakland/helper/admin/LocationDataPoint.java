package edu.oakland.helper.admin;

import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;

public class LocationDataPoint {

  final float lat;
  final float lng;
  final LocalDateTime time;

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

  public float getLat() {
    return lat;
  }

  public float getLng() {
    return lng;
  }

  public LocalDateTime getTime() {
    return time;
  }

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