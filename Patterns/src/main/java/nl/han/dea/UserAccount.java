package nl.han.dea;

/**
 * Created by uwe on 07/03/17.
 */
public class UserAccount {

    private String name;
    private String password;

    public UserAccount(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
