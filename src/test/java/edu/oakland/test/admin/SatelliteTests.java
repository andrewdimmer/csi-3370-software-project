package edu.oakland.test.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.Satellite;
import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Satellite Unit Tests")
public class SatelliteTests { 


  @Test
  @DisplayName("Satellite Name In Is Satellite Name Out")
  void satNameInIsSatNameOut() {
    int strength = generateRandomStrength();
    int rndStrLength = generateRandomStringLength();
    String name = generateRandomString(rndStrLength); 
    Satellite theSatellite = new Satellite(name, strength);
    assertEquals(name, theSatellite.getSatelliteName());
  }

  @Test
  @DisplayName("Strength in is Strength Out for Constructor")
  void strengthInIsStrengthOutConstructor() {
    int strength = generateRandomStrength();
    int rndStrLength = generateRandomStringLength();
    String name = generateRandomString(rndStrLength);
    Satellite theSatellite = new Satellite(name, strength);
    assertEquals(strength, theSatellite.getStrength());
  }


  @Test
  @DisplayName("Strength in is Strength Out Setter")
  void strengthInIsStrengthOutSetter() {
    int strength = generateRandomStrength();
    int rndStrLength = generateRandomStringLength();
    String name = generateRandomString(rndStrLength);
    Satellite theSatellite = new Satellite(name, strength);
    int newStrength = generateRandomStrength();
    theSatellite.setStrength(newStrength);
    assertEquals(newStrength, theSatellite.getStrength());
  }

  @Test
  @DisplayName("Strength Not Less Than One Constructor")
  void strengthNotLessThanOneConstructor() {
    int rndStrLength = generateRandomStringLength();
    String name = generateRandomString(rndStrLength);
    assertThrows(IllegalArgumentException.class, () -> {
      new Satellite(name, generateLessThanOne());
    });
  }

  @Test
  @DisplayName("Strength Is Not More Than 10 Constructor")
  void strengthNotMoreThanTenConstructor() {
    int rndStrLength = generateRandomStringLength();
    String name = generateRandomString(rndStrLength);
    assertThrows(IllegalArgumentException.class, () -> {
      new Satellite(name, generateMoreThanTen());
    });
  }

  @Test
  @DisplayName("Strength is Not Less Than One Setter")
  void strengthNotLessThanOneSetter() {
    int strength = generateRandomStrength();
    int rndStrLength = generateRandomStringLength();
    String name = generateRandomString(rndStrLength);
    Satellite theSatellite = new Satellite(name, strength);
    assertThrows(IllegalArgumentException.class, () -> {
      int newStrength = generateLessThanOne();
      theSatellite.setStrength(newStrength);
    });
  }

  @Test
  @DisplayName("Strength is Not More Than Ten Setter")
  void strengthNotMoreThanTenSetter() {
    int strength = generateRandomStrength();
    int rndStrLength = generateRandomStringLength();
    String name = generateRandomString(rndStrLength);
    Satellite theSatellite = new Satellite(name, strength);
    assertThrows(IllegalArgumentException.class, () -> {
      int newStrength = generateMoreThanTen();
      theSatellite.setStrength(newStrength);
    });
  }

  @Test
  @DisplayName("Get Location 0 is Correct")
  void getLocation0IsCorrect() {
    LocationDataPoint thePoint = generateRandomLocationDataPoint();
    float x = generateRandomIncrements();
    float y = generateRandomIncrements();
    Satellite.satelliteInit(0, 0, thePoint);
    int strength = generateRandomStrength();
    int rndStrLength = generateRandomStringLength();
    String name = generateRandomString(rndStrLength);
    Satellite theSatellite = new Satellite(name, strength);
    LocationDataPoint outputPoint = theSatellite.getLocation();
    assertEquals(thePoint.getLat(), outputPoint.getLat(), .001);
    assertEquals(thePoint.getLng(), outputPoint.getLng(), .001);
    assertEquals(thePoint.getTime(), outputPoint.getTime());
  }
  
  @Test
  @DisplayName("Get Location 1 is Correct") 
  void getLocation1IsCorrect() {
    LocationDataPoint initPoint = generateRandomLocationDataPoint();
    float x = generateRandomIncrements();
    float y = generateRandomIncrements();
    Satellite.satelliteInit(x, y, initPoint);
    int strength = generateRandomStrength();
    int rndStrLength = generateRandomStringLength();
    String name = generateRandomString(rndStrLength);
    Satellite theSatellite = new Satellite(name, strength);
    theSatellite.getLocation(); // Call the first point, but don't test it
    LocationDataPoint outputPoint = theSatellite.getLocation();
    LocationDataPoint expectedPoint = new LocationDataPoint(
        initPoint.getLat() + x,
        initPoint.getLng() + y,
        initPoint.getTime().plusHours(1)
    );
    assertEquals(expectedPoint.getLat(), outputPoint.getLat(), .001);
    assertEquals(expectedPoint.getLng(), outputPoint.getLng(), .001);
    assertEquals(expectedPoint.getTime(), outputPoint.getTime());
  }

  @Test
  @DisplayName("Get Nth Location is Correct") 
  void getNthLocationIsCorrect() {
    LocationDataPoint initPoint = generateRandomLocationDataPoint();
    float x = generateRandomIncrements();
    float y = generateRandomIncrements();
    Satellite.satelliteInit(x, y, initPoint);
    int strength = generateRandomStrength();
    int rndStrLength = generateRandomStringLength();
    String name = generateRandomString(rndStrLength);
    Satellite theSatellite = new Satellite(name, strength);
    int numberOfCalls = generateRandomStringLength();
    for (int index = 0; index < numberOfCalls; index++) {
      theSatellite.getLocation();
    }
    LocationDataPoint outputPoint = theSatellite.getLocation();
    LocationDataPoint expectedPoint = new LocationDataPoint(
        initPoint.getLat() + (x * numberOfCalls),
        initPoint.getLng() + (y * numberOfCalls),
        initPoint.getTime().plusHours(numberOfCalls)
    );
    assertEquals(expectedPoint.getLat(), outputPoint.getLat(), .001);
    assertEquals(expectedPoint.getLng(), outputPoint.getLng(), .001);
    assertEquals(expectedPoint.getTime(), outputPoint.getTime());
  }

  @Test
  @DisplayName("Get Location 1 Across Multiple Objects is Consistent and in Sync") 
  void getLocationAcrossMultipleObjectsInSync() {
    LocationDataPoint initPoint = generateRandomLocationDataPoint();
    float x = generateRandomIncrements();
    float y = generateRandomIncrements();
    Satellite.satelliteInit(x, y, initPoint);
    int numberOfCalls = generateRandomStringLength();
    for (int index = 0; index < numberOfCalls; index++) {
      int strength = generateRandomStrength();
      int rndStrLength = generateRandomStringLength();
      String name = generateRandomString(rndStrLength);
      Satellite theSatellite = new Satellite(name, strength);
      theSatellite.getLocation();
    }
    int strength = generateRandomStrength();
    int rndStrLength = generateRandomStringLength();
    String name = generateRandomString(rndStrLength);
    Satellite theSatellite = new Satellite(name, strength);
    LocationDataPoint outputPoint = theSatellite.getLocation();
    LocationDataPoint expectedPoint = new LocationDataPoint(
        initPoint.getLat() + (x * numberOfCalls),
        initPoint.getLng() + (y * numberOfCalls),
        initPoint.getTime().plusHours(numberOfCalls)
    );
    assertEquals(expectedPoint.getLat(), outputPoint.getLat(), .001);
    assertEquals(expectedPoint.getLng(), outputPoint.getLng(), .001);
    assertEquals(expectedPoint.getTime(), outputPoint.getTime());
  }
  
  private int generateRandomStrength() {
    return (int) ((Math.random() * (10 - 1)) + 1); //Random int from 1 to 10
  }

  private float generateRandomIncrements() {
    return (float) ((Math.random() * (100 + 100)) - 100);
  }

  private int generateRandomStringLength() {
    return (int) ((Math.random() * (20 - 1)) + 1); //Random int from 1 to 20
  }

  private int generateLessThanOne() {
    return (int) (Math.random() * (0 - Integer.MIN_VALUE));
  }

  private int generateMoreThanTen() {
    return (int) (Math.random() * (Integer.MAX_VALUE - 11)) + 11;
  }

  private String generateRandomString(int length) { //Make a random string for Satellite Name
    Random random = new Random();
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    char [] rndString = new char[length];

    for (int i = 0; i < length; i++) { //Create array of characters for desired length
      rndString[i] = alphabet.charAt(random.nextInt(alphabet.length())); 
    }
    
    String createdString = new String(rndString);
    return createdString;
  }

  private LocationDataPoint generateRandomLocationDataPoint() {
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
 
}