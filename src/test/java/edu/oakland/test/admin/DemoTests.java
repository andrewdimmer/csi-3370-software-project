package edu.oakland.test.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.production.admin.Demo;
import java.lang.IllegalArgumentException;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Demo Unit Tests")
public class DemoTests { 


  @Test
  @DisplayName("Storage Input Location is Not Null")
  void storageInputLocIsNotNull() {
    int rfid = generateRandomNumber();
    int stringLength = generateRandomStringLength();
    String output = generateRandomString(stringLength);
    Demo demo = new Demo();
    assertThrows(IllegalArgumentException.class, () -> {
      demo.initSecureLockTrackSystem(rfid, null, output);
    });
  }

  @Test
  @DisplayName("Storage Output Location is Not Null")
  void storageOutputLocIsNotNull() {
    int rfid = generateRandomNumber();
    int stringLength = generateRandomStringLength();
    String input = generateRandomString(stringLength);
    Demo demo = new Demo();
    assertThrows(IllegalArgumentException.class, () -> {
      demo.initSecureLockTrackSystem(rfid, input, null);
    });
  }

  @Test
  @DisplayName("Storage Input Location is Not Empty")
  void storageInputLocIsNotEmpty() {
    int rfid = generateRandomNumber();
    int stringLength = generateRandomStringLength();
    String output = generateRandomString(stringLength);
    Demo demo = new Demo();
    assertThrows(IllegalArgumentException.class, () -> {
      demo.initSecureLockTrackSystem(rfid, "", output);
    });
  }

  @Test
  @DisplayName("Storage Output Location is Not Empty")
  void storageOutputLocIsNotEmpty() {
    int rfid = generateRandomNumber();
    int stringLength = generateRandomStringLength();
    String input = generateRandomString(stringLength);
    Demo demo = new Demo();
    assertThrows(IllegalArgumentException.class, () -> {
      demo.initSecureLockTrackSystem(rfid, input, "");
    });
  }

  @Test
  @DisplayName("Scanner Input is Not Null")
  void scannerInputIsUserInput() {
    Demo demo = new Demo();
    assertThrows(IllegalArgumentException.class, () -> {
      demo.runUseCases(null);
    });
  }

  private int generateRandomNumber() {
    return (int) (Math.random() * 100); 
  }

  private int generateRandomStringLength() {
    return (int) ((Math.random() * (20 - 1)) + 1); 
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