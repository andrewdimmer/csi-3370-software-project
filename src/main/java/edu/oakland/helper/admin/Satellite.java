package edu.oakland.helper.admin;

import edu.oakland.helper.admin.LocationDataPoint;
import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;

public class Satellite {
private String satelliteName;
private int strength;
private static float incrementLatAmount;
private static float incrementLngAmount;
private static LocationDataPoint initLocationDataPoint;
private static int countGetLocationCalls=-1;

  public Satellite(String satName, int str){
    if (!strengthIsValid(str)) {
      throw new IllegalArgumentException("Strength must be between one and ten");
    }
    satelliteName=satName;
    strength=str;
  }

  public String getSatelliteName() {
    return satelliteName;
  }

  public int getStrength() {
    return strength;
  }

  public void setStrength(int str) {
    if (!strengthIsValid(str)) {
      throw new IllegalArgumentException("Strength must be between one and ten");
    }
    strength=str;
  }

  public LocationDataPoint getLocation() {
    countGetLocationCalls++;
    float lat=generateNewLocationDataPointLat();
    float lng=generateNewLocationDataPointLng();
    LocalDateTime time=generateNewLocationDataPointTime();
    LocationDataPoint thePoint=new LocationDataPoint(lat,lng,time);
    return thePoint;
  }

  private boolean strengthIsValid(int str) {
    if (str < 1 || str > 10) {
      return false;
    } else {
      return true;
    }
  }

  public static void satelliteInit(float incLatA, float incLngA, LocationDataPoint initPoint) {
    System.out.println(initPoint.getLat());
    incrementLatAmount=incLatA;
    incrementLngAmount=incLngA;
    initLocationDataPoint=initPoint;
  }

  private static float generateNewLocationDataPointLat() {
   float lat=initLocationDataPoint.getLat()+(incrementLatAmount*countGetLocationCalls);
   System.out.println(lat);
   return lat;
  }

  private static float generateNewLocationDataPointLng() {
   float lng=initLocationDataPoint.getLng()+(incrementLngAmount*countGetLocationCalls);
   return lng;
  }

  private static LocalDateTime generateNewLocationDataPointTime() {
   LocalDateTime theNewTime=initLocationDataPoint.getTime();
   theNewTime.plusHours(countGetLocationCalls);
   return theNewTime;
  }



}