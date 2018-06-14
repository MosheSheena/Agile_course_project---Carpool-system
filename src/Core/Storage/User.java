package Core.Storage;

import Core.Logic.Commuter;
import Core.Logic.Person;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private static Long serialNum = 129348938L;

    private Long userIdentifier;
    private String userName;
    private String password;
    private Commuter commuter;

    public User(String userName, String password, Commuter commuter) {
        setSerialForUser();
        setUserName(userName);
        setPassword(password);
        this.commuter = commuter;
    }

    public Long getUserIdentifier() {
        return userIdentifier;
    }

    private void setSerialForUser() {
        userIdentifier = serialNum++;
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

    public Commuter getCommuter() {
        return commuter;
    }

    public void setCommuter(Commuter commuter) {
        this.commuter = commuter;
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
        return Objects.equals(getUserIdentifier(), user.getUserIdentifier()) &&
                Objects.equals(getUserName(), user.getUserName()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getCommuter(), user.getCommuter());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUserIdentifier(), getUserName(), getPassword());
    }
}


