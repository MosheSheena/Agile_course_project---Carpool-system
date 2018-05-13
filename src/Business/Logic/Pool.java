package Business.Logic;

import java.util.HashSet;
import java.util.Set;

public class Pool {

    private static Set<Ride> rides;
    private static Integer numRides;

    private static Pool ourInstance = new Pool();

    public static Pool getInstance() {
        return ourInstance;
    }

    private Pool() {
        this.rides = new HashSet<>();
        this.numRides = 0;
    }

    public static Integer getNumRides() {
        return numRides;
    }

    public static boolean addRide(Ride r) {
        if(!rides.contains(r)) {
            rides.add(r);
            numRides++;
            return true;
        }
        return false;
    }

    public static boolean deleteRide(Ride r) {
        if(rides.contains(r)) {
            rides.remove(r);
            numRides--;
            return true;
        }
        return false;
    }

    public static boolean isRideExist(Ride r) {
        return rides.contains(r);
    }

    public static String prettyPrint() {
        StringBuilder s = new StringBuilder();
        s.append("\nNumber of rides: " + numRides.toString());
        s.append("\nRides:\n");
        for (Ride r: rides) {
            s.append(r.toString() + "\n");
        }
        return s.toString();
    }
}
