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

@DisplayName("Use Case 1 Integration Tests")
public class Uc1IntegrationTests { 

  @Test
  @DisplayName("RFID Requested Does Not Match System RFID")
  void rfidDoesNotMatch() {
    int rfid = generateRandomNumber();
    Demo demo = new Demo();
    demo.initSecureLockTrackSystem(
        rfid + generateRandomNumber(),
        generateRandomStringArray(generateRandomStringLength())
    );
    String gpsOutput = demo.getGpsSystem().runUseCase1(new Scanner(""));
    TrackData userOutput = demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    assertEquals(
        "The system RFID does not match the requested RFID.",
        userOutput.getStatusMessage()
    );
    assertEquals(0, userOutput.getLocationDataPoints().length);
  }

  @Test
  @DisplayName("RFID Requested Matches System RFID but There is Not Enough Data")
  void rfidMatchesButNotEnoughData() {
    int rfid = generateRandomNumber();
    Demo demo = new Demo();
    demo.initSecureLockTrackSystem(
        rfid,
        generateRandomStringArray(generateRandomStringLength())
    );
    for (int i = 0; i < (int) (Math.random() * 3) + 1; i++) {
      String gpsOutput = demo.getGpsSystem().runUseCase1(new Scanner(""));
      TrackData userOutput = demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
      assertTrue(
          userOutput.getStatusMessage().contains("normal mode, but there's not enough data")
      );
      assertEquals(i + 1, userOutput.getLocationDataPoints().length);
    }
  }

  @Test
  @DisplayName("RFID Requested Matches System RFID and There is Enough Data")
  void rfidMatchesAndEnoughData() {
    int rfid = generateRandomNumber();
    Demo demo = new Demo();
    demo.initSecureLockTrackSystem(
        rfid,
        generateRandomStringArray(generateRandomStringLength())
    );
    for (int i = 0; i < 4; i++) {
      String gpsOutput = demo.getGpsSystem().runUseCase1(new Scanner(""));
      TrackData userOutput = demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
    }
    for (int i = 0; i < (int) (Math.random() * 10) + 1; i++) {
      String gpsOutput = demo.getGpsSystem().runUseCase1(new Scanner(""));
      TrackData userOutput = demo.getUser().runUseCase1(new Scanner(String.valueOf(rfid) + "\n"));
      assertTrue(userOutput.getStatusMessage().contains("normal mode and has enough data"));
      assertEquals(5, userOutput.getLocationDataPoints().length);
    }
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