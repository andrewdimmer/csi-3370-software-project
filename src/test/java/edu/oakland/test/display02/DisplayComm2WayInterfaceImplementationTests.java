import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.production.display02.DisplayComm2WayInterfaceImplementation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DisplayComm2WayInterfaceImplementation Unit Tests")

public class DisplayComm2WayInterfaceImplementationTests {

  @Test 
  @DisplayName("CommManager is not null")
  void commManagerIsNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new DisplayComm2WayInterfaceImplementation(null);
    });
  }
}
