package edu.oakland.integration;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.admin.Demo;
import java.lang.IllegalArgumentException;
import java.util.Random;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Use Case 2 Integration Tests")
public class Uc2IntegrationTests { 

  @Test
  @DisplayName("In normal mode, primary signal changes but remain in normal mode")
  void primaryNormalToNormal() {
    int rfid = generateRandomNumber();
    Demo demo = new Demo();
    demo.initSecureLockTrackSystem(
        rfid,
        generateRandomStringArray(2)
    );
    demo.getGpsSystem().runUseCase2(new Scanner(
        "0\n" + generateRandomPassingStrength() + "\n"
    ));
    TrackData userOutput = demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    assertTrue(userOutput.getStatusMessage().contains("normal"));
  }

  @Test
  @DisplayName("In normal mode, primary signal changes and mode switches to degraded mode")
  void primaryNormalToDegraded() {
    int rfid = generateRandomNumber();
    Demo demo = new Demo();
    demo.initSecureLockTrackSystem(
        rfid,
        generateRandomStringArray(2)
    );
    demo.getGpsSystem().runUseCase2(new Scanner(
        "0\n" + generateRandomFailingStrength() + "\n" + generateRandomFailingStrength() + "\n"
    ));
    TrackData userOutput = demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    assertTrue(userOutput.getStatusMessage().contains("degraded"));
  }

  @Test
  @DisplayName("In degraded mode, primary signal changes but remains in degraded mode")
  void primaryDegradedToDegraded() {
    int rfid = generateRandomNumber();
    Demo demo = new Demo();
    demo.initSecureLockTrackSystem(
        rfid,
        generateRandomStringArray(2)
    );
    demo.getGpsSystem().runUseCase2(new Scanner(
        "0\n" + generateRandomFailingStrength() + "\n" + generateRandomFailingStrength() + "\n"
    ));
    demo.getGpsSystem().runUseCase2(new Scanner(
        "1\n" + generateRandomPassingStrength() + "\n"
    ));
    TrackData userOutput = demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    assertTrue(userOutput.getStatusMessage().contains("degraded"));
  }

  @Test
  @DisplayName("In degraded mode, secondary signal changes but remains in degraded mode")
  void secondaryDegradedToDegraded() {
    int rfid = generateRandomNumber();
    Demo demo = new Demo();
    demo.initSecureLockTrackSystem(
        rfid,
        generateRandomStringArray(2)
    );
    demo.getGpsSystem().runUseCase2(new Scanner(
        "0\n" + generateRandomFailingStrength() + "\n" + generateRandomFailingStrength() + "\n"
    ));
    demo.getGpsSystem().runUseCase2(new Scanner(
        "0\n" + generateRandomFailingStrength() + "\n" + generateRandomFailingStrength() + "\n"
    ));
    TrackData userOutput = demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    assertTrue(userOutput.getStatusMessage().contains("degraded"));
  }

  @Test
  @DisplayName("In degraded mode, primary signal changes and mode switches to standby mode")
  void primaryDegradedToStandby() {
    int rfid = generateRandomNumber();
    Demo demo = new Demo();
    demo.initSecureLockTrackSystem(
        rfid,
        generateRandomStringArray(2)
    );
    demo.getGpsSystem().runUseCase2(new Scanner(
        "0\n" + generateRandomFailingStrength() + "\n" + generateRandomFailingStrength() + "\n"
    ));
    demo.getGpsSystem().runUseCase2(new Scanner(
        "1\n" + generateRandomFailingStrength() + "\n" + generateRandomFailingStrength() + "\n"
    ));
    TrackData userOutput = demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    assertTrue(userOutput.getStatusMessage().contains("standby"));
  }

  @Test
  @DisplayName("In degraded mode, secondary signal changes and mode switches to normal mode")
  void secondaryDegradedToNormal() {
    int rfid = generateRandomNumber();
    Demo demo = new Demo();
    demo.initSecureLockTrackSystem(
        rfid,
        generateRandomStringArray(2)
    );
    demo.getGpsSystem().runUseCase2(new Scanner(
        "0\n" + generateRandomFailingStrength() + "\n" + generateRandomFailingStrength() + "\n"
    ));
    demo.getGpsSystem().runUseCase2(new Scanner(
        "0\n" + generateRandomPassingStrength() + "\n"
    ));
    TrackData userOutput = demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    assertTrue(userOutput.getStatusMessage().contains("normal"));
  }

  @Test
  @DisplayName("In standby mode, primary signal changes but remains in standby mode")
  void primaryStandbyToStandby() {
    int rfid = generateRandomNumber();
    Demo demo = new Demo();
    demo.initSecureLockTrackSystem(
        rfid,
        generateRandomStringArray(2)
    );
    demo.getGpsSystem().runUseCase2(new Scanner(
        "0\n" + generateRandomFailingStrength() + "\n" + generateRandomFailingStrength() + "\n"
    ));
    demo.getGpsSystem().runUseCase2(new Scanner(
        "1\n" + generateRandomFailingStrength() + "\n" + generateRandomFailingStrength() + "\n"
    ));
    demo.getGpsSystem().runUseCase2(new Scanner(
        "0\n" + generateRandomFailingStrength() + "\n" + generateRandomFailingStrength() + "\n"
    ));
    TrackData userOutput = demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    assertTrue(userOutput.getStatusMessage().contains("standby"));
  }

  @Test
  @DisplayName("In standby mode, secondary signal changes but remains in standby mode")
  void secondaryStandbyToStandby() {
    int rfid = generateRandomNumber();
    Demo demo = new Demo();
    demo.initSecureLockTrackSystem(
        rfid,
        generateRandomStringArray(2)
    );
    demo.getGpsSystem().runUseCase2(new Scanner(
        "0\n" + generateRandomFailingStrength() + "\n" + generateRandomFailingStrength() + "\n"
    ));
    demo.getGpsSystem().runUseCase2(new Scanner(
        "1\n" + generateRandomFailingStrength() + "\n" + generateRandomFailingStrength() + "\n"
    ));
    demo.getGpsSystem().runUseCase2(new Scanner(
        "1\n" + generateRandomFailingStrength() + "\n" + generateRandomFailingStrength() + "\n"
    ));
    TrackData userOutput = demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    assertTrue(userOutput.getStatusMessage().contains("standby"));
  }

  @Test
  @DisplayName("In standby mode, primary signal changes and mode switches to degraded mode")
  void primaryStandbyToDegraded() {
    int rfid = generateRandomNumber();
    Demo demo = new Demo();
    demo.initSecureLockTrackSystem(
        rfid,
        generateRandomStringArray(2)
    );
    demo.getGpsSystem().runUseCase2(new Scanner(
        "0\n" + generateRandomFailingStrength() + "\n" + generateRandomFailingStrength() + "\n"
    ));
    demo.getGpsSystem().runUseCase2(new Scanner(
        "1\n" + generateRandomFailingStrength() + "\n" + generateRandomFailingStrength() + "\n"
    ));
    demo.getGpsSystem().runUseCase2(new Scanner(
        "0\n" + generateRandomPassingStrength() + "\n"
    ));
    TrackData userOutput = demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    assertTrue(userOutput.getStatusMessage().contains("degraded"));
  }

  @Test
  @DisplayName("In standby mode, secondary signal changes and mode switches to degraded mode")
  void secondaryStandbyToDegraded() {
    int rfid = generateRandomNumber();
    Demo demo = new Demo();
    demo.initSecureLockTrackSystem(
        rfid,
        generateRandomStringArray(2)
    );
    demo.getGpsSystem().runUseCase2(new Scanner(
        "0\n" + generateRandomFailingStrength() + "\n" + generateRandomFailingStrength() + "\n"
    ));
    demo.getGpsSystem().runUseCase2(new Scanner(
        "1\n" + generateRandomFailingStrength() + "\n" + generateRandomFailingStrength() + "\n"
    ));
    demo.getGpsSystem().runUseCase2(new Scanner(
        "1\n" + generateRandomPassingStrength() + "\n"
    ));
    TrackData userOutput = demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    assertTrue(userOutput.getStatusMessage().contains("degraded"));
  }

  @Test
  @DisplayName("Use Case 2 Runner Handles Modifing Invalid Satellite")
  void handleModifyingInvalidSatellite() {
    int rfid = generateRandomNumber();
    Demo demo = new Demo();
    demo.initSecureLockTrackSystem(
        rfid,
        generateRandomStringArray(2)
    );
    assertThrows(IllegalArgumentException.class, () -> {
      demo.getGpsSystem().runUseCase2(new Scanner(
          "1\n" + generateRandomFailingStrength() + "\n" + generateRandomFailingStrength() + "\n"
      ));
    });
  }

  private int generateRandomNumber() {
    return (int) (Math.random() * 100) + 1; 
  }

  private int generateRandomFailingStrength() {
    return (int) (Math.random() * 3) + 1; 
  }

  private int generateRandomPassingStrength() {
    return (int) (Math.random() * 6) + 4; 
  }

  private int generateRandomStringLength() {
    return (int) ((Math.random() * (20)) + 1); 
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