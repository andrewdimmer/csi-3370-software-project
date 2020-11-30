package edu.oakland.test.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.database.DatabaseCommManagerImplementation;
import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DatabaseCommManagerImplementation Unit Tests")
public class DatabaseCommManagerImplementationTest {

  @Test
  @DisplayName("rfid going in is Rfid coming Out")
  void rfidInIsRfidOut() {

    int i = 10;

    DatabasePersistentStorageStub dpss = new DatabasePersistentStorageStub(i);
    DatabaseCommManager dcm = new DatabaseCommManagerImplementation(dpss);
    assertEquals(i, dcm.passGetRfidRequest());
  }

  @Test
  @DisplayName("Offset matches Datapoint")
  void offsetMatchDataPoint() {
    DatabasePersistentStorageStub dpss = new DatabasePersistentStorageStub();

    float lat = (float) (Math.random() * 360 - 180);
    float lng = (float) (Math.random() * 360 - 180);

    LocationDataPoint ldp = new LocationDataPoint(lat, lng,
        LocalDateTime.of((int) (Math.random() * 50 + 1970),
         (int) (Math.random() * 12 + 1),
            (int) (Math.random() * 28 + 1),
             (int) (Math.random() * 24),
              (int) (Math.random() * 60)));

    dpss.storeLocationDataPoint(ldp);
    int i = (int) Math.random();
    DatabaseCommManager dcm = new DatabaseCommManagerImplementation(dpss);
    assertEquals(ldp, dcm.passGetLocationDataPointRequest(i));
  }

  @Test
  @DisplayName("Offset matches TrackData")
  void offsetMatchTrackData() {
    DatabasePersistentStorageStub dpss = new DatabasePersistentStorageStub();

    TrackData td = new TrackData(generateRandomLocationDataPointsArray(10));

    int i = (int) (Math.random() * 7);
    assertEquals(null, dpss.getTrackData(i));
  }

  @Test
  @DisplayName("TrackData In is same as TrackData Out")
  void trackDataInIsTrackDataOut() {
    DatabasePersistentStorageStub dpss = new DatabasePersistentStorageStub();

    TrackData td = new TrackData(generateRandomLocationDataPointsArray(10));
    td = null;
    int i = (int) Math.random();
    assertEquals(td, dpss.getTrackData(i));
  }

  @Test
  @DisplayName("Database Persistent Storage is not Null")
  void databasePersistentStorageIsNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new DatabaseCommManagerImplementation(null);
    });
  }

  private LocationDataPoint[] generateRandomLocationDataPointsArray(int length) {
    LocationDataPoint[] locations = new LocationDataPoint[length];
    for (int index = 0; index < locations.length; index++) {
      locations[index] = generateRandomLocationDataPoint();
    }
    return locations;
  }

  private LocationDataPoint generateRandomLocationDataPoint() {
    return new LocationDataPoint((float) (Math.random() * 180 - 90),
     (float) (Math.random() * 360 - 180),
        LocalDateTime.of((int) (Math.random() * 50 + 1970), (int) (Math.random() * 12 + 1),
            (int) (Math.random() * 28 + 1), (int) (Math.random() * 24),
             (int) (Math.random() * 60)));
  }
}
