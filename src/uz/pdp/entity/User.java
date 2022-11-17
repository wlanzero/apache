package uz.pdp.entity;

import uz.pdp.enums.User_type;

public class User {
    private static long counter = 0;

    {
        counter++;
        id = counter;
    }

    private long id;
    private String fullname;
    private String login;
    private String password;
    private User_type user_type;

    public User() {
    }

    public User(String fullname, String login, String password, User_type user_type) {
        this.fullname = fullname;
        this.login = login;
        this.password = password;
        this.user_type = user_type;
    }

    public User(long id, String fullname, String login, String password, User_type user_type) {
        this.id = id;
        this.fullname = fullname;
        this.login = login;
        this.password = password;
        this.user_type = user_type;
    }

    public long getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User_type getUser_type() {
        return user_type;
    }

    public void setUser_type(User_type user_type) {
        this.user_type = user_type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", user_type=" + user_type +
                '}';
    }
}
