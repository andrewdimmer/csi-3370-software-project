package edu.oakland.test.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.admin.User;
import edu.oakland.test.admin.DisplayCommInterfaceStub;
import java.lang.IllegalArgumentException;
import java.util.Random;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("User Unit Tests")
public class UserTests {

  @Test
  @DisplayName("Display Comm Interface Is Not Null")
  void displayCommInterfaceIsNotNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new User(null);
    });
  }

  @Test
  @DisplayName("Scanner is Not Null") 
  void userInputIsScanInput() {
    DisplayCommInterfaceStub stub = new DisplayCommInterfaceStub();
    User user = new User(stub); 
    assertThrows(IllegalArgumentException.class, () -> {
      user.runUseCase1(null);
    });
  } 

  @Test
  @DisplayName("TrackDataIsRequested")
  void trackDataIsRequested() {
    DisplayCommInterfaceStub stub = new DisplayCommInterfaceStub();
    User user = new User(stub); 


  }  
  
  private int generateRandomNumber() {
    return (int) ((Math.random() * (100 - 1)) + 1); 
  }

}

