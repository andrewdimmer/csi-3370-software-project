package edu.oakland.test.display01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.display01.SatelliteSignalCheckRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.IllegalArgumentException;

@DisplayName("Sattelite Signal Check Request Tests")
public class SatelliteSignalCheckRequestTests {

  @Test
  @DisplayName("SatelliteName In Is the same SatelliteName Out")
  void satelliteNameInIsSatelliteNameOut() {
    String satelliteName = "testing";
    String checkType = "ok";
    SatelliteSignalCheckRequest ss = new SatelliteSignalCheckRequest(satelliteName, checkType);
    assertEquals(satelliteName, ss.getSatelliteName());
  }

  @Test
  @DisplayName("CheckTypeIn In Is the same CheckType Out")
  void checkTypeInIsCheckTypeOut() {
    String satelliteName = "ouch";
    String checkType = "cool";
    SatelliteSignalCheckRequest ss = new SatelliteSignalCheckRequest(satelliteName, checkType);
    assertEquals(checkType, ss.getCheckType());
  }

  @Test
  @DisplayName("Empty Name Is Not Allowed")
  void emptyNamesNotAllowed() {
    assertThrows(IllegalArgumentException.class, () -> {
    new SatelliteSignalCheckRequest("", "ok");
    });
  }

  @Test
  @DisplayName("Empty Type Is Not Allowed")
  void emptyTypesNotAllowed() {
    assertThrows(IllegalArgumentException.class, () -> {
    new SatelliteSignalCheckRequest("wow", "");
    });
  }

  @Test
  @DisplayName("Verifies that name cannot be set to null")
  void nullNamesNotAllowed() {
    assertThrows(IllegalArgumentException.class, () -> {
      new SatelliteSignalCheckRequest(null, "wow");
    });
  }

  @Test
  @DisplayName("Verifies that type cannot be set to null")
  void nullTypesNotAllowed() {
    assertThrows(IllegalArgumentException.class, () -> {
      new SatelliteSignalCheckRequest("wow", null);
    });
  }
}