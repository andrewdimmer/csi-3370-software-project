package edu.oakland.test.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.production.admin.GpsSystem;
import edu.oakland.test.admin.DisplayGpsInterfaceStub;
import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("GpsSystem Unit Tests")
public class GpsSystemTests {

  @Test
  @DisplayName("Init Display GpsInterface Not Null")
  void initDisplayGpsInterfaceNotNull() {
    Random rnd = new Random();                          
    //make a moderately long array of random strings
    int rndLength = rnd.nextInt(100) + 1;
    String[] str = new String[rndLength];
    for (int i = 0; i < rndLength; i++) {
      str[i] = generateRandomNames();
    }
    assertThrows(IllegalArgumentException.class, () -> {
      new GpsSystem(null, str);
    });
  }
  
  @Test
  @DisplayName("Init Satelllite Names Not Null")
  void initSatelliteNamesNotNull() {
    DisplayGpsInterfaceStub stub = new DisplayGpsInterfaceStub();
    assertThrows(IllegalArgumentException.class, () -> {
      new GpsSystem(stub, null);
    });
  }

  @Test
  @DisplayName("Init Satelllite Names Not Empty")
  void initSatelliteNamesNotEmpty() {
    DisplayGpsInterfaceStub stub = new DisplayGpsInterfaceStub();
    assertThrows(IllegalArgumentException.class, () -> {
      new GpsSystem(stub, new String[0]);
    });
  }
  
  @Test
  @DisplayName("Each Init Satelllite Name Not Empty")
  void initEachSatelliteNameNotEmpty() {
    DisplayGpsInterfaceStub stub = new DisplayGpsInterfaceStub();
    Random rnd = new Random();                                    
    //make a moderately long array of random strings
    int rndLength = rnd.nextInt(100) + 1;
    String[] str = new String[rndLength];
    for (int i = 0; i < rndLength; i++) {
      str[i] = generateRandomNames();
    }
    str[rnd.nextInt(rndLength)] = "";                              
    //set random item in array to be empty
    assertThrows(IllegalArgumentException.class, () -> {
      new GpsSystem(stub, str);
    });
  }
  
  @Test
  @DisplayName("GPS Systems Constructed Successfully")
  void gpsSystemsConstructedSuccessfully() {
    try {
      DisplayGpsInterfaceStub stub = new DisplayGpsInterfaceStub();
      Random rnd = new Random();                          
      //make a moderately long array of random strings
      int rndLength = rnd.nextInt(100) + 1;
      String[] str = new String[rndLength];
      for (int i = 0; i < rndLength; i++) {
        str[i] = generateRandomNames();
      }
      GpsSystem gpsSystem = new GpsSystem(stub, str);
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }
  
  @Test
  @DisplayName("InitLocationDataPoint Not Null")
  void initLocationDataPointNotNull() {
    DisplayGpsInterfaceStub stub = new DisplayGpsInterfaceStub();
    Random rnd = new Random();
    String[] satelliteNames = new String[10];
    for (int i = 0; i < 10; i++) {
      satelliteNames[i] = generateRandomNames();
    }
    float incrementLatAmount = rnd.nextFloat() * 40;
    float incrementLngAmount = rnd.nextFloat() * 40;
    GpsSystem gpsSystem = new GpsSystem(stub, satelliteNames);
    assertThrows(IllegalArgumentException.class, () -> {
      gpsSystem.configureSatellites(satelliteNames, incrementLatAmount, incrementLngAmount, null);
    });
  }
  
  @Test
  @DisplayName("Configure Satellites Run Successfully")
  void configureSatellitesRunSuccessfully() {
    DisplayGpsInterfaceStub stub = new DisplayGpsInterfaceStub();
    Random rnd = new Random();
    String[] satelliteNames = new String[10];
    for (int i = 0; i < 10; i++) {
      satelliteNames[i] = generateRandomNames();
    }
    float incrementLatAmount = rnd.nextFloat() * 40;
    float incrementLngAmount = rnd.nextFloat() * 40;
    GpsSystem gpsSystem = new GpsSystem(stub, satelliteNames);
    LocationDataPoint ldp = generateRandomLocationDataPoint();
    try {
      gpsSystem.configureSatellites(satelliteNames, incrementLatAmount, incrementLngAmount, ldp);
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  @DisplayName("Use Case 1 Scanner Not Null")
  void uc1ScannerNotNull() {
    DisplayGpsInterfaceStub stub = new DisplayGpsInterfaceStub();
    Random rnd = new Random();
    String[] satelliteNames = new String[10];
    for (int i = 0; i < 10; i++) {
      satelliteNames[i] = generateRandomNames();
    }
    GpsSystem gpsSystem = new GpsSystem(stub, satelliteNames);
    assertThrows(IllegalArgumentException.class, () -> {
      gpsSystem.runUseCase1(null);
    });
  }

  @Test
  @DisplayName("Use Case 2 Scanner Not Null")
  void uc2ScannerNotNull() {
    DisplayGpsInterfaceStub stub = new DisplayGpsInterfaceStub();
    Random rnd = new Random();
    String[] satelliteNames = new String[10];
    for (int i = 0; i < 10; i++) {
      satelliteNames[i] = generateRandomNames();
    }
    GpsSystem gpsSystem = new GpsSystem(stub, satelliteNames);
    assertThrows(IllegalArgumentException.class, () -> {
      gpsSystem.runUseCase2(null);
    });
  }
  
  
  
  
  
  private String generateRandomNames() { 
    int length = 10;
    Random random = new Random();
    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    char [] rndString = new char[length];

    for (int i = 0; i < length; i++) { 
      //Create array of characters for desired length
      rndString[i] = alphabet.charAt(random.nextInt(alphabet.length())); 
    }
    
    String createdString = new String(rndString);
    return createdString;
  }
  //Random String Generator Learned From:
  //https://stackoverflow.com/questions/2863852/how-to-generate-a-random-string-in-java
  
  private LocationDataPoint generateRandomLocationDataPoint() {  
    //borrowed from Andrew, thanks!
    return new LocationDataPoint(
      (float) (Math.random() * 180 - 90),
      (float) (Math.random() * 360 - 180),
      LocalDateTime.of(
        (int) (Math.random() * 50 + 1970),
        (int) (Math.random() * 12 + 1),
        (int) (Math.random() * 28 + 1),
        (int) (Math.random() * 24),
        (int) (Math.random() * 60)
      )
    );
  }
  
  private float makeRandomPos() {   
    //will return a float value between -90.0 and 90.0
    Random rnd = new Random();
    return rnd.nextFloat() * 180 - 90;
  }
}
