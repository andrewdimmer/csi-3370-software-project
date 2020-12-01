package edu.oakland.test.display02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.helper.display02.TrackDataPlotter;
import edu.oakland.test.admin.TrackDataTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.IllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;


@DisplayName("Track Data Plotter Unit Tests")
public class TrackDataPlotterTests {

	@Test
	@DisplayName("Plot is Displayed")
	void plotIsDisplayed() {
		TrackDataPlotter plotter = new TrackDataPlotter(generateValidTrackData());
		plotter.displayChart();
		assertNotNull(plotter.chart);
	}

	@Test
	@DisplayName("Null TrackData is not permitted")
	void nullTrackDataNotAllowed() {
		Trackdata data = null;
		TrackDataPlotter plotter = new TrackDataPlotter(data);
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> plotter.displayChart());
		assertEquals("Track data is null", exception.getMessage());
	}

	@Test
	@DisplayName("Invalid TrackData is not permitted")
	void invalidTrackDataNotAllowed() {
		TrackDataPlotter plotter = new TrackDataPlotter(generateInvalidTrackData());
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> plotter.displayChart());
		assertEquals("Not enough points to create a valid TrackData object", exception.getMessage());
	}

	private TrackData generateValidTrackData(){
		TrackData validData = new TrackData(
				generateRandomLocationDataPointsArray(5),
				generateRandomCourse(),
				generateRandomSpeed());
		return validData;
	}

	private TrackData generateInvalidTrackData(){
		TrackData invalidData = new TrackData(
				generateRandomLocationDataPointsArray(2),
				generateRandomCourse(),
				generateRandomSpeed());
		return invalidData;
	}

	/**
	 * Methods borrowed from our lovely admin
	 */
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
