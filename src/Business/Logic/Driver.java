package Business.Logic;

import java.util.Date;

public class Driver extends CarOwner{

    private Ride assignedRide = null;


    public Driver(String name, String birthDate, boolean hasDriverLicense, Car car) {
        super(name, birthDate, hasDriverLicense, car);
    }

    public Ride getAssignedRide() {
        return assignedRide;
    }

    public boolean assignRide(Ride ride) {

        if(!(this.assignedRide == ride)) {
            this.assignedRide = ride;
            this.assignedRide.assignDriver(this);
            return true;
        }
        return false;
    }
}
