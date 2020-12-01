package edu.oakland.production.admin;

import java.lang.IllegalArgumentException;
import java.util.Scanner;

public class Demo {

  public static void main(String[] args) {
    System.out.println("Hello World!");
  }

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

  public void runUseCases(Scanner input) {
    if (input == null) {
      throw new IllegalArgumentException("Scanner cannot be null");
    } 

  }
}