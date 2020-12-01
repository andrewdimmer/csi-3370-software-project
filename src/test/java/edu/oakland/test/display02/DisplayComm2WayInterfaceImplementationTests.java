import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.display02.DisplayCommManager;
import edu.oakland.production.display02.DisplayCommManagerImplementation;
import edu.oakland.production.display02.DisplayComm2WayInterface;
import edu.oakland.production.display02.DisplayComm2WayInterfaceImplementation;
import java.lang.IllegalArgumentException;
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
