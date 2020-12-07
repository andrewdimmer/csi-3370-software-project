package edu.oakland.production.admin;

import edu.oakland.production.admin.Demo;
import java.util.Scanner;

/**
 * A simple Main class that contains the main method for the Secure Lock Tracking System Demo.
 * This was moved to it's own class to exclude it from the code coverage report because Gradle
 * does not allow the tests access to System.in.
 *
 * @author Andrew Dimmer
 * @version %I%, %G%
 */
public class Main {

  /**
   * Start the Secure Lock Tracking System Demo.
   */
  public static void main(String[] args) {
    (new Demo()).run(new Scanner(System.in));
    System.exit(0);
  }

}