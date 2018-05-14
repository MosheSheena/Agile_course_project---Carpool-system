package Business.Logic;

import java.time.LocalDateTime;

public class DriverAPI {

    private static DriverAPI ourInstance = new DriverAPI();

    public static DriverAPI getInstance() {
        return ourInstance;
    }

    private DriverAPI() {}

    public static boolean offerNewRide(Driver driver, Location from, Location to, String timeDepart) {
        Ride newRide = new Ride(from, to);
        newRide.assignDriver(driver);
        return Pool.addRide(newRide);
    }

    public static boolean cancelRide(Ride r, String reason) {
        if(Pool.isRideExist(r)) {
            Pool.deleteRide(r);
            return true;
        }
        return false;
    }
}
