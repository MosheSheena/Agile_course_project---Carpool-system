package Business.Logic;

import java.util.Objects;

public class Car {

    private Integer licenseNumber;
    private String manufacturer;
    private String color;
    private Integer numOfSeats;
    private Float mileage;

    public Car(Integer licenseNumber, String manufacturer, String color, Integer numOfSeats, Float mileage) {
        this.licenseNumber = licenseNumber;
        this.manufacturer = manufacturer;
        this.color = color;
        this.numOfSeats = numOfSeats;
        this.mileage = mileage;
    }

    public Integer getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(Integer licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(Integer numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public Float getMileage() {
        return mileage;
    }

    public void setMileage(Float mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Business.Logic.Car{" +
                "licenseNumber=" + licenseNumber +
                ", manufacturer='" + manufacturer + '\'' +
                ", color='" + color + '\'' +
                ", numOfSeats=" + numOfSeats +
                ", mileage=" + mileage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getLicenseNumber(), car.getLicenseNumber());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getLicenseNumber());
    }
}
