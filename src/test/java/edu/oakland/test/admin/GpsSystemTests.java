package edu.oakland.test.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Random;
import java.util.Scanner;

import edu.oakland.production.admin.GpsSystem;
import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.test.admin.DisplayGpsInterfaceStub;

@DisplayName("GpsSystem Unit Tests")
public class GpsSystemTests {

	@Test
	@DisplayName("Init Display GpsInterface Not Null")
	void initDisplayGpsInterfaceNotNull(){
    Random rnd = new Random();                          //make a moderately long array of random strings
    int rndLength = rnd.nextInt(100);
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
	void initSatelliteNamesNotNull(){
		DisplayGpsInterfaceStub stub = new DisplayGpsInterfaceStub();
		assertThrows(IllegalArgumentException.class, () -> {
			new GpsSystem(stub, null);
		});
	}
	
	@Test
	@DisplayName("Init Satelllite Names Not Empty")
	void initSatelliteNamesNotEmpty(){
		DisplayGpsInterfaceStub stub = new DisplayGpsInterfaceStub();
    Random rnd = new Random();                                    //make a moderately long array of random strings
    int rndLength = rnd.nextInt(100);
    String[] str = new String[rndLength];
    for (int i = 0; i < rndLength; i++) {
      str[i] = generateRandomNames();
    }
    str[rnd.nextInt(rndLength)] = "";                              //set random item in array to be empty
		assertThrows(IllegalArgumentException.class, () -> {
			new GpsSystem(stub, str);
		});
	}
  
	@Test
	@DisplayName("GPS Systems Constructed Successfully")
  void gpsSystemsConstructedSuccessfully(){
    try {
      DisplayGpsInterfaceStub stub = new DisplayGpsInterfaceStub();
      Random rnd = new Random();                          //make a moderately long array of random strings
      int rndLength = rnd.nextInt(100);
      String[] str = new String[rndLength];
      for (int i = 0; i < rndLength; i++) {
        str[i] = generateRandomNames();
      }
      GpsSystem gpsSystem = new GpsSystem(stub, str);
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }
  
  
  private String generateRandomNames() { //Make a random string for Satellite Name, borrowed from Tessa, thanks!
    int length = 10;
    Random random = new Random();
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    char [] rndString = new char[length];

    for (int i = 0; i < length; i++) { //Create array of characters for desired length
      rndString[i] = alphabet.charAt(random.nextInt(alphabet.length())); 
    }
    
    String createdString = new String(rndString);
    return createdString;
  }
  
  private LocationDataPoint generateRandomLocationDataPoint() {  //borrowed from Tessa again, thanks!
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
  
  private float makeRandomPos() {   //will return a float value between -90.0 and 90.0
    Random rnd = new Random();
    return rnd.nextFloat()*180-90;
  }
}
