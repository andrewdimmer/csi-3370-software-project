package edu.oakland.test.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.LocationDataPoint;
import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LocationDataPoint Unit Tests")
public class LocationDataPointTests {

  @Test
  @DisplayName("Lat In Is the same Lat Out")
  void validLatInIsLatOut() {
    float lat = generateRandomLat();
    LocationDataPoint locationDataPoint = new LocationDataPoint(
        lat,
        generateRandomLng(),
        generateRandomTime()
    );
    assertEquals(lat, locationDataPoint.getLat(), .001);
  }

  @Test
  @DisplayName("Lat AND Lng Roll Over After Crossing the North Pole")
  void crossNorthPole() {
    float latOffset = 90 + generateRandomLatNoEdgeCases(); // Between 5 & 175 degrees past the pole
    float originalLng = generateRandomLngNoEdgeCases();
    float inputLat = 90 + latOffset;
    LocationDataPoint locationDataPoint = new LocationDataPoint(
        inputLat,
        originalLng,
        generateRandomTime()
    );
    float expectedLat = 90 - latOffset;
    float expectedLng = originalLng + 180 * (originalLng > 0 ? -1 : 1);
    assertEquals(expectedLat, locationDataPoint.getLat(), .001);
    assertEquals(expectedLng, locationDataPoint.getLng(), .001);
  }

  @Test
  @DisplayName("Lat AND Lng Roll Over After Crossing the South Pole")
  void crossSouthPole() {
    float latOffset = 90 + generateRandomLatNoEdgeCases(); // Between 5 & 175 degrees past the pole
    float originalLng = generateRandomLngNoEdgeCases();
    float inputLat = -90 - latOffset;
    LocationDataPoint locationDataPoint = new LocationDataPoint(
        inputLat,
        originalLng,
        generateRandomTime()
    );
    float expectedLat = -90 + latOffset;
    float expectedLng = originalLng + 180 * (originalLng > 0 ? -1 : 1);
    assertEquals(expectedLat, locationDataPoint.getLat(), .001);
    assertEquals(expectedLng, locationDataPoint.getLng(), .001);
  }

  @Test
  @DisplayName("Lat AND Lng Roll Over After Crossing the Poles Multiple Times going North")
  void crossPolesMultipleTimesGoingNorth() {
    float latOffset = 90 + generateRandomLatNoEdgeCases(); // Between 5 & 175 degrees past the pole
    float originalLng = generateRandomLngNoEdgeCases();
    int extraHalfTrips = (int) (Math.random() + 18 + 2);
    float inputLat = 90 + latOffset + 180 * extraHalfTrips;
    LocationDataPoint locationDataPoint = new LocationDataPoint(
        inputLat,
        originalLng,
        generateRandomTime()
    );
    float expectedLat = (90 - latOffset) * (extraHalfTrips % 2 == 0 ? 1 : -1);
    int lngModifier = 180 * (originalLng > 0 ? -1 : 1) * (extraHalfTrips % 2 == 0 ? 1 : 0);
    float expectedLng = originalLng + lngModifier;
    assertEquals(expectedLat, locationDataPoint.getLat(), .001);
    assertEquals(expectedLng, locationDataPoint.getLng(), .001);
  }

  @Test
  @DisplayName("Lat AND Lng Roll Over After Crossing the Poles Multiple Times going South")
  void crossPolesMultipleTimesGoingSouth() {
    float latOffset = 90 + generateRandomLatNoEdgeCases(); // Between 5 & 175 degrees past the pole
    float originalLng = generateRandomLngNoEdgeCases();
    int extraHalfTrips = (int) (Math.random() + 18 + 2);
    float inputLat = -90 - latOffset - 180 * extraHalfTrips;
    LocationDataPoint locationDataPoint = new LocationDataPoint(
        inputLat,
        originalLng,
        generateRandomTime()
    );
    float expectedLat = (-90 + latOffset) * (extraHalfTrips % 2 == 0 ? 1 : -1);
    int lngModifier = 180 * (originalLng > 0 ? -1 : 1) * (extraHalfTrips % 2 == 0 ? 1 : 0);
    float expectedLng = originalLng + lngModifier;
    assertEquals(expectedLat, locationDataPoint.getLat(), .001);
    assertEquals(expectedLng, locationDataPoint.getLng(), .001);
  }

  @Test
  @DisplayName("Lng In Is the same Lng Out")
  void validLngInIsLngOut() {
    float lng = generateRandomLng();
    LocationDataPoint locationDataPoint = new LocationDataPoint(
        generateRandomLat(),
        lng,
        generateRandomTime()
    );
    assertEquals(lng, locationDataPoint.getLng(), .001);
  }

  @Test
  @DisplayName("Lng Rolls Over When Crossing the Antimeridian from West to East")
  void crossAntimeridianWestToEast() {
    float lng = generateRandomLngNoEdgeCases();
    float newLng = lng - 360;
    LocationDataPoint locationDataPoint = new LocationDataPoint(
        generateRandomLat(),
        newLng,
        generateRandomTime()
    );
    assertEquals(lng, locationDataPoint.getLng(), .001);
  }

  @Test
  @DisplayName("Lng Rolls Over When Crossing the Antimeridian from East to Wests")
  void crossAntimeridianEastToWest() {
    float lng = generateRandomLngNoEdgeCases();
    float newLng = lng + 360;
    LocationDataPoint locationDataPoint = new LocationDataPoint(
        generateRandomLat(),
        newLng,
        generateRandomTime()
    );
    assertEquals(lng, locationDataPoint.getLng(), .001);
  }

  @Test
  @DisplayName("Lng Rolls Over When Crossing the Antimeridian from West to East Multiple Times")
  void crossAntimeridianWestToEastMultipleTimes() {
    float lng = generateRandomLngNoEdgeCases();
    float newLng = lng - 360 * (int) (Math.random() * 18 + 2);
    LocationDataPoint locationDataPoint = new LocationDataPoint(
        generateRandomLat(),
        newLng,
        generateRandomTime()
    );
    assertEquals(lng, locationDataPoint.getLng(), .001);
  }

  @Test
  @DisplayName("Lng Rolls Over When Crossing the Antimeridian from East to West Multiple Times")
  void crossAntimeridianEastToWestMultipleTimes() {
    float lng = generateRandomLngNoEdgeCases();
    float newLng = lng + 360 * (int) (Math.random() * 18 + 2);
    LocationDataPoint locationDataPoint = new LocationDataPoint(
        generateRandomLat(),
        newLng,
        generateRandomTime()
    );
    assertEquals(lng, locationDataPoint.getLng(), .001);
  }

  @Test
  @DisplayName("LocalDateTime in is the same LocalDateTime out")
  void timeInIsTimeOut() {
    LocalDateTime time = generateRandomTime();
    LocationDataPoint locationDataPoint = new LocationDataPoint(
        generateRandomLat(),
        generateRandomLng(),
        time
    );
    assertEquals(time, locationDataPoint.getTime());
  }

  @Test
  @DisplayName("Verifies that time cannot be set to null")
  void nullTimesAreNotAllowed() { 
    assertThrows(IllegalArgumentException.class, () -> {
      new LocationDataPoint(generateRandomLat(), generateRandomLng(), null);
    });
  }

  private float generateRandomLat() {
    return (float) (Math.random() * 180 - 90);
  }

  private float generateRandomLng() {
    return (float) (Math.random() * 360 - 180);
  }

  private float generateRandomLatNoEdgeCases() {
    return (float) (Math.random() * 170 - 85);
  }

  private float generateRandomLngNoEdgeCases() {
    return (float) (Math.random() * 350 - 175);
  }

  private LocalDateTime generateRandomTime() {
    return LocalDateTime.of(
      (int) (Math.random() * 50 + 1970),
      (int) (Math.random() * 12 + 1),
      (int) (Math.random() * 28 + 1),
      (int) (Math.random() * 24),
      (int) (Math.random() * 60)
    );
  }
}
