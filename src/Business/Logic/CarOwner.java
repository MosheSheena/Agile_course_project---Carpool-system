package Business.Logic;

import java.util.Date;
import java.util.Objects;

public class CarOwner extends Person{

    private Car car;

    public CarOwner(String name, String birthDate, boolean hasDriverLicense, Car car) {
        super(name, birthDate, hasDriverLicense);
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Business.Logic.CarOwner{" +
                "car=" + car +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarOwner)) return false;
        if (!super.equals(o)) return false;
        CarOwner carOwner = (CarOwner) o;
        return Objects.equals(getCar(), carOwner.getCar());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getCar());
    }
}
