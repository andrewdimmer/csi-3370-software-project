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
import edu.oakland.production.middleware02.MiddlewareCommInterface;
import edu.oakland.production.middleware02.MiddlewareCommInterfaceImplementation;
import edu.oakland.production.middleware02.MiddlewareCommLinkManager;
import edu.oakland.production.middleware02.MiddlewareCommLinkManagerImplementation;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterface;
import edu.oakland.production.middleware02.MiddlewareCommDatabaseInterfaceImplementation;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {

  private GpsSystem gpsSystem;
  private User user;

  public int configureRfid(Scanner input) {
    if (input == null) {
      throw new IllegalArgumentException("Scanner cannot be null");
    }
    System.out.println("Enter the RFID number of the shipping container that this Secure Lock");
    System.out.println("Tracking System unit is attached to:");
    return input.nextInt();
  }

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
    DatabaseGisManager database01_2 = new DatabaseGisManagerImplementation(database3);
    DatabaseCommManager database02_2 = new DatabaseCommManagerImplementation(database3);
    DatabaseGisInterface database01_1 = new DatabaseGisInterfaceImplementation(database01_2);
    DatabaseCommInterface database02_1 = new DatabaseCommInterfaceImplementation(database02_2);

    // Stand Up Middleware01
    MiddlewareGisManager middleware01_3 = new MiddlewareGisManagerImplementation(database01_1);
    MiddlewareGisProcessor middleware01_2 = new MiddlewareGisProcessorImplementation(
        middleware01_3
    );
    MiddlewareGisInterface middleware01_1 = new MiddlewareGisInterfaceImplementation(
        middleware01_2
    );

    // Stand Up Middleware02
    MiddlewareCommDatabaseInterface middleware02_3 =
        new MiddlewareCommDatabaseInterfaceImplementation(database02_1);
    MiddlewareCommLinkManager middleware02_2 = new MiddlewareCommLinkManagerImplementation(
        middleware02_3,
        middleware01_3
    );
    MiddlewareCommInterface middleware02_1 = new MiddlewareCommInterfaceImplementation(
        middleware02_2
    );

    // Stand Up Display01
    DisplayGpsManager display01_3 = new DisplayGpsManagerImplementation(middleware01_1);
    DisplayGpsReceiver display01_2 = new DisplayGpsReceiverImplementation(
        display01_3
    );
    DisplayGpsInterface display01_1 = new DisplayGpsInterfaceImplementation(
        display01_2
    );

    // Stand Up Display02
    DisplayCommManager display02_3 = new DisplayCommManagerImplementation(middleware02_1);
    DisplayComm2WayInterface display02_2 = new DisplayComm2WayInterfaceImplementation(
        display02_3
    );
    DisplayCommInterface display02_1 = new DisplayCommInterfaceImplementation(
        display02_2
    );

    // Stand Up End User Classes
    gpsSystem = new GpsSystem(display01_1, satelliteNames);
    user = new User(display02_1);
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
   * Allows each use case to begin depending on user's choice.
   *
   * @param input The scanner used by the user.
   */
  public void runUseCases(Scanner input) {
    if (input == null) {
      throw new IllegalArgumentException("Scanner cannot be null");
    } 
  }

  public static void main(String[] args) {
    System.out.println("Welcome to the Secure Lock Tracking Software!");
    Demo demo = new Demo();
    Scanner scanner = new Scanner(System.in);
    int rfid = demo.configureRfid(scanner);
    String[] satelliteNames = demo.configureSatelliteNames(scanner);
    demo.initSecureLockTrackSystem(rfid, satelliteNames);
  }

}
