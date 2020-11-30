package edu.oakland.test.display02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.display02.DisplayCommManager;
import edu.oakland.production.display02.DisplayCommManagerImplementation;
import edu.oakland.production.middleware02.MiddlewareCommInterface;
import edu.oakland.test.display02.MiddlewareCommInterfaceStub;
import java.lang.IllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Display Comm Manager Implementation Tests")
public class DisplayCommManagerImplementationTests {

  @Test
  @DisplayName("RFID In Is the same as Rfid Out")
  void rfidInIsRfidOut() {
    int rfid = generateRandomRfid();
    DisplayCommManagerImplementation displayComm = new DisplayCommManagerImplementation();
    displayComm.receiveRfid(rfid);
    assertEquals(rfid, displayComm.rfid);
  }
  
  private int generateRandomRfid() {
    return (int) Math.random();
  }

  @Test 
  @DisplayName("MiddlewareCommInterface is not null")
  void middlewareIsNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new DisplayCommManagerImplementation(null);
    });
  }
}
