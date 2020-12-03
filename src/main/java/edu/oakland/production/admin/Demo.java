package edu.oakland.production.admin;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import edu.oakland.production.database.DatabaseCommInterface;
import edu.oakland.production.database.DatabaseCommInterfaceImplementation;
import edu.oakland.production.database.DatabaseCommManager;
import edu.oakland.production.database.DatabaseCommManagerImplementation;
import edu.oakland.production.database.DatabaseGisInterface;
import edu.oakland.production.database.DatabaseGisInterfaceImplementation;
import edu.oakland.production.database.DatabaseGisManager;
import edu.oakland.production.database.DatabaseGisManagerImplementation;
import edu.oakland.production.database.DatabasePersistentStorage;
import edu.oakland.production.database.DatabasePersistentStorageImplementation;
import edu.oakland.production.display01.DisplayGpsInterface;
import edu.oakland.production.display01.DisplayGpsInterfaceImplementation;
import edu.oakland.production.display01.DisplayGpsManager;
import edu.oakland.production.display01.DisplayGpsManagerImplementation;
import edu.oakland.production.display01.DisplayGpsReceiver;
import edu.oakland.production.display01.DisplayGpsReceiverImplementation;
import edu.oakland.production.display02.DisplayComm2WayInterface;
import edu.oakland.production.display02.DisplayComm2WayInterfaceImplementation;
import edu.oakland.production.display02.DisplayCommInterface;
import edu.oakland.production.display02.DisplayCommInterfaceImplementation;
import edu.oakland.production.display02.DisplayCommManager;
import edu.oakland.production.display02.DisplayCommManagerImplementation;
import edu.oakland.production.middleware01.MiddlewareGisInterface;
import edu.oakland.production.middleware01.MiddlewareGisInterfaceImplementation;
import edu.oakland.production.middleware01.MiddlewareGisManager;
import edu.oakland.production.middleware01.MiddlewareGisManagerImplementation;
import edu.oakland.production.middleware01.MiddlewareGisProcessor;
import edu.oakland.production.middleware01.MiddlewareGisProcessorImplementation;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterface;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterfaceImplementation;
import edu.oakland.production.middleware02.MiddlewareCommInterface;
import edu.oakland.production.middleware02.MiddlewareCommInterfaceImplementation;
import edu.oakland.production.middleware02.MiddlewareCommLinkManager;
import edu.oakland.production.middleware02.MiddlewareCommLinkManagerImplementation;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The main runner class for the Secure Lock Tracking Software Demo.
 *
 * @author Andrew Dimmer
 * @version %I%, %G%
 */
public class Demo {

  private GpsSystem gpsSystem;
  private User user;
  private boolean wasRun = false;

  /**
   * Gets the system RFID number from the user.
   *
   * @param input The scanner used by the user.
   * @return The system RFID number.
   */
  public int configureRfid(Scanner input) {
    if (input == null) {
      throw new IllegalArgumentException("Scanner cannot be null");
    }
    System.out.println("Enter the RFID number of the shipping container that this Secure Lock");
    System.out.println("Tracking System unit is attached to:");
    return input.nextInt();
  }

  /**
   * Gets the list of connected satellite to be used for the demo from the user.
   *
   * @param input The scanner used by the user.
   * @return The list of satellite names to use in the demo.
   */
  public String[] configureSatelliteNames(Scanner input) {
    if (input == null) {
      throw new IllegalArgumentException("Scanner cannot be null");
    }
    System.out.println("Enter the number of satellites in range:");
    int numberOfSatellites = input.nextInt();
    input.nextLine(); // Eat new line character
    String[] satelliteNames = new String[numberOfSatellites];
    for (int index = 0; index < numberOfSatellites; index++) {
      System.out.println("Enter the name of satellite " + (index + 1) + ":");
      satelliteNames[index] = input.nextLine();
    }
    return satelliteNames;
  }
  
  /**
   * Initiates the Secure Lock Track System.
   *
   * @param systemRfid The rfid number.
   * @param satelliteNames The list of satellite names.
   */
  public void initSecureLockTrackSystem(int systemRfid, String[] satelliteNames) {
    // Stand Up Database
    DatabasePersistentStorage database3 = new DatabasePersistentStorageImplementation(
        systemRfid,
        new ArrayList<LocationDataPoint>(),
        new ArrayList<TrackData>(),
        satelliteNames
    );
    DatabaseGisManager database01Class2 = new DatabaseGisManagerImplementation(database3);
    DatabaseCommManager database02Class2 = new DatabaseCommManagerImplementation(database3);
    DatabaseGisInterface database01Class1 =
        new DatabaseGisInterfaceImplementation(database01Class2);
    DatabaseCommInterface database02Class1 =
        new DatabaseCommInterfaceImplementation(database02Class2);

    // Stand Up Middleware01
    MiddlewareGisManager middleware01Class3 =
        new MiddlewareGisManagerImplementation(database01Class1);
    MiddlewareGisProcessor middleware01Class2 = new MiddlewareGisProcessorImplementation(
        middleware01Class3
    );
    MiddlewareGisInterface middleware01Class1 = new MiddlewareGisInterfaceImplementation(
        middleware01Class2
    );

    // Stand Up Middleware02
    MiddlewareCommDatabaseInterface middleware02Class3 =
        new MiddlewareCommDatabaseInterfaceImplementation(database02Class1);
    MiddlewareCommLinkManager middleware02Class2 = new MiddlewareCommLinkManagerImplementation(
        middleware02Class3,
        middleware01Class3
    );
    MiddlewareCommInterface middleware02Class1 = new MiddlewareCommInterfaceImplementation(
        middleware02Class2
    );

    // Stand Up Display01
    DisplayGpsManager display01Class3 = new DisplayGpsManagerImplementation(middleware01Class1);
    DisplayGpsReceiver display01Class2 = new DisplayGpsReceiverImplementation(
        display01Class3
    );
    DisplayGpsInterface display01Class1 = new DisplayGpsInterfaceImplementation(
        display01Class2
    );

    // Stand Up Display02
    DisplayCommManager display02Class3 = new DisplayCommManagerImplementation(middleware02Class1);
    DisplayComm2WayInterface display02Class2 = new DisplayComm2WayInterfaceImplementation(
        display02Class3
    );
    DisplayCommInterface display02Class1 = new DisplayCommInterfaceImplementation(
        display02Class2
    );

    // Stand Up End User Classes
    gpsSystem = new GpsSystem(display01Class1, satelliteNames);
    user = new User(display02Class1);
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
    char mode = ' ';
    do {
      System.out.println("Select a mode to demo:");
      System.out.println("1: View the current position and track data of a shipping container.");
      System.out.println("2: Simulate Satellite Signal Change.");
      System.out.println("q: Quit the Secure Lock Tracking System Demo.");
      mode = input.nextLine().charAt(0);
      try {
        switch (mode) {
          case '1':
            gpsSystem.runUseCase1(input);
            user.runUseCase1(input);
            break;
          case '2':
            gpsSystem.runUseCase2(input);
            break;
          case 'q':
            System.out.println("Exiting the Secure Lock Tracking System...");
            System.out.println("Please make sure you close the plotter to terminate the program.");
            break;
          default:
            System.out.println("Sorry... didn't quite catch that...");
            break;
        }
      } catch (IllegalArgumentException e) {
        System.out.println("Something didn't work right...");
        System.out.println(e);
      }
    } while (mode != 'q');
  }

  /**
   * Start the Secure Lock Tracking Software Demo.
   *
   * @param input The scanner used by the user.
   */
  public void run(Scanner input) {
    if (input == null) {
      throw new IllegalArgumentException("Scanner cannot be null");
    }
    System.out.println("Welcome to the Secure Lock Tracking Software!");
    int rfid = configureRfid(input);
    String[] satelliteNames = configureSatelliteNames(input);
    initSecureLockTrackSystem(rfid, satelliteNames);
    runUseCases(input);
    wasRun = true;
  }

  /**
   * Exposes the current GpsSystem for testing and verification. Not to be used for production.
   *
   * @return The GpsSystem object stored in the current instance of the Demo class.
   */
  public GpsSystem getGpsSystem() {
    return gpsSystem;
  }

  /**
   * Exposes the current User for testing and verification. Not to be used for production.
   *
   * @return The User object stored in the current instance of the Demo class.
   */
  public User getUser() {
    return user;
  }

  /**
   * Exposes the wasRun attribute for testing and verification. Not to be used for production.
   *
   * @return The boolean indicating the system was run.
   */
  public boolean getWasRun() {
    return wasRun;
  }

}
