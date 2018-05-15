package Business.Logic;

import java.util.Objects;

public class Location {

    private String address;
    private boolean isBusiness;

    public Location(String address, boolean isBusiness) {
        this.address = address;
        this.isBusiness = isBusiness;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isBusiness() {
        return isBusiness;
    }

    public void setBusiness(boolean business) {
        isBusiness = business;
    }

    @Override
    public String toString() {
        return "Business.Logic.Location{" +
                "address='" + address + '\'' +
                ", isBusiness=" + isBusiness +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return isBusiness() == location.isBusiness() &&
                Objects.equals(getAddress(), location.getAddress());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getAddress(), isBusiness());
    }
}
