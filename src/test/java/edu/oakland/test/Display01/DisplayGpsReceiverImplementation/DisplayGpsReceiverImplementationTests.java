package edu.oakland.test.Display01.DisplayGpsReceiverImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Random;
import java.lang.NullPointerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.display01.DisplayGpsReceiverImplementation;

@DisplayName ("Display GPS Receiver Implementation")
public class DisplayGpsReceiverImplementationTests {
    @Test
    @DisplayName ("Measure GPS Signal Strength")
    public void measureGpsSignalStrength(Satellite satelliteSignal){
        Satellite signal = satelliteSignal;
        int i = signal.getStrength();
        if (i > 4){
            DisplayGpsManagerImplementation manager = new DisplayGpsManagerImplementation(Satellite signal);
        }
        else if(i <= 4){
            displayGpsReceiverIsNotNull();
        }
        else{
            break;
        }
    }
    @Test
    @DisplayName ("Display GPS Manager Is Not Null")
    public void displayGpsReceiverIsNotNull(){

    }
}