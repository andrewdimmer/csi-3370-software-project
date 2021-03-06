package edu.oakland.test.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.database.DatabasePersistentStorage;
import edu.oakland.production.database.DatabasePersistentStorageImplementation;
import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DatabasePersistentStorage Unit Tests")
public class DatabasePersistentStorageTest {

  String[] randomArray = {"A", "B"};

  LocationDataPoint ldp = new LocationDataPoint(0, 0, LocalDateTime.of(
        (int) (Math.random() * 50 + 1970),
        (int) (Math.random() * 12 + 1),
        (int) (Math.random() * 28 + 1),
        (int) (Math.random() * 24),
        (int) (Math.random() * 60)
    ));


  float course = generateRandomCourse();
  TrackData trackDataPoint = new TrackData(
        generateRandomLocationDataPointsArray(5),
        course,
        generateRandomSpeed()
    );


  ArrayList<LocationDataPoint> locDataPoint = new ArrayList<LocationDataPoint>();
  ArrayList<TrackData> trackData = new ArrayList<TrackData>();

  

  @Test
  @DisplayName("RFID data in is RFID data out")
  void rfidDataInIsRfidDataOut() {
    int random = (int) (Math.random() * 60);
    locDataPoint.add(ldp);
    trackData.add(trackDataPoint);
    DatabasePersistentStorageImplementation dpsc = new DatabasePersistentStorageImplementation(
        random, 
        locDataPoint, 
        trackData, 
        randomArray
    );
    assertEquals(random, dpsc.locateRfidData());
  }

  @Test
  @DisplayName("offset matches data point")
  void offsetMatchDataPoint() {
    // Setup
    locDataPoint.add(ldp);
    trackData.add(trackDataPoint);
    DatabasePersistentStorageImplementation dpsc = new DatabasePersistentStorageImplementation(0, 
        locDataPoint, 
        trackData, 
        randomArray
    );

    // rand from 1 to 5.
    int randomInt = (int) (Math.random() * (5 - 1 + 1) + 1); 
    ArrayList<LocationDataPoint> locDataPointList = new ArrayList<LocationDataPoint>();
    
    for (int i = 0; i <= randomInt; i++) {

      LocationDataPoint ldpData = new LocationDataPoint(0, 0, LocalDateTime.of(
            (int) (Math.random() * 50 + 1970),
            (int) (Math.random() * 12 + 1),
            (int) (Math.random() * 28 + 1),
            (int) (Math.random() * 24),
            (int) (Math.random() * 60)
        ));

      locDataPointList.add(0, ldpData);
      dpsc.storeLocationDataPoint(ldpData);

    }


    assertEquals(locDataPointList.get(randomInt), dpsc.getLocationDataPoint(randomInt));
  }

  @Test
  @DisplayName("Location Data Point In Is Data Point Out")
  void locationDataPointInIsDataPointOut() {

    locDataPoint.add(ldp);
    trackData.add(trackDataPoint);
    DatabasePersistentStorageImplementation dpsc = new DatabasePersistentStorageImplementation(0, 
        locDataPoint, 
        trackData, 
        randomArray
    );
    int i = 0;
    dpsc.storeLocationDataPoint(ldp);
    assertEquals(ldp, dpsc.getLocationDataPoint(i));
    
  }

  @Test
  @DisplayName("Offset matches track data")
  void offsetMatchTrackData() {
    // Setup
    locDataPoint.add(ldp);
    trackData.add(trackDataPoint);
    DatabasePersistentStorageImplementation dpsc = new DatabasePersistentStorageImplementation(0, 
        locDataPoint, 
        trackData, 
        randomArray
    );

    // rand from 1 to 5.
    int randomInt = (int) (Math.random() * (5 - 1 + 1) + 1); 
    ArrayList<TrackData> trackDataList = new ArrayList<TrackData>();

    for (int i = 0; i <= randomInt; i++) {

      float course = generateRandomCourse();
      TrackData trackDataPointSample = new TrackData(
            generateRandomLocationDataPointsArray(5),
            course,
            generateRandomSpeed()
        );

      trackDataList.add(0, trackDataPointSample); // Add to local
      dpsc.storeTrackData(trackDataPointSample); //Add to implementation

    }

    assertEquals(trackDataList.get(randomInt), dpsc.getTrackData(randomInt));
    
  }


  @Test
  @DisplayName("Track Data In Is Track Data Out")
  void trackDataInIsTrackDataOut() {
    
    locDataPoint.add(ldp);
    trackData.add(trackDataPoint);
    DatabasePersistentStorageImplementation dpsc = new DatabasePersistentStorageImplementation(0, 
        locDataPoint, 
        trackData, 
        randomArray
    );

    dpsc.storeTrackData(trackDataPoint);
    assertEquals(trackDataPoint, dpsc.getTrackData(0));


  }

  @Test
  @DisplayName("read Mode In Is Mode Out")
  void modeInIsModeOut() {
    
    locDataPoint.add(ldp);
    trackData.add(trackDataPoint);
    DatabasePersistentStorageImplementation dpsc = new DatabasePersistentStorageImplementation(0, 
        locDataPoint, 
        trackData, 
        randomArray
    );

    dpsc.storeMode("normal");
    assertEquals("normal", dpsc.getMode());
  }


