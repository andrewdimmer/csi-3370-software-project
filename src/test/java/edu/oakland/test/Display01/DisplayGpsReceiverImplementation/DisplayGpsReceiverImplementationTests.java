package edu.oakland.test.Display01.DisplayGpsReceiverImplementation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.production.display01.DisplayGpsReceiverImplementation;
import java.lang.IllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



@DisplayName ("DisplayGpsReceiverImplementation Unit Tests")
public class DisplayGpsReceiverImplementationTests {
  @Test
  @DisplayName ("Display GPS Manager Is Not Null")
  public void displayGpsManagerIsNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new DisplayGpsReceiverImplementation(null);
    });
  }
}
