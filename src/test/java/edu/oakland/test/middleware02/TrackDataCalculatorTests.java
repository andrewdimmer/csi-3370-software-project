package edu.oakland.test.middleware02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



@DisplayName("TrackDataCalculator Unit Tests")
public class TrackDataCalculatorTests {

  @Test
  @DisplayName("Calculate Speed")
    void calculateSpeedTest(){
      double trackLength;
      int deltaX = 2;
      int deltaY = 2;
      double speed;
      double expectedSpeed = 14.14;
      trackLength = Math.sqrt((deltaX*deltaX) + (deltaY*deltaY));

      speed = (trackLength / 4) * 20;
      //System.out.println(speed);
      //System.out.println(trackLength);
    
      assertEquals(expectedSpeed, speed, 0.01);
    }
  @Test
  @DisplayName("Calculate Direction")
    void calculateDirectionTest(){
        double alpha;
        int expectedDirection = 45;
        int deltaY = 2;
        double trackLength = 2.828;
        alpha = (deltaY/trackLength);
        alpha = (Math.asin(alpha));
        double alpha2 = Math.toDegrees(alpha);
        alpha2 = Math.floor(alpha2);

        //System.out.println(alpha);
        //System.out.println(alpha2);

        assertEquals(expectedDirection, alpha2);
    }

  }