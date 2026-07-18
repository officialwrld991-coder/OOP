package airConditional;

public class AirConditional {

    private boolean powerState;

    private int temperature = 16;

    public void turnOn() {

        powerState = true;
    }

    public boolean checkPowerState() {

        return powerState;
    }

    public void turnOff() {

        powerState = false;
    }

    public void increaseTemperature() {
        if (powerState == true && temperature < 30) temperature++;
        }

    public int getTemperature() {
        return temperature;
    }

    public void decreaseTemperature() {
        if (powerState == true && temperature > 16) temperature--;
        }
    }

