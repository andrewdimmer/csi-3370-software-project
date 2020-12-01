<<<<<<< Updated upstream
package edu.oakland.test.display01;

import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.production.display01.DisplayGpsReceiverImplementation;
=======
  
package edu.oakland.test.display01;

import edu.oakland.helper.admin.Satellite;
import edu.oakland.helper.display01.SatelliteSignalCheckRequest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.oakland.production.display01.DisplayGpsReceiver;
import edu.oakland.production.display01.DisplayGpsReceiverImplementation;
import edu.oakland.test.display01.DisplayGpsManagerStub;

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
}
=======
  @Test
  @DisplayName ("Gps Signal Strength Signal Is Not Null")
  public void measureGpsSignalStrengthSatelliteSignalIsNotNull(){
    assertThrows(IllegalArgumentException.class, () -> {
      new DisplayGpsReceiverImplementation(null);
    });
  }
  @Test
  @DisplayName ("Satellite Signal Is Not Null")
  public void measureSignalSatelliteSignalIsNotNull(){
    assertThrows(IllegalArgumentException.class, () -> {
      new DisplayGpsReceiverImplementation(null);
  });

  @Test
  @DisplayName ("Gps Signal Strength In Is Signal Strength Out ")
  public void measureGpsSignalStrengthSatelliteInIsSignalOut(Satellite satelliteSignal) {

  
    DisplayGpsManagerStub stub = new DisplayGpsManagerStub();
    stub.receiveGpsSignalStrength(satelliteSignal);
    DisplayGpsReceiver gpsReceiver = new DisplayGpsReceiverImplementation(stub);
    SatelliteSignalCheckRequest ssrc = new SatelliteSignalCheckRequest("oreo", "Type-2");
    assertEquals(ssrc.getSatelliteName(), DisplayGpsReceiver.gpsReceiver(stub).getSatelliteName());
  }

  public void measureSignalSignalInIsSignalOut() {
    
  }
}
>>>>>>> Stashed changes
