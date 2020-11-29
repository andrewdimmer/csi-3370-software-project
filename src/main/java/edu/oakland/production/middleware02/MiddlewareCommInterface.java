package edu.oakland.production.middleware02;

import edu.oakland.helper.admin.TrackData;

public interface MiddlewareCommInterface {

  public TrackData requestRfid(int rfid);
} 
