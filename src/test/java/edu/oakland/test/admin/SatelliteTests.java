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
    String name = generateRandomString(rndStrLength); //For simplicity, string size in test will be from 1 to 20. chosen randomly
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
    int x = generateRandomXY();
    int y = generateRandomXY();
    Satellite.satelliteInit(x, y, thePoint);
    int strength = generateRandomStrength();
    int rndStrLength = generateRandomStringLength();
    String name = generateRandomString(rndStrLength);
    Satellite theSatellite = new Satellite(name, strength);//last test
    LocationDataPoint outputPoint = theSatellite.getLocation();//last test
    System.out.println(thePoint.getLat());
    System.out.println(outputPoint.getLat());
    assertEquals(thePoint.getLat(), outputPoint.getLat(), .001);
    //assertEquals(thePoint.getLng(),outputPoint.getLng(),.001);
    //assertEquals(thePoint.getTime(),outputPoint.getTime());
  }
  
  @Test
  @DisplayName("Get Location 1 is Correct") 
  void getLocation1IsCorrect() {
    LocationDataPoint thePoint = generateRandomLocationDataPoint();
    int x = generateRandomXY();
    int y = generateRandomXY();
    Satellite.satelliteInit(x, y, thePoint);
    int strength = generateRandomStrength();
    int rndStrLength = generateRandomStringLength();
    String name = generateRandomString(rndStrLength);
    Satellite theSatellite = new Satellite(name, strength);
    LocationDataPoint outputPointOne = theSatellite.getLocation();
    LocationDataPoint outputPointFinal = theSatellite.getLocation();
    assertEquals(thePoint.getLat(), outputPointFinal.getLat(),.001);
    assertEquals(thePoint.getLng(), outputPointFinal.getLng(),.001);
    assertEquals(thePoint.getTime(), outputPointFinal.getTime());
  }
  
  private int generateRandomStrength() {
    return (int) ((Math.random() * (10 - 1)) + 1); //Random int from 1 to 10
  }

  private int generateRandomXY() {
    return (int) ((Math.random() * (100 + 100)) - 100);
  }

  private int generateRandomStringLength() {
    return (int) ((Math.random() * (20 - 1)) + 1); //Random int from 1 to 20
  }

  private int generateLessThanOne() {
    return (int) (Math.random() * (0 - Integer.MIN_VALUE)) + Integer.MIN_VALUE; //Random int from 0 to biggest negative int
  }

  private int generateMoreThanTen() {
    return (int) (Math.random() * (Integer.MAX_VALUE - 11)) + 11; //Random int from 11 to biggest positive int
  }

  private String generateRandomString(int length) { //Make a random string for Satellite Name
    Random random = new Random();
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    char [] rndString = new char[length];

    for (int i = 0; i < length ; i++) { //Create array of characters for desired length
      rndString[i] = alphabet.charAt(random.nextInt(alphabet.length())); //Pick a random letter of my chosen alphabet and add it to the char array
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