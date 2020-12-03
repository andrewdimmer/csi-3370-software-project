package edu.oakland.helper.middleware02;

import edu.oakland.helper.admin.LocationDataPoint;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * This class contains helper methods to determine the speed and direction of a set of points.
 */
public class TrackDataCalculator {

  /**
   * This is a method that calculates a speed from a LocationDataPoint array.
   *
   * @param locationDataPoints An array of LocationDataPoints to calculate the speed of.
   * @return The speed in knots the set of points is moving at.
   */
  public static float calculateSpeed(LocationDataPoint[] locationDataPoints) {
    LocationDataPoint point1 = locationDataPoints[0];
    LocationDataPoint point2 = locationDataPoints[locationDataPoints.length - 1];
    float lattitude1 = point1.getLat();
    float longitude1 = point1.getLng();
    float lattitude2 = point2.getLat();
    float longitude2 = point2.getLng();

    LocalDateTime time1 = point1.getTime();
    LocalDateTime time2 = point2.getTime();
    Duration duration = Duration.between(time2, time1);
    double newDuration = duration.getSeconds() / 3600.0;

    float deltaY = longitude1 - longitude2;
    float deltaX = lattitude1 - lattitude2;
    double trackLength = Math.sqrt((deltaY * deltaY) + (deltaX * deltaX));
    float speed = (float) (trackLength / newDuration);

    return speed;
  }

  /**
   * This is a method that calculates a course direction from a LocationDataPoint array.
   *
   * @param locationDataPoints An array of LocationDataPoints to calculate the direction of.
   * @return The direction in degrees the set of points is trending in.
   */
  public static float calculateDirection(LocationDataPoint[] locationDataPoints) {
    LocationDataPoint point1 = locationDataPoints[0];
    LocationDataPoint point2 = locationDataPoints[locationDataPoints.length - 1];
    float lattitude1 = point1.getLat();
    float longitude1 = point1.getLng();
    float lattitude2 = point2.getLat();
    float longitude2 = point2.getLng();

    double alpha;
    float deltaY = longitude1 - longitude2;
    float deltaX = lattitude1 - lattitude2;
    double trackLength = Math.sqrt((deltaY * deltaY) + (deltaX * deltaX));
    alpha = (deltaY / trackLength);
    alpha = (Math.asin(alpha));
    double alpha2 = (Math.toDegrees(alpha) + 360) % 360;
    return (float) alpha2;
  }

}