package edu.oakland.production.admin;

import java.lang.IllegalArgumentException;
import java.util.Scanner;

public class Demo {

  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
  
  /**
   * Initiates the Secure Lock Track System.
   *
   * @param systemRfid The rfid number
   * @param persistentStorageInputLocation The input location.
   * @param persistentStorageOutputLocation The output location.
   */
  public void initSecureLockTrackSystem(int systemRfid, String persistentStorageInputLocation, String persistentStorageOutputLocation) {
    if (persistentStorageInputLocation == null) {
      throw new IllegalArgumentException("Input Location cannot be null");
    }  

    if (persistentStorageOutputLocation == null) {
      throw new IllegalArgumentException("Output Location cannot be null");
    }

    if (persistentStorageInputLocation.equals("")) {
      throw new IllegalArgumentException("Input Location cannot be empty");
    }  

    if (persistentStorageOutputLocation.equals("")) {
      throw new IllegalArgumentException("Output Location cannot be empty");
    }  
  }
  
  /**
   * Allows each use case to begin depending on user's choice.
   *
   * @param input The scanner used by the user.
   */
  public void runUseCases(Scanner input) {
    if (input == null) {
      throw new IllegalArgumentException("Scanner cannot be null");
    } 

  }
}