package edu.oakland.production.display02;


import edu.oakland.helper.admin.TrackData;


public class DisplayCommInterfaceImplementation implements DisplayCommInterface {
  public int rfid;
  DisplayComm2WayInterfaceImplementation instance = new DisplayComm2WayInterfaceImplementation();

  /* This recieves the rfid number from the user then passes it off to comm 2 way */
  public TrackData receiveRfidRequest(int rfidNum) {
    rfid = rfidNum;
    TrackData trackData = instance.passRfidRequest(rfidNum);
    return trackData;
  }
}
