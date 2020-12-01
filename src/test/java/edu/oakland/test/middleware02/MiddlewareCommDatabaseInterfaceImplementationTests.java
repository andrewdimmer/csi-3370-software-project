package edu.oakland.test.middleware02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.production.database.DatabaseCommInterface;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterface;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterfaceImplementation;
import edu.oakland.test.middleware02.DatabaseCommInterfaceStub;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("MiddlewareCommDatabaseInterfaceImplementationTests Unit Tests")
public class MiddlewareCommDatabaseInterfaceImplementationTests {
  int rfid;
  @Test
  @DisplayName("Rfid In Is the same Rfid Out")
    void rfidInIsRfIdOut() {
    int ranRfid = (int)(Math.floor(100000 + Math.random() * 900000));
    MiddlewareCommDatabaseInterface mid02DatabaseInterface = new MiddlewareCommDatabaseInterfaceImplementation(new DatabaseCommInterfaceStub(ranRfid));
    assertEquals(ranRfid, mid02DatabaseInterface.checkCurrentRfid());
  }

  @Test 
  @DisplayName("Verifies if middlewareManager is set to Null")
  void nullCheck() {
    assertThrows(IllegalArgumentException.class, () -> {
      new MiddlewareCommDatabaseInterfaceImplementation(null);
    });
}
}
