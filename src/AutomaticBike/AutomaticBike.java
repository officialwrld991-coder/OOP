package AutomaticBike;

public class AutomaticBike {

    private boolean powerState;
    private int acceleration;
    private int gear;

    public void turnOn() {
        powerState = true;
    }

    public boolean checkPowerState() {
        return powerState;
    }

    public void turnOff() {
        powerState = false;
    }

    public void increaseAcceleration() {
        if (acceleration >= 0 && acceleration <= 20) {
            acceleration = acceleration + 1;
            gear = 1;
        }

        else if (acceleration >= 21 &&  acceleration <= 30) {
            acceleration = acceleration + 2;
            gear = 2;

        }

        else if (acceleration >= 31 &&  acceleration <= 40) {
            acceleration = acceleration + 3;
            gear = 3;
        }

        else if (acceleration >= 41 ) {
            acceleration = acceleration + 4;
            gear = 4;
        }
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getGear() {
        return gear;
    }

    public void decreaseAcceleration() {
        if (acceleration >= 0 && acceleration <= 20) {
            acceleration = acceleration - 1;
            gear = 1;
        }
        else if (acceleration >= 21 &&  acceleration <= 30) {
            acceleration = acceleration - 2;
            gear = 2;
        }
        else if (acceleration >= 31 &&  acceleration <= 40) {
            acceleration = acceleration - 3;
            gear = 3;
        }

        else if (acceleration >= 41 ) {
            acceleration = acceleration - 4;
            gear = 4;
        }
    }
}
