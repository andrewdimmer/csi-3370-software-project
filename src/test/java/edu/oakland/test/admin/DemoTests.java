package edu.oakland.test.admin;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.production.admin.Demo;
import java.lang.IllegalArgumentException;
import java.util.Random;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Demo Unit Tests")
public class DemoTests { 

  @Test
  @DisplayName("configureRfid Scanner Input is Not Null")
  void configureRfidScannerInputIsUserInput() {
    Demo demo = new Demo();
    assertThrows(IllegalArgumentException.class, () -> {
      demo.configureRfid(null);
    });
  }

  @Test
  @DisplayName("configureRfid Rfid In is Rfid Out")
  void configureRfidRfidInIsRfidOut() {
    Demo demo = new Demo();
    int rfid = generateRandomNumber();
    assertEquals(rfid, demo.configureRfid(new Scanner(String.valueOf(rfid))));
  }

  @Test
  @DisplayName("configureSatelliteNames Scanner Input is Not Null")
  void configureSatelliteNamesScannerInputIsUserInput() {
    Demo demo = new Demo();
    assertThrows(IllegalArgumentException.class, () -> {
      demo.configureSatelliteNames(null);
    });
  }

  @Test
  @DisplayName("configureSatelliteNames Satellite Names In are Satellite Names")
  void configureSatelliteNamesSatelliteNamesInAreSatelliteNamesOut() {
    Demo demo = new Demo();
    int count = generateRandomNumber();
    String[] inputSatelliteNames = new String[count];
    String inputString = String.valueOf(count) + "\n";
    for (int index = 0; index < count; index++) {
      String satelliteName = generateRandomString(generateRandomStringLength());
      inputSatelliteNames[index] = satelliteName;
      inputString += satelliteName + "\n";
    }
    assertArrayEquals(inputSatelliteNames, demo.configureSatelliteNames(new Scanner(inputString)));
  }

  @Test
  @DisplayName("runUseCases Scanner Input is Not Null")
  void runUseCasesScannerInputIsUserInput() {
    Demo demo = new Demo();
    assertThrows(IllegalArgumentException.class, () -> {
      demo.runUseCases(null);
    });
  }

  @Test
  @DisplayName("Secure Lock Tracking System Initialization Successful")
  void initSuccessful() {
    Demo demo = new Demo();
    demo.initSecureLockTrackSystem(
        generateRandomNumber(),
        generateRandomStringArray(generateRandomStringLength())
    );
    assertTrue(demo.getGpsSystem() != null && demo.getUser() != null);
  }

  private int generateRandomNumber() {
    return (int) (Math.random() * 100); 
  }

  private int generateRandomStringLength() {
    return (int) ((Math.random() * (20 - 1)) + 1); 
  }

  private String[] generateRandomStringArray(int length) { 
    String[] strings = new String[length];
    for (int index = 0; index < strings.length; index++) {
      strings[index] = generateRandomString(generateRandomStringLength());
    }
    return strings;
  }

  private String generateRandomString(int length) { 
    Random random = new Random();
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    char [] rndString = new char[length];

    for (int i = 0; i < length; i++) {
      rndString[i] = alphabet.charAt(random.nextInt(alphabet.length())); 
    }
    
    String createdString = new String(rndString);
    return createdString;
  }

}