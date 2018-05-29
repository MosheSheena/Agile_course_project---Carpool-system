package Core.Logic;

/**
 * a class used to manage current user data
 */

public class CurrentUserDetail {

    private String username;
    private String password;
    private Person person;
    private Commuter userRole;

    private static CurrentUserDetail ourInstance = new CurrentUserDetail();

    public static CurrentUserDetail getInstance() {
        return ourInstance;
    }

    private CurrentUserDetail() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Commuter getUserRole() {
        return userRole;
    }

    public void setUserRole(Commuter userRole) {
        this.userRole = userRole;
    }

}
