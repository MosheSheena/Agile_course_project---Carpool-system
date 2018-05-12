package Business.Logic;

import java.util.Date;
import java.util.Objects;

public class Passenger extends Person{

    private Location source;
    private Location destination;

    public Passenger(String name, Date birthDate, boolean hasDriverLicense, Location source, Location destination) {
        super(name, birthDate, hasDriverLicense);
        this.source = source;
        this.destination = destination;
    }

    public Location getSource() {
        return source;
    }

    public void setSource(Location source) {
        this.source = source;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Business.Logic.Passenger{" +
                "source=" + source +
                ", destination=" + destination +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        if (!super.equals(o)) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(getSource(), passenger.getSource()) &&
                Objects.equals(getDestination(), passenger.getDestination());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getSource(), getDestination());
    }
}
