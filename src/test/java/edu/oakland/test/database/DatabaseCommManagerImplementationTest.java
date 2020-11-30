package edu.oakland.test.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.database.DatabaseCommManager;
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

    int i = (int) (Math.random() * 100);

    DatabasePersistentStorageStub dpss = new DatabasePersistentStorageStub(i);
    DatabaseCommManager dcm = new DatabaseCommManagerImplementation(dpss);
    assertEquals(i, dcm.passGetRfidRequest());
  }

  @Test
  @DisplayName("Offset matches Datapoint")
  void offsetMatchDataPoint() {
    int i = (int) (Math.random() * 100);

    DatabasePersistentStorageStub dpss = new DatabasePersistentStorageStub(i);
    DatabaseCommManager dcm = new DatabaseCommManagerImplementation(dpss);

    float lat = (float) (Math.random() * 360 - 180);
    float lng = (float) (Math.random() * 360 - 180);

    LocationDataPoint ldp = new LocationDataPoint(lat, lng,
        LocalDateTime.of((int) (Math.random() * 50 + 1970),
         (int) (Math.random() * 12 + 1),
            (int) (Math.random() * 28 + 1),
             (int) (Math.random() * 24),
              (int) (Math.random() * 60)));
    dpss.storeLocationDataPoint(ldp);
    assertEquals(ldp, dcm.passGetLocationDataPointRequest(i));
  }

  @Test
  @DisplayName("Offset matches TrackData")
  void offsetMatchTrackData() {
    int i = (int) (Math.random() * 100);

    DatabasePersistentStorageStub dpss = new DatabasePersistentStorageStub(i);
    DatabaseCommManager dcm = new DatabaseCommManagerImplementation(dpss);
    int j = (int) (Math.random() * 100);

    assertEquals(j, dcm.passGetTrackDataRequest(j));
  }

  @Test
  @DisplayName("TrackData In is same as TrackData Out")
  void trackDataInIsTrackDataOut() {
    int i = (int) (Math.random() * 100);
    TrackData td = new TrackData(generateRandomLocationDataPointsArray(10));
    DatabasePersistentStorageStub dpss = new DatabasePersistentStorageStub(i);
    DatabaseCommManager dcm = new DatabaseCommManagerImplementation(dpss);

    int j = (int) (Math.random() * 100);
    dcm.passStoreTrackDataRequest(td);
    assertEquals(td, dpss.getTrackData(j));
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
        LocalDateTime.of((int) (Math.random() * 50 + 1970),
         (int) (Math.random() * 12 + 1),
            (int) (Math.random() * 28 + 1), (int) (Math.random() * 24),
             (int) (Math.random() * 60)));
  }
}
