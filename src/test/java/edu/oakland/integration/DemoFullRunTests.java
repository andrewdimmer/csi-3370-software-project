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

@DisplayName("Demo Runner Full System Tests")
public class DemoFullRunTests { 

  @Test
  @DisplayName("Can Run Use Case 1")
  void canRunUc1() {
    int rfid = generateRandomNumber();
    int count = generateRandomStringLength();
    String inputString = String.valueOf(rfid) + "\n";
    inputString += String.valueOf(count) + "\n";
    for (int index = 0; index < count; index++) {
      inputString += generateRandomString(generateRandomStringLength()) + "\n";
    }
    for (int index = 0; index < (int) (Math.random() * 15) + 1; index++) {
      inputString += "1\n" + String.valueOf(rfid) + "\n";
    }
    inputString += "q\n";
    Demo demo = new Demo();
    demo.run(new Scanner(inputString));
    assertTrue(demo.getWasRun());
  }

  @Test
  @DisplayName("Can Run Use Case 2")
  void canRunUc2() {
    int rfid = generateRandomNumber();
    int count = generateRandomStringLength();
    String inputString = String.valueOf(rfid) + "\n";
    inputString += String.valueOf(count) + "\n";
    for (int index = 0; index < count; index++) {
      inputString += generateRandomString(generateRandomStringLength()) + "\n";
    }
    inputString += "2\n0\n5\nq\n";
    Demo demo = new Demo();
    demo.run(new Scanner(inputString));
    assertTrue(demo.getWasRun());
  }

  @Test
  @DisplayName("Can Handle Errors In Use Cases")
  void canHandleErrosInUseCase() {
    int rfid = generateRandomNumber();
    int count = generateRandomStringLength();
    String inputString = String.valueOf(rfid) + "\n";
    inputString += String.valueOf(count) + "\n";
    for (int index = 0; index < count; index++) {
      inputString += generateRandomString(generateRandomStringLength()) + "\n";
    }
    inputString += "2\n1\nq\n";
    Demo demo = new Demo();
    demo.run(new Scanner(inputString));
    assertTrue(demo.getWasRun());
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