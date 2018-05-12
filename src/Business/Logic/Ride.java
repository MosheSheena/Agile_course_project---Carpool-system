package Business.Logic;

import java.util.*;

public class Ride {

    private static Integer idCounter = 1;
    private Integer identifier;
    private Driver assignedDriver;
    private Integer numAvailableSeats;
    private Set<Passenger> passengers;
    private Location driverSrc;
    private Location driverDst;

    public Ride(Driver assignedDriver, Location driverSrc, Location driverDst) {
        this.identifier = generateRideIdentifier();
        this.passengers = new HashSet<>();
        this.assignedDriver = assignedDriver;
        this.numAvailableSeats = this.assignedDriver.getCar().getNumOfSeats(); //TODO: -1 or not?
        this.driverSrc = driverSrc;
        this.driverDst = driverDst;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public Driver getAssignedDriver() {
        return assignedDriver;
    }

    public void setAssignedDriver(Driver assignedDriver) {
        this.assignedDriver = assignedDriver;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    @Override
    public String toString() {
        return "Business.Logic.Ride{" +
                "identifier=" + identifier +
                ", assignedDriver=" + assignedDriver +
                ", passengers=" + passengers +
                ", routes="  +
                '}';
    }


    private int generateRideIdentifier() {
        return this.idCounter++;
    }

    public boolean addPassenger(Passenger newPassenger) {

        if(this.numAvailableSeats > 0 &&
                !this.passengers.contains(newPassenger)) {
            this.numAvailableSeats--;
            this.passengers.add(newPassenger);

            return true;
        }

        return false;
    }

    public boolean removePassenger(Passenger passenger) {
        if(this.passengers.contains(passenger)) {
            this.numAvailableSeats++;
            this.passengers.remove(passenger);

            return true;
        }

        return false;
    }
}
