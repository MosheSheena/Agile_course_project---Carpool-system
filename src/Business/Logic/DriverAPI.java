package Business.Logic;

import java.time.LocalDateTime;

public class DriverAPI {
    private static DriverAPI ourInstance = new DriverAPI();

    public static DriverAPI getInstance() {
        return ourInstance;
    }

    private DriverAPI() {}

    public static boolean offerNewRide(Driver driver, Location from, Location to, LocalDateTime timeDepart) {
        Ride newRide = new Ride(driver, from, to);
        return false;
    }



}
