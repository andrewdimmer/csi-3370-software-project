package edu.oakland.test.display01.DisplayGpsReceiverImplementation;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.display01.DisplayGpsManagerImplementation;
import edu.oakland.production.display01.DisplayGpsReceiverImplementation;
import java.lang.IllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



@DisplayName ("Display GPS Receiver Implementation")
public class DisplayGpsReceiverImplementationTests {
  @Test
  @DisplayName ("Display GPS Manager Is Not Null")
  public void displayGpsManagerIsNotNull(Satellite satelliteSignal) {
    Satellite signal = satelliteSignal;
    Integer i = signal.getStrength();
    String s = i.toString();
    if (s != null) {
      DisplayGpsManagerImplementation manager = new DisplayGpsManagerImplementation();
      assertNotNull(manager, "Verified that signal is not null");
    } else {
      throw new IllegalArgumentException("Signal strength cannot be null");
    }
  }
}