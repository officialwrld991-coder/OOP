package oopCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeoPoliticalZoneTest {

    @Test
    void testNorthWest() {
        GeoPoliticalZone zone = GeoPoliticalZone.NORTH_EAST;
        assertTrue(zone.presentState("TARABA"));
    }

    @Test
    void testSouthSouth() {
        GeoPoliticalZone zone = GeoPoliticalZone.SOUTH_SOUTH;
        assertTrue(zone.presentState("Bayelsa"));
    }



}
