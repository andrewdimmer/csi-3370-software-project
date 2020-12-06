package edu.oakland.test.middleware02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.middleware02.MiddlewareCommInterface;
import edu.oakland.production.middleware02.MiddlewareCommInterfaceImplementation;
import edu.oakland.production.middleware02.MiddlewareCommLinkManager;
import edu.oakland.test.middleware02.MiddlewareCommLinkManagerStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("MiddlewareCommInterfaceImplementation Unit Tests")
@Tag("UnitTests")
public class MiddlewareCommInterfaceImplementationTests {

  @Test
  @DisplayName("Rfid In Is the same Rfid Out")
    void rfidInIsRfIdOut() {
    int ranRfid = (int) (Math.floor(100000 + Math.random() * 900000));
    MiddlewareCommInterface mid02Interface = new MiddlewareCommInterfaceImplementation(
        new MiddlewareCommLinkManagerStub());
    assertEquals(ranRfid, Integer.parseInt(
        mid02Interface.requestRfid(ranRfid).getStatusMessage())); 

  }

  @Test 
  @DisplayName("Verifies if middlewareManager is set to Null")
  void nullCheck() {
    assertThrows(IllegalArgumentException.class, () -> {
      new MiddlewareCommInterfaceImplementation(null);
    });
  }
}
