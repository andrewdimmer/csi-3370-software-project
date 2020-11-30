package edu.oakland.test.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.production.database.DatabaseGisManagerImplementation;
import edu.oakland.test.database.DatabasePersistentStorageStub;
import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Database GisInterface Test")
public class DatabaseGisManagerTest {

  @Test
  @DisplayName("LDP going in the same LDP coming out")
  void dataPointInIsDataPointOut() {
    DatabasePersistentStorageStub dpss = new DatabasePersistentStorageStub();
    DatabaseGisManagerImplementation dgm = new DatabaseGisManagerImplementation(dpss);
    LocationDataPoint ldp = new LocationDataPoint(0, 0, LocalDateTime.of(
        (int) (Math.random() * 50 + 1970),
        (int) (Math.random() * 12 + 1),
        (int) (Math.random() * 28 + 1),
        (int) (Math.random() * 24),
        (int) (Math.random() * 60)
    ));
    dgm.passStoreRequest(ldp);
    assertEquals(ldp, dpss.getLocationDataPoint());
  }

  @Test
  @DisplayName("Putting in the current satellite returns the new satellite")
  void currentSatGetsNextSat() {
    DatabasePersistentStorageStub dpss = new DatabasePersistentStorageStub();
    DatabaseGisManagerImplementation dgm = new DatabaseGisManagerImplementation(dpss);
    String currentSat = "";
    assertEquals(currentSat, dgm.passNextSatRequest(currentSat));
  }

  @Test
  @DisplayName("The Mode Requested is the Actual Mode")
  void modeInIsModeOut() {
    DatabasePersistentStorageStub dpss = new DatabasePersistentStorageStub();
    DatabaseGisManagerImplementation dgm = new DatabaseGisManagerImplementation(dpss);
    String n = "normal";
    dgm.passModeRequest(n);
    assertEquals(n, dpss.getMode()); //supposed to return a String with the mode
  }
   
  @Test
  @DisplayName("Checks that storage isn't null")
  void persistentStorageIsNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new DatabaseGisManagerImplementation(null);
    });
  }

}