import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Pool {

    private int maxNumRides;
    private int numRides;
    private Set<Ride> rides;

    public Pool(int maxNumRides, int numRides, Set<Ride> rides) {
        this.maxNumRides = maxNumRides;
        this.numRides = numRides;
        this.rides = new HashSet<>(this.maxNumRides);
    }

    public int getMaxNumRides() {
        return maxNumRides;
    }

    public void setMaxNumRides(int maxNumRides) {
        this.maxNumRides = maxNumRides;
    }

    public int getNumRides() {
        return numRides;
    }

    public void setNumRides(int numRides) {
        this.numRides = numRides;
    }

    public Set<Ride> getRides() {
        return rides;
    }

    @Override
    public String toString() {
        return "Pool{" +
                "maxNumRides=" + maxNumRides +
                ", numRides=" + numRides +
                ", rides=" + rides +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pool)) return false;
        Pool pool = (Pool) o;
        return getMaxNumRides() == pool.getMaxNumRides() &&
                getNumRides() == pool.getNumRides() &&
                Objects.equals(getRides(), pool.getRides());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getMaxNumRides(), getNumRides(), getRides());
    }

    public boolean addRide(Ride newRide) {
        if(this.numRides < this.maxNumRides && !this.rides.contains(newRide)) {
            this.rides.add(newRide);
            this.numRides++;

            return true;
        }

        return false;
    }

    public boolean deleteRide(Ride cancelledRide) {
        if(this.rides.contains(cancelledRide)) {
            this.rides.remove(cancelledRide);
            this.numRides--;

            return true;
        }

        return false;
    }
}