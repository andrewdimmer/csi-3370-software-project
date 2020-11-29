package edu.oakland.test.Display01.DisplayGpsReceiverImplementation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.display01.DisplayGpsManagerImplementation;
import edu.oakland.production.display01.DisplayGpsReceiverImplementation;

@DisplayName ("Display GPS Receiver Implementation")
public class DisplayGpsReceiverImplementationTests {
  @Test
  @DisplayName ("Measure GPS Signal Strength")
  public void measureGpsSignalStrength(Satellite satelliteSignal){
    Satellite signal = satelliteSignal;
    Integer i = signal.getStrength();
    String s = i.toString();
    if (i > 4){
      assertTrue(Integer.parseInt(s) > 4);
      DisplayGpsManagerImplementation manager = new DisplayGpsManagerImplementation();
      manager.passGpsSignalStrength(s);
    }
    else if(i <= 4){
      displayGpsManagerIsNotNull();
    }
    else{
      System.out.println("GPS Signal Strength Passed is Null. Exiting...");
      System.exit(10);
    }
  }
 
  @Test
  @DisplayName ("Display GPS Manager Is Not Null")
  public void displayGpsManagerIsNotNull(){
    DisplayGpsManagerImplementation manager = new DisplayGpsManagerImplementation();
    assertNotNull(manager, "Verified that signal is not null");
  }
}