package edu.oakland.test.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.production.admin.User;
import edu.oakland.production.display02.DisplayCommInterface;
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
    /*User user=new User(new DisplayCommInterface()); 
    assertThrows(IllegalArgumentException.class, () -> {
      user.runUseCase1(null);
    });*/
  } //I don't think I am thinking about this correctly
  //Cannot do it this way because an object cannot be created from interface

  @Test
  @DisplayName("TrackDataIsRequested")
  void trackDataIsRequested() {
  
  }  
  

}

