package Core.Storage;

import Core.Logic.Person;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private static Long serialNum = 129348938L;

    private Long userIdentifier;
    private String userName;
    private String password;
    private Person person;

    public User(String userName, String password, Person person) {
        setSerialForUser();
        setUserName(userName);
        setPassword(password);
        this.person = person;
    }

    public Long getUserIdentifier() {
        return userIdentifier;
    }

    private void setSerialForUser() {
        userIdentifier =  serialNum++;
    }

    public String getUserName() {
        return userName;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return new Person(person);
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUserName(), user.getUserName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(person.getId());
    }
}