  @Test
  @DisplayName("current Satellite matches next satellite")
  void currentSatMatchNextSat() {
    locDataPoint.add(ldp);
    trackData.add(trackDataPoint);

    String[] sampleSatArray = {"Sat1", "Sat2", "Sat3", "Sat4"};
    DatabasePersistentStorageImplementation dpsc = new DatabasePersistentStorageImplementation(0, 
        locDataPoint, 
        trackData, 
        sampleSatArray
    );

    assertEquals("Sat3", dpsc.getNextSat("Sat2"));
  }

  @Test
  @DisplayName("cannot store null location data point")
  void cannotStoreNullLocationDataPoint() {
    locDataPoint.add(ldp);
    trackData.add(trackDataPoint);

    DatabasePersistentStorageImplementation dpsc = new DatabasePersistentStorageImplementation(0, 
        locDataPoint, 
        trackData, 
        randomArray
    );

    assertThrows(IllegalArgumentException.class, () -> {
      dpsc.storeLocationDataPoint(null);
    });

  }

  @Test
  @DisplayName("cannot store null track data")
  void cannotStoreNullTrackData() {
    locDataPoint.add(ldp);
    trackData.add(trackDataPoint);

    DatabasePersistentStorageImplementation dpsc = new DatabasePersistentStorageImplementation(0, 
        locDataPoint, 
        trackData, 
        randomArray
    );

    assertThrows(IllegalArgumentException.class, () -> {
      dpsc.storeTrackData(null);
    });
  }

  @Test
  @DisplayName("location data point offset out of bounds returns null")
  void locationDataPointOffsetOutOfBoundsReturnsNull() {
    locDataPoint.add(ldp);
    trackData.add(trackDataPoint);

    DatabasePersistentStorageImplementation dpsc = new DatabasePersistentStorageImplementation(0, 
        locDataPoint, 
        trackData, 
        randomArray
    );
    dpsc.storeLocationDataPoint(ldp);
    assertEquals(null, dpsc.getLocationDataPoint(99999));
  }


  @Test
  @DisplayName("track data offset out of bounds returns empty track data")
  void trackDataOffsetOutOfBoundsReturnsEmptyTrackData() {
    // Setup
    locDataPoint.add(ldp);
    trackData.add(trackDataPoint);
    DatabasePersistentStorageImplementation dpsc = new DatabasePersistentStorageImplementation(0, 
            locDataPoint, 
            trackData, 
            randomArray
        );

    dpsc.storeTrackData(trackDataPoint);
    // test if empty track data compared to empty track data.
    TrackData testTrackData = dpsc.getTrackData(99999);
    assertFalse(testTrackData.isValid());
    assertEquals(0, testTrackData.getLocationDataPoints().length);
  }


  @Test
  @DisplayName("nonexistent satellite name returns empty next")
  void nonexistentSatelliteNameReturnsEmptyNext() {
    locDataPoint.add(ldp);
    trackData.add(trackDataPoint);

    String[] sampleSatArray = {"Sat1", "Sat2", "Sat3", "Sat4"};
    DatabasePersistentStorageImplementation dpsc = new DatabasePersistentStorageImplementation(0, 
        locDataPoint, 
        trackData, 
        sampleSatArray
    );

    assertEquals("", dpsc.getNextSat("Sat5"));
  }

  @Test
  @DisplayName("last satellite name in list returns empty next")
  void lastSatelliteNameInListReturnsEmptyNext() {
    locDataPoint.add(ldp);
    trackData.add(trackDataPoint);

    String[] sampleSatArray = {"Sat1", "Sat2", "Sat3", "Sat4"};
    DatabasePersistentStorageImplementation dpsc = new DatabasePersistentStorageImplementation(0, 
        locDataPoint, 
        trackData, 
        sampleSatArray
    );
    assertEquals("", dpsc.getNextSat("Sat4"));
  }

  @Test
  @DisplayName("cannot pass null location data point in constructor")
  void cannotPassNullLocationDataPointInConstructor() {
    locDataPoint.add(ldp);
    trackData.add(trackDataPoint);

    assertThrows(IllegalArgumentException.class, () -> {
      new DatabasePersistentStorageImplementation(0, 
        null, 
        trackData, 
        randomArray
    );
    });

  }


  @Test
  @DisplayName("cannot pass null track data in constructor")
  void cannotPassNullTrackDataInConstructor() {
    locDataPoint.add(ldp);
    trackData.add(trackDataPoint);

    assertThrows(IllegalArgumentException.class, () -> {
      new DatabasePersistentStorageImplementation(0, 
        locDataPoint, 
        null, 
        randomArray
    );
    });

  }


  @Test
  @DisplayName("cannot pass null next Satellites in constructor")
  void cannotPassNullNextSatellitesInConstructor() {
    locDataPoint.add(ldp);
    trackData.add(trackDataPoint);

    assertThrows(IllegalArgumentException.class, () -> {
      new DatabasePersistentStorageImplementation(0, 
        locDataPoint, 
        trackData, 
        null
    );
    });

  }

  // Functions stolen from admin for TrackData use

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
