package edu.oakland.test.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TrackData Unit Tests")
public class TrackDataTests {

  @Test
  @DisplayName("Points-Only Constructor Course Direction Is 0")
  void pointsOnlyConstructorCourseIs0() {
    int length = generateRandomTooSmallArrayLength();
    TrackData trackData = new TrackData(generateRandomLocationDataPointsArray(length));
    assertEquals(0, trackData.getCourseDirection(), .001);
  }

  @Test
  @DisplayName("Full-Data Constructor Course Direction In Is Course Direction Out")
  void fullDataConstructorCourseInIsCourseOut() {
    float course = generateRandomCourse();
    TrackData trackData = new TrackData(
        generateRandomLocationDataPointsArray(5),
        course,
        generateRandomSpeed()
    );
    assertEquals(course, trackData.getCourseDirection(), .001);
  }

  @Test
  @DisplayName("Points-Only Constructor Speed Is 0")
  void pointsOnlyConstructorSpeedIs0() {
    int length = generateRandomTooSmallArrayLength();
    TrackData trackData = new TrackData(generateRandomLocationDataPointsArray(length));
    assertEquals(0, trackData.getSpeed(), .001);
  }

  @Test
  @DisplayName("Full-Data Constructor Speed In Is Speed Out")
  void fullDataConstructorSpeedInIsSpeedOut() {
    float speed = generateRandomSpeed();
    TrackData trackData = new TrackData(
        generateRandomLocationDataPointsArray(5),
        generateRandomCourse(),
        speed
    );
    assertEquals(speed, trackData.getSpeed(), .001);
  }

  @Test
  @DisplayName("Points-Only Constructor Valid is False")
  void pointsOnlyConstructorValidIsFalse() {
    int length = generateRandomTooSmallArrayLength();
    TrackData trackData = new TrackData(generateRandomLocationDataPointsArray(length));
    assertFalse(trackData.isValid());
  }

  @Test
  @DisplayName("Full-Data Constructor Valid is True")
  void fullDataConstructorValidIsTrue() {
    TrackData trackData = new TrackData(
        generateRandomLocationDataPointsArray(5),
        generateRandomCourse(),
        generateRandomSpeed()
    );
    assertTrue(trackData.isValid());
  }

  @Test
  @DisplayName("Points-Only Constructor Points In are Points Out")
  void pointsOnlyConstructorPointsInArePointsOut() {
    int length = generateRandomTooSmallArrayLength();
    LocationDataPoint[] points = generateRandomLocationDataPointsArray(length);
    TrackData trackData = new TrackData(points);
    assertEquals(points, trackData.getLocationDataPoints());
  }

  @Test
  @DisplayName("Full-Data Constructor Points In are Points Out")
  void fullDataConstructorPointsInArePointsOut() {
    LocationDataPoint[] points = generateRandomLocationDataPointsArray(5);
    TrackData trackData = new TrackData(
        points,
        generateRandomCourse(),
        generateRandomSpeed()
    );
    assertEquals(points, trackData.getLocationDataPoints());
  }

  @Test
  @DisplayName("TrackData Status Message In Is the Same Status Message Out")
  void statusMessageInIsStatusMessageOut() {
    TrackData trackData = new TrackData(
        generateRandomLocationDataPointsArray(5),
        generateRandomCourse(),
        generateRandomSpeed()
    );
    String message = generateRandomString();
    trackData.setStatusMessage(message);
    assertEquals(message, trackData.getStatusMessage());
  }

  @Test
  @DisplayName("No LocationDataPoints Arrays with Exactly 5 Points Via Points-Only Constructor")
  void noValidDataViaPointsOnlyConstructor() {
    assertThrows(IllegalArgumentException.class, () -> {
      new TrackData(generateRandomLocationDataPointsArray(5));
    });
  }

  @Test
  @DisplayName("No Null LocationDataPoints Array Via Points-Only Constructor")
  void noNullDataViaPointsOnlyConstructor() {
    assertThrows(IllegalArgumentException.class, () -> {
      new TrackData(null);
    });
  }

  @Test
  @DisplayName("No Null LocationDataPoints Array Via Full-Data Constructor")
  void noNullDataViaFullDataConstructor() {
    assertThrows(IllegalArgumentException.class, () -> {
      new TrackData(
          null,
          generateRandomCourse(),
          generateRandomSpeed()
      );
    });
  }

  @Test
  @DisplayName("No LocationDataPoints Arrays with Less than 5 Points Via Full-Data Constructor")
  void noTooLittleDataViaFullDataConstructor() {
    assertThrows(IllegalArgumentException.class, () -> {
      new TrackData(
          generateRandomLocationDataPointsArray(generateRandomTooSmallArrayLength()),
          generateRandomCourse(),
          generateRandomSpeed()
      );
    });
  }

  @Test
  @DisplayName("No LocationDataPoints Arrays with More than 5 Points Via Full-Data Constructor")
  void noTooMuchDataViaFullDataConstructor() {
    assertThrows(IllegalArgumentException.class, () -> {
      new TrackData(
          generateRandomLocationDataPointsArray(generateRandomTooSmallArrayLength() + 6),
          generateRandomCourse(),
          generateRandomSpeed()
      );
    });
  }

  @Test
  @DisplayName("No Negative Speed Via Full-Data Constructor")
  void noNegativeSpeedViaFullDataConstructor() {
    assertThrows(IllegalArgumentException.class, () -> {
      new TrackData(
          generateRandomLocationDataPointsArray(5),
          generateRandomCourse(),
          -generateRandomSpeed()
      );
    });
  }

  @Test
  @DisplayName("No Negative Course Direction Via Full-Data Constructor")
  void noNegativeCourseViaFullDataConstructor() {
    assertThrows(IllegalArgumentException.class, () -> {
      new TrackData(
          generateRandomLocationDataPointsArray(5),
          -generateRandomCourse(),
          generateRandomSpeed()
      );
    });
  }

  @Test
  @DisplayName("No Course Direction Greater than 360 Degrees Via Full-Data Constructor")
  void noTooLargeCourseViaFullDataConstructor() {
    assertThrows(IllegalArgumentException.class, () -> {
      new TrackData(
          generateRandomLocationDataPointsArray(5),
          generateRandomCourse() + 360,
          generateRandomSpeed()
      );
    });
  }

  private float generateRandomCourse() {
    return (float) (Math.random() * 360);
  }

  private float generateRandomSpeed() {
    return (float) (Math.random() * 30);
  }

  private int generateRandomTooSmallArrayLength() {
    return (int) (Math.random() * 5);
  }

  private LocationDataPoint[] generateRandomLocationDataPointsArray(int length) {
    LocationDataPoint[] locations = new LocationDataPoint[length];
    for (int index = 0; index < locations.length; index++) {
      locations[index] = generateRandomLocationDataPoint();
    }
    return locations;
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

  private String generateRandomString() {
    char[] randomString = new char[(int) (Math.random() * 256)];
    for (int index = 0; index < randomString.length; index++) {
      randomString[index] = (char) (Math.random() * (127 - 32) + 32);
    }
    return new String(randomString);
  }
}
