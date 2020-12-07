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

@DisplayName("Use Case 1 and Use Case 2 Joint Integration Tests")
public class Uc1AndUc2IntegrationTests { 

  @Test
  @DisplayName("Historical Data Returned In Degraded Mode")
  void historicalDataReturnedInDegradedMode() {
    int rfid = generateRandomNumber();
    Demo demo = new Demo();
    demo.initSecureLockTrackSystem(
        rfid,
        generateRandomStringArray(2)
    );
    for (int i = 0; i < 4; i++) {
      demo.getGpsSystem().runUseCase1(new Scanner(""));
      demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    }
    for (int i = 0; i < (int) (Math.random() * 15) + 1; i++) {
      demo.getGpsSystem().runUseCase1(new Scanner(""));
      demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    }
    demo.getGpsSystem().runUseCase1(new Scanner(""));
    TrackData userOutput1 = demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    demo.getGpsSystem().runUseCase2(new Scanner("0\n1\n1\n"));
    demo.getGpsSystem().runUseCase1(new Scanner(""));
    TrackData userOutput2 = demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    assertTrue(userOutput2.getStatusMessage().contains("degraded"));
    assertEquals(userOutput1, userOutput2);
  }

  @Test
  @DisplayName("Historical Data Returned In Standby Mode")
  void historicalDataReturnedInStandbyMode() {
    int rfid = generateRandomNumber();
    Demo demo = new Demo();
    demo.initSecureLockTrackSystem(
        rfid,
        generateRandomStringArray(2)
    );
    for (int i = 0; i < 4; i++) {
      demo.getGpsSystem().runUseCase1(new Scanner(""));
      demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    }
    for (int i = 0; i < (int) (Math.random() * 15) + 1; i++) {
      demo.getGpsSystem().runUseCase1(new Scanner(""));
      demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    }
    demo.getGpsSystem().runUseCase1(new Scanner(""));
    TrackData userOutput1 = demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    demo.getGpsSystem().runUseCase2(new Scanner("0\n1\n1\n"));
    demo.getGpsSystem().runUseCase2(new Scanner("1\n1\n1\n"));
    demo.getGpsSystem().runUseCase1(new Scanner(""));
    TrackData userOutput2 = demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    assertTrue(userOutput2.getStatusMessage().contains("standby"));
    assertEquals(userOutput1, userOutput2);
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
    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    char [] rndString = new char[length];

    for (int i = 0; i < length; i++) {
      rndString[i] = alphabet.charAt(random.nextInt(alphabet.length())); 
    }
    
    String createdString = new String(rndString);
    return createdString;
  }
  //Random String Generator Learned From:
  //https://stackoverflow.com/questions/2863852/how-to-generate-a-random-string-in-java

}