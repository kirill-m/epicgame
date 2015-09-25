package main;


public class UserProfile {
    private String name;
    private String password;

    public UserProfile(String login, String password) {
        this.name = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
