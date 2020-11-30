package edu.oakland.test.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.database.DatabasePersistentStorage;
import edu.oakland.production.database.DatabasePersistentStorageClass;
import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Database PersistentStorage Test")
public class DatabasePersistentStorageTest {


  @Test
  @DisplayName("RFID data in is RFID data out")
  void rfidDataInIsRfidDataOut() {
    //int random = (int) (Math.random() * 60);
    DatabasePersistentStorageClass dpsc = new DatabasePersistentStorageClass();
    assertEquals(0, dpsc.locateRfidData());
  }

  @Test
  @DisplayName("offset matches data point")
  void offsetMatchDataPoint() {
    DatabasePersistentStorageClass dpsc = new DatabasePersistentStorageClass();
    LocationDataPoint ldp = new LocationDataPoint(0, 0, LocalDateTime.of(
        (int) (Math.random() * 50 + 1970),
        (int) (Math.random() * 12 + 1),
        (int) (Math.random() * 28 + 1),
        (int) (Math.random() * 24),
        (int) (Math.random() * 60)
    ));

    dpsc.storeLocationDataPoint(ldp);
    assertEquals(ldp, dpsc.getLocationDataPoint(0));
  }

  @Test
  @DisplayName("Location Data Point In Is Data Point Out")
  void locationDataPointInIsDataPointOut() {
  	
    DatabasePersistentStorageClass dpsc = new DatabasePersistentStorageClass();
    LocationDataPoint ldp = new LocationDataPoint(0, 0, LocalDateTime.of(
        (int) (Math.random() * 50 + 1970),
        (int) (Math.random() * 12 + 1),
        (int) (Math.random() * 28 + 1),
        (int) (Math.random() * 24),
        (int) (Math.random() * 60)
    ));
    int i = 0;
    dpsc.storeLocationDataPoint(ldp);
    assertEquals(ldp, dpsc.getLocationDataPoint(i));
    
  }

  @Test
  @DisplayName("Offset matches track data")
  void offsetMatchTrackData() {
  	DatabasePersistentStorageClass dpsc = new DatabasePersistentStorageClass();

  	float course = generateRandomCourse();
    TrackData trackData = new TrackData(
        generateRandomLocationDataPointsArray(5),
        course,
        generateRandomSpeed()
    );

    dpsc.storeTrackData(trackData);
    assertEquals(trackData, dpsc.getTrackData(0));
    
  }


  @Test
  @DisplayName("Track Data In Is Track Data Out")
  void trackDataInIsTrackDataOut() {

  	DatabasePersistentStorageClass dpsc = new DatabasePersistentStorageClass();

  	float course = generateRandomCourse();
    TrackData trackData = new TrackData(
        generateRandomLocationDataPointsArray(5),
        course,
        generateRandomSpeed()
    );

    dpsc.storeTrackData(trackData);
    assertEquals(trackData, dpsc.getTrackData(0));


  }

  @Test
  @DisplayName("read Mode In Is Mode Out")
  void readModeInIsModeOut() {

    DatabasePersistentStorageClass dpsc = new DatabasePersistentStorageClass();
    dpsc.storeMode("normal");
    assertEquals("normal", dpsc.getMode());
  }

  @Test
  @DisplayName("write Mode In Is Mode Out")
  void writeModeInIsModeOut() {

    DatabasePersistentStorageClass dpsc = new DatabasePersistentStorageClass();
    dpsc.storeMode("normal");
    assertEquals("normal", dpsc.getMode());
  }

  @Test
  @DisplayName("current Satellite matches next satellite")
  void currentSatMatchNextSat() {
    
  }

  @Test
  @DisplayName("cannot store null location data point")
  void cannotStoreNullLocationDataPoint() {
   
    DatabasePersistentStorageClass dpsc = new DatabasePersistentStorageClass();

    assertThrows(IllegalArgumentException.class, () -> {
      dpsc.storeLocationDataPoint(null);
    });

  }

  @Test
  @DisplayName("cannot store null track data")
  void cannotStoreNullTrackData() {

    DatabasePersistentStorageClass dpsc = new DatabasePersistentStorageClass();

    assertThrows(IllegalArgumentException.class, () -> {
      dpsc.storeTrackData(null);
    });
  }

  @Test
  @DisplayName("location data point offset out of bounds returns null")
  void locationDataPointOffsetOutOfBoundsReturnsNull() {
    
    DatabasePersistentStorageClass dpsc = new DatabasePersistentStorageClass();
    LocationDataPoint ldp = new LocationDataPoint(0, 0, LocalDateTime.of(
        (int) (Math.random() * 50 + 1970),
        (int) (Math.random() * 12 + 1),
        (int) (Math.random() * 28 + 1),
        (int) (Math.random() * 24),
        (int) (Math.random() * 60)
    ));
    dpsc.storeLocationDataPoint(ldp);
    assertEquals(null, dpsc.getLocationDataPoint(99999));
  }

  @Test
  @DisplayName("track data offset out of bounds returns null")
  void trackDataOffsetOutOfBoundsIsReturnsNull() {
    
  	DatabasePersistentStorageClass dpsc = new DatabasePersistentStorageClass();

    float course = generateRandomCourse();
    TrackData trackData = new TrackData(
        generateRandomLocationDataPointsArray(5),
        course,
        generateRandomSpeed()
    );

    dpsc.storeTrackData(trackData);
    assertEquals(null, dpsc.getTrackData(99999));

  }

  @Test
  @DisplayName("nonexistent satellite name returns empty next")
  void nonexistentSatelliteNameReturnsEmptyNext() {
    
  }

  @Test
  @DisplayName("last satellite name in list returns empty next")
  void lastSatelliteNameInListReturnsEmptyNext() {
    
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



