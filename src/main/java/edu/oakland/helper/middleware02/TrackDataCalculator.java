package edu.oakland.helper.middleware02;

import edu.oakland.helper.admin.LocationDataPoint;
import java.time.Duration;
import java.time.LocalDateTime;
/**
     * This is a class that calcs speed and direction
     * <p>

     */
public class TrackDataCalculator {

  private LocationDataPoint[] locationDataPoint;

  public float calculateSpeed(LocationDataPoint[] locationDataPoint) {
    this.locationDataPoint = locationDataPoint;
    LocationDataPoint point1 = locationDataPoint[0];
    LocationDataPoint point2 = locationDataPoint[locationDataPoint.length - 1];
    float lattitude1 = point1.getLat();
    float longitude1 = point1.getLng();
    float lattitude2 = point2.getLat();
    float longitude2 = point2.getLng();

    LocalDateTime time1 = point1.getTime();
    LocalDateTime time2 = point2.getTime();
    Duration duration = Duration.between(time1, time2);
    long newDuration = duration.getSeconds() / 3600;

    float deltaY = longitude2 - longitude1;
    float deltaX = lattitude2 - lattitude1;
    double trackLength = Math.sqrt((deltaY * deltaY) + (deltaX * deltaX));
    double speed = (trackLength / newDuration);
    double newSpeed = Math.round(speed * 100.0) / 100.0;
    float newSpeed2 = (float) newSpeed;

    return newSpeed2;  
      
  }
  /**
     * This is a method that calcs direction
     * <p>
     */
     
  public float calculateDirection(LocationDataPoint[] locationDataPoint) {
    this.locationDataPoint = locationDataPoint;
    
    LocationDataPoint point1 = locationDataPoint[0];
    LocationDataPoint point2 = locationDataPoint[locationDataPoint.length - 1];
    float lattitude1 = point1.getLat();
    float longitude1 = point1.getLng();
    float lattitude2 = point2.getLat();
    float longitude2 = point2.getLng();
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
    float alpha3 = (float) alpha2;
    return alpha3;
  }

  private LocationDataPoint[] calculateRootMeanSquared(LocationDataPoint[] locationDataPoint) {
    return locationDataPoint;
  }
}