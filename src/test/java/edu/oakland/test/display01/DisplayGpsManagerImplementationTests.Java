package edu.oakland.test.display01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import edu.oakland.helper.admin.Satellite;
import edu.oakland.production.display01.DisplayGpsManagerImplementation;
import edu.oakland.production.middleware01.MiddlewareGisInterface;

  @DisplayName("Display GPS Manager Unit Tests")
    public class DisplayGpsManagerImplementationTests {
        @Test
        @DisplayName("Indication that GPS signal strengths are received.")
        void receivedGpsSignalStrengths() {
            Satellite sat = new Satellite();
            DisplayGpsManagerImplementation man = new DisplayGpsInterfaceImplementation();
            AssertEquals(satelliteSignal.receivedGpsSignalStrengths(sat));

        } 

        @Test
        @DisplayName("Check if middleware GIS is not null")
        void middlewareGisIsNotNull() {
            if (MiddlewareGisInterface == null) {
                throw new IllegalArgumentException("MiddlewareGisInterface cannot be null");
        }
    }