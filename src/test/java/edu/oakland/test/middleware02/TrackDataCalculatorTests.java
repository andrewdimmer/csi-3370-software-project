package edu.oakland.test.middleware02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.Satellite;
import java.time.LocalDateTime;
import java.time.*;


@DisplayName("TrackDataCalculator Unit Tests")
public class TrackDataCalculatorTests {

  @Test
  @DisplayName("Calculate Speed")
  void calculateSpeedTest(){
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
    LocationDataPoint lastpoint = points2[points2.length-1];
    float lattitude1 = firstpoint.getLat();
    float longitude1 = firstpoint.getLng();
    float lattitude2 = lastpoint.getLat();
    float longitude2 = lastpoint.getLng();

    LocalDateTime time1 = firstpoint.getTime();
    LocalDateTime time2 = lastpoint.getTime();
    Duration duration = Duration.between(time2 , time1);
    System.out.println(duration.getSeconds());
    System.out.println(lattitude1);
    System.out.println(lattitude2);
    System.out.println(longitude1);
    System.out.println(longitude2);


    float deltaY = longitude2 - longitude1;
    float deltaX = lattitude2 - lattitude1;
    double trackLength = Math.sqrt((deltaY*deltaY) + (deltaX * deltaX));    
      
      int time = 12; //Minutes

      
      float trackData2Lon;
      float trackData2Lat;
      
      //double trackLength;
      //int deltaX = 2;
      //int deltaY = 2;
      double speed;
      double expectedSpeed = 14.14;
      trackLength = Math.sqrt((deltaX*deltaX) + (deltaY*deltaY));

      speed = (trackLength / 4) * 20;
      //System.out.println(speed);
      //System.out.println(trackLength);
    
      //assertEquals(expectedSpeed, speed, 0.01);
    }
    //Delta x == Lat2 - Lat1
    //Delta y == Lon2 - Lon1
  @Test
  @DisplayName("Calculate Direction")
    void calculateDirectionTest(){
        LocationDataPoint[] points = generateRandomLocationDataPointsArray(5);
    TrackData trackData = new TrackData(
        points,
        generateRandomCourse(),
        generateRandomSpeed()
    );
    LocationDataPoint[] points2 = trackData.getLocationDataPoints();
    LocationDataPoint firstpoint = points2[0];
    LocationDataPoint lastpoint = points2[points2.length-1];
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
        double trackLength = Math.sqrt((deltaY*deltaY) + (deltaX * deltaX));
        alpha = (deltaY/trackLength);
        alpha = (Math.asin(alpha));
        double alpha2 = Math.toDegrees(alpha);
        //alpha2 = Math.floor(alpha2);

        //System.out.println(alpha);
        //System.out.println(alpha2);
        System.out.println(alpha2);
        //System.out.println(trackLength);
        //assertEquals(expectedDirection, alpha2);
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
    /*Satellite.satelliteInit(
        (float) (Math.random() * 20),
        (float) (Math.random() * 20),
        generateRandomLocationDataPoint()
    );*/
    LocationDataPoint[] locations = new LocationDataPoint[length];
    //Satellite satellite = new Satellite();
    for (int index = 0; index < locations.length; index++) {
      locations[index] = generateRandomLocationDataPoint();
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