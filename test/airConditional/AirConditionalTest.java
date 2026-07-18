package airConditional;

import bankApp.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AirConditionalTest {

    AirConditional newAc;

    @BeforeEach
    public void setUp(){
        newAc = new AirConditional();
    }

    @Test
    public void newAcIsTurnedOnPowerStateIsTrue() {

        newAc.turnOn();
        assertTrue(newAc.checkPowerState());

    }

    @Test
    public void newAcIsTurnedOffPowerStateIsFalse() {
        newAc.turnOn();
        assertTrue(newAc.checkPowerState());
        newAc.turnOff();
        assertFalse(newAc.checkPowerState());
    }

    @Test
    public void iIncreaseTheTemperatureOfNewAcAndItIncreases ()  {
        newAc.turnOn();
        newAc.increaseTemperature();
        assertEquals(17, newAc.getTemperature());
    }

    @Test
    public void iDecreaseTheTemperatureOfNewAcAndItDecreases ()  {
        newAc.turnOn();
        newAc.increaseTemperature();
        newAc.decreaseTemperature();
        assertEquals(16, newAc.getTemperature());
    }

    @Test
    public void iIncreaseTemperatureAbove30_ItStillRemains30 ()  {
        int temperature = 16;
        newAc.turnOn();
        do {
            newAc.increaseTemperature();
        } while(newAc.getTemperature() < 30);

        assertEquals(30, newAc.getTemperature());

        newAc.increaseTemperature();

        assertEquals(30, newAc.getTemperature());
    }

    @Test
    public void iDecreaseTemperatureBelow16_ItStillRemains16  ()  {
        int temperature = 16;
        newAc.turnOn();
        do {
            newAc.decreaseTemperature();
        } while(newAc.getTemperature() > 16);

        assertEquals(16, newAc.getTemperature());

        newAc.decreaseTemperature();

        assertEquals(16, newAc.getTemperature());

    }
}
