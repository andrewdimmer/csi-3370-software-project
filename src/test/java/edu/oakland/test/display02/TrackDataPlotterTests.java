package edu.oakland.test.display02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.helper.display02.TrackDataPlotter;
import edu.oakland.test.admin.TrackDataTests;
import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("TrackDataPlotter Unit Tests")
public class TrackDataPlotterTests {
  @Test
  @DisplayName("5 Point Plot is Displayed")
  void plotIsDisplayedWith5DataPoints() {
    TrackDataPlotter plotter = new TrackDataPlotter(generateValidTrackData());
    plotter.displayChart();
    assertTrue(plotter.getDisplayedChart());
  }

  @Test
  @DisplayName("Single-Point Plot is Displayed")
  void plotIsDisplayedWith1DataPoint() {
    TrackDataPlotter plotter = new TrackDataPlotter(generateSinglePointTrackData());
    plotter.displayChart();
    assertTrue(plotter.getDisplayedChart());
  }

  @Test
  @DisplayName("2+ Point Plot is Displayed")
  void plotIsDisplayedWith2PlusDataPoints() {
    TrackDataPlotter plotter = new TrackDataPlotter(generate2To4PointTrackData());
    plotter.displayChart();
    assertTrue(plotter.getDisplayedChart());
  }

  @Test
  @DisplayName("Null TrackData is not permitted")
  void nullTrackDataNotAllowed() {
    assertThrows(IllegalArgumentException.class, () -> {
      new TrackDataPlotter(null);
    });
  }

  @Test
  @DisplayName("Zero Point TrackData is not permitted")
  void zeroPointTrackDataNotAllowed() {
    assertThrows(IllegalArgumentException.class, () -> {
      new TrackDataPlotter(new TrackData(new LocationDataPoint[0]));
    });
  }

  private TrackData generateValidTrackData() {
    return new TrackData(
        generateRandomLocationDataPointsArray(5),
        generateRandomCourse(),
        generateRandomSpeed()
    );
  }

  private TrackData generateSinglePointTrackData() {
    return new TrackData(
        generateRandomLocationDataPointsArray(1)
    );
  }

  private TrackData generate2To4PointTrackData() {
    return new TrackData(
        generateRandomLocationDataPointsArray((int) (Math.random() * 3) + 2)
    );
  }


  //Methods borrowed from our lovely admin
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
}
