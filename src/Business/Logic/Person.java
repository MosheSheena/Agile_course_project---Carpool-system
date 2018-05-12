package Business.Logic;

import java.util.Date;
import java.util.Objects;

public class Person {

    private String name;
    private Date birthDate;
    private Integer ID;
    private boolean hasDriverLicense;

    public Person(String name, Date birthDate, boolean hasDriverLicense) {
        this.name = name;
        this.birthDate = birthDate;
        this.hasDriverLicense = hasDriverLicense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthDate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthDate = birthdate;
    }

    public boolean isHasDriverLicense() {
        return hasDriverLicense;
    }

    public void setHasDriverLicense(boolean hasDriverLicense) {
        this.hasDriverLicense = hasDriverLicense;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Business.Logic.Person{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthDate +
                ", ID=" + ID +
                ", hasDriverLicense=" + hasDriverLicense +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getID(), person.getID());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getID());
    }
}
