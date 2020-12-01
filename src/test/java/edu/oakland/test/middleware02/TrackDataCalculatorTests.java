package edu.oakland.test.middleware02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.admin.TrackData;
import java.time.Duration;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TrackDataCalculator Unit Tests")
public class TrackDataCalculatorTests {

  @Test
  @DisplayName("Calculate Speed")
  void calculateSpeedTest() {
    //Delta x == Lat2 - Lat1
    //Delta y == Lon2 - Lon1
     
    LocationDataPoint[] points = generateRandomLocationDataPointsArray(5);
    TrackData trackData = new TrackData(
        points,
        generateRandomCourse(),
        generateRandomSpeed()
    );
    LocationDataPoint[] points2 = trackData.getLocationDataPoints();
    LocationDataPoint firstpoint = points2[0];
    LocationDataPoint lastpoint = points2[points2.length - 1];
    float lattitude1 = firstpoint.getLat();
    float longitude1 = firstpoint.getLng();
    float lattitude2 = lastpoint.getLat();
    float longitude2 = lastpoint.getLng();

    LocalDateTime time1 = firstpoint.getTime();
    LocalDateTime time2 = lastpoint.getTime();
    Duration duration = Duration.between(time1, time2);
    System.out.println(duration.getSeconds() / 60);
    System.out.println(lattitude1);
    System.out.println(lattitude2);
    System.out.println(longitude1);
    System.out.println(longitude2);
    long newDuration;
    newDuration = duration.getSeconds() / 3600;
    System.out.println(newDuration);

    float deltaY = longitude2 - longitude1;
    float deltaX = lattitude2 - lattitude1;
    double trackLength = Math.sqrt((deltaY * deltaY) + (deltaX * deltaX));    
      
    trackLength = Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));

    double speed = (trackLength / newDuration);
    System.out.println("***Calculated Speed***");
    System.out.println(speed);

  }
  
  //Delta x == Lat2 - Lat1
  //Delta y == Lon2 - Lon1
  
  @Test
  @DisplayName("Calculate Direction")
  void calculateDirectionTest() {
    LocationDataPoint[] points = generateRandomLocationDataPointsArray(5);
    TrackData trackData = new TrackData(
          points,
          generateRandomCourse(),
          generateRandomSpeed()
      );
    LocationDataPoint[] points2 = trackData.getLocationDataPoints();
    LocationDataPoint firstpoint = points2[0];
    LocationDataPoint lastpoint = points2[points2.length - 1];
    float lattitude1 = firstpoint.getLat();
    float longitude1 = firstpoint.getLng();
    float lattitude2 = lastpoint.getLat();
    float longitude2 = lastpoint.getLng();
    System.out.println(lattitude1);
    System.out.println(lattitude2);
    System.out.println(longitude1);
    System.out.println(longitude2);

    double alpha;
    int expectedDirection = 45;
    float deltaY = longitude2 - longitude1;
    float deltaX = lattitude2 - lattitude1;
    double trackLength = Math.sqrt((deltaY * deltaY) + (deltaX * deltaX));
    alpha = (deltaY / trackLength);
    alpha = (Math.asin(alpha));
    double alpha2 = Math.toDegrees(alpha);

    System.out.println("***Calculated Direction***");    
    System.out.println(alpha2);
        
  }
  
  private LocationDataPoint generateRandomLocationDataPoint() {
    return new LocationDataPoint(
      (float) (Math.random() * 180 - 90),
      (float) (Math.random() * 360 - 180),
      LocalDateTime.of(
        (int) (Math.random() * 50 + 1970),
        (int) (Math.random() * 12 + 1),
        (int) (Math.random() * 28 + 1),
        (int) (Math.random() * 24),
        (int) (Math.random() * 60)
      )
    );
  }
  
  private LocationDataPoint[] generateRandomLocationDataPointsArray(int length) {
    Satellite.satelliteInit(
        (float) (Math.random() * 20),
        (float) (Math.random() * 20),
        generateRandomLocationDataPoint()
    );
    LocationDataPoint[] locations = new LocationDataPoint[length];
    
    Satellite satellite = new Satellite("tester", 7);
    for (int index = 0; index < locations.length; index++) {
      locations[index] = satellite.getLocation();
    }
    return locations;
  }
  
  private float generateRandomCourse() {
    return (float) (Math.random() * 360);
  }

  private float generateRandomSpeed() {
    return (float) (Math.random() * 30);
  }
}
