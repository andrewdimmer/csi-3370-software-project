package edu.oakland.test.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.oakland.production.admin.GpsSystem;
import edu.oakland.test.admin.DisplayGpsInterfaceStub;

@DisplayName("GpsSystem Unit Tests")
public class GpsSystemTests {

	@Test
	@DisplayName("Init DisplayGpsInterfaceNotNull")
	void initDisplayGpsInterfaceNotNull(){
	String[] str =  new String[]{"1","2","3"};
	DisplayGpsInterfaceStub stub = new DisplayGpsInterfaceStub();
	assertThrows(IllegalArgumentException.class, () -> {
      new GpsSystem(null, str);
    });
	}
}
