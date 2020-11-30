package edu.oakland.test.Display01.DisplayGpsReceiverImplementation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.IllegalArgumentException;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.display01.DisplayGpsManagerImplementation;
import edu.oakland.production.display01.DisplayGpsReceiverImplementation;

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
    }
    else {
      throw new IllegalArgumentException("Signal strength cannot be null");
    }
  }
}