package AutomaticBike;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AutomaticBikeTest {

    AutomaticBike newBike;

    @BeforeEach
    public void setUp() {newBike = new AutomaticBike();}

    @Test
    public void automaticBikeIsOff_AndITurnItOn () {
       newBike.turnOn();

        assertTrue(newBike.checkPowerState());
    }

    @Test
    public void automaticBikeIsOn_AndITurnItOff () {
        newBike.turnOn();
        newBike.turnOff();

        assertFalse(newBike.checkPowerState());
    }

    @Test
    public void iAccelerateNewBike_AccelerationIncreases () {
        newBike.turnOn();
        newBike.increaseAcceleration();

        assertEquals(1, newBike.getAcceleration());
//        assertEquals(1, newBike.getGear());

    }

    @Test
    public void iAccelerateNewBikeOnGear1_AccelerationIncreasesBy1 () {
        newBike.turnOn();
        for(int count = 0; count < 20; count++){
            newBike.increaseAcceleration();
        }

        assertEquals(20, newBike.getAcceleration());
        assertEquals(1, newBike.getGear());


    }

    @Test
    public void iAccelerateNewBikeOnGear2_AccelerationIncreasesBy2 () {
        newBike.turnOn();
        for(int count = 0; count < 21; count++){
            newBike.increaseAcceleration();
        }
        assertEquals(1, newBike.getGear());

       int speed = newBike.getAcceleration();
        newBike.increaseAcceleration();

        assertEquals(speed + 2, newBike.getAcceleration());
        assertEquals(2, newBike.getGear());
    }

    @Test
    public void iAccelerateNewBikeOnGear3_AccelerationIncreasesBy3 () {
        newBike.turnOn();
        for(int count = 0; count < 29; count++) {
            newBike.increaseAcceleration();
        }

        int speed = newBike.getAcceleration();
        newBike.increaseAcceleration();

        assertEquals(speed + 3, newBike.getAcceleration());
        assertEquals(3, newBike.getGear());
    }

    @Test
    public void iAccelerateNewBikeOnGear4_AccelerationIncreasesBy4 () {
        newBike.turnOn();
        for(int count = 0; count < 31; count++) {
            newBike.increaseAcceleration();
        }

        int speed = newBike.getAcceleration();
        newBike.increaseAcceleration();

        assertEquals(speed + 4, newBike.getAcceleration());
        assertEquals(4, newBike.getGear());
    }

    @Test
    public void iDecelerateNewBike_AccelerationDecreasesBy1 () {
        newBike.turnOn();
        newBike.increaseAcceleration();
        newBike.increaseAcceleration();
        newBike.decreaseAcceleration();

        assertEquals(1, newBike.getAcceleration());
    }

    @Test
    public void iDecelerateNewBikeInGear1_accelerationDecreasesBy1 () {
        newBike.turnOn();
        for (int count = 0; count < 20; count++) {
            newBike.increaseAcceleration();
        }
        newBike.decreaseAcceleration();

        assertEquals(19, newBike.getAcceleration());
        assertEquals(1, newBike.getGear());
    }

    @Test
    public void iDecelerateNewBikeInGear2_accelerationDecreasesBy2 () {
        newBike.turnOn();
        for(int count = 0; count < 20; count++) {
            newBike.increaseAcceleration();
        }
        assertEquals(20, newBike.getAcceleration());
        assertEquals(1, newBike.getGear());

        newBike.increaseAcceleration();
        newBike.increaseAcceleration();
        newBike.decreaseAcceleration();

        assertEquals(21, newBike.getAcceleration());
        assertEquals(2, newBike.getGear());

        newBike.decreaseAcceleration();
        newBike.decreaseAcceleration();

        assertEquals(18, newBike.getAcceleration());
        assertEquals(1, newBike.getGear());
    }

    @Test
    public void iDecelerateNewBikeInGear3_accelerationDecreasesBy3 () {
        newBike.turnOn();
        for(int count = 0; count < 25; count++) {
            newBike.increaseAcceleration();
        }
        assertEquals(29, newBike.getAcceleration());
        assertEquals(2, newBike.getGear());

        newBike.increaseAcceleration();
        newBike.increaseAcceleration();
        newBike.decreaseAcceleration();

        assertEquals(31, newBike.getAcceleration());
        assertEquals(3, newBike.getGear());

        newBike.decreaseAcceleration();
        newBike.decreaseAcceleration();

        assertEquals(26, newBike.getAcceleration());
        assertEquals(2, newBike.getGear());

    }
    @Test
    public void iDecelerateNewBikeInGear4_accelerationDecreasesBy4 () {
        for (int count = 0; count < 29; count++) {
            newBike.increaseAcceleration();
        }
        assertEquals(40, newBike.getAcceleration());
        assertEquals(3, newBike.getGear());

        newBike.increaseAcceleration();
        newBike.increaseAcceleration();

        assertEquals(47, newBike.getAcceleration());
        assertEquals(4, newBike.getGear());

        newBike.decreaseAcceleration();
        newBike.decreaseAcceleration();
        newBike.decreaseAcceleration();

        assertEquals(36, newBike.getAcceleration());
        assertEquals(3, newBike.getGear());
    }

}
