package edu.oakland.test.middleware02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.helper.middleware02.TrackDataCalculator;
import java.time.Duration;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TrackDataCalculator Unit Tests")
public class TrackDataCalculatorTests {

  @Test
  @DisplayName("Calculate Speed")
  void calculateSpeedTest() { 
    Satellite.satelliteInit(
        (float) (Math.random() - .5),
        (float) (Math.random() - .5),
        generateRandomLocationDataPoint()
    );
    Satellite satellite = new Satellite("Test", 5);
    LocationDataPoint[] locations = new LocationDataPoint[(int) (Math.random() * 8) + 2];
    for (int index = locations.length - 1; index >= 0; index--) {
      // Eat up extra locations to change the time and distance traveled
      locations[index] = satellite.getLocation();
    }
    LocationDataPoint firstpoint = locations[0];
    LocationDataPoint lastpoint = locations[locations.length - 1];
    float lattitude1 = firstpoint.getLat();
    float longitude1 = firstpoint.getLng();
    float lattitude2 = lastpoint.getLat();
    float longitude2 = lastpoint.getLng();

    LocalDateTime time1 = firstpoint.getTime();
    LocalDateTime time2 = lastpoint.getTime();
    Duration duration = Duration.between(time2, time1);
    double newDuration = duration.getSeconds() / 3600.0;

    float deltaX = longitude1 - longitude2;
    float deltaY = lattitude1 - lattitude2;
    double trackLength = Math.sqrt((deltaY * deltaY) + (deltaX * deltaX));    

    double speed =  (trackLength / newDuration);

    assertEquals(speed * 60, TrackDataCalculator.calculateSpeed(locations), .01);
  }
  
  //Delta x == Lat2 - Lat1
  //Delta y == Lon2 - Lon1
  
  @Test
  @DisplayName("Calculate Direction")
  void calculateDirectionTest() {
    Satellite.satelliteInit(
        (float) (Math.random() - .5),
        (float) (Math.random() - .5),
        generateRandomLocationDataPoint()
    );
    Satellite satellite = new Satellite("Test", 5);
    LocationDataPoint[] locations = new LocationDataPoint[(int) (Math.random() * 8) + 2];
    for (int index = locations.length - 1; index >= 0; index--) {
      // Eat up extra locations to change the time and distance traveled
      locations[index] = satellite.getLocation();
    }
    LocationDataPoint firstpoint = locations[0];
    LocationDataPoint lastpoint = locations[locations.length - 1];
    float lattitude1 = firstpoint.getLat();
    float longitude1 = firstpoint.getLng();
    float lattitude2 = lastpoint.getLat();
    float longitude2 = lastpoint.getLng();

    double alpha;
    int expectedDirection = 45;
    float deltaX = longitude1 - longitude2;
    float deltaY = lattitude1 - lattitude2;
    double trackLength = Math.sqrt((deltaY * deltaY) + (deltaX * deltaX));
    alpha = (deltaY / trackLength);
    alpha = Math.asin(alpha);
    double alpha2 = ((-Math.toDegrees(alpha) + 90) + 360) % 360;

    assertEquals(alpha2, TrackDataCalculator.calculateDirection(locations), .01);
  }

  @Test
  @DisplayName("TrackDataCalculator is constructable.")
  public void trackDataCalculatorIsConstructable() {
    new TrackDataCalculator();
  }
  
  private LocationDataPoint generateRandomLocationDataPoint() {
    // Note: this library is not built to handle the roll-overs that LocationDataPoints supports.
    return new LocationDataPoint(
      (float) (Math.random() * 120 - 60),
      (float) (Math.random() * 240 - 120),
      LocalDateTime.of(
        (int) (Math.random() * 50 + 1970),
        (int) (Math.random() * 12 + 1),
        (int) (Math.random() * 28 + 1),
        (int) (Math.random() * 24),
        (int) (Math.random() * 60)
      )
    );
  }

}
