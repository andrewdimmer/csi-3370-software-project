package edu.oakland.production.admin;

import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.display02.DisplayCommInterface;
import java.lang.IllegalArgumentException;
import java.util.Scanner;

/**
 * A production class that allows a user to be created so that Use Case One 
 * (SLTS location and track data is requested) can be initiated.
 *
 * @author Tessa Peruzzi
 * @version %I%, %G%
 */
public class User {
  private DisplayCommInterface displayCommInterface;

  /**
   * Creates a new User object with the given DisplayCommInterface.
   *
   * @param displayCommInterface The DisplayCommInterface
   */
  public User(DisplayCommInterface displayCommInterface) {
    if (displayCommInterface == null) {
      throw new IllegalArgumentException("Display Comm Interface cannot be null");
    }
    this.displayCommInterface = displayCommInterface;
  }

  /**
   * Allows the user to initiate Use Case One by accepting a scanner that
   * should ask for an RFID number. DisplayCommInterface will then
   * create a new TrackData Object.
   *
   * @param input The Scanner used to intake the RFID number
   */
  public TrackData runUseCase1(Scanner input) {
    if (input == null) {
      throw new IllegalArgumentException("Scanner cannot be null");
    }
    System.out.println("Enter the RFID number of the shipping container you want to track:");
    int rfid = input.nextInt();
    input.nextLine(); // Eat new line character
    System.out.println();
    return displayCommInterface.receiveRfidRequest(rfid);
  }



}