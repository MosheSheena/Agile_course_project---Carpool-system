package Business.Logic;

import java.util.Date;

public class Driver extends CarOwner{

    private Ride assignedRide;

    public Driver(String name, Date birthDate, boolean hasDriverLicense, Car car, Ride assignedRide) {
        super(name, birthDate, hasDriverLicense, car);
        this.assignedRide = assignedRide;
    }

    public Ride getAssignedRide() {
        return assignedRide;
    }

    public void setAssignedRide(Ride assignedRide) {
        this.assignedRide = assignedRide;
    }


}
