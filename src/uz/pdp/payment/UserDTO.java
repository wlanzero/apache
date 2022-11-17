package uz.pdp.payment;

import uz.pdp.enums.User_type;

public class UserDTO {
    private String fullname;
    private String login;
    private String password;
    private User_type user_type;

    public UserDTO() {
    }

    public UserDTO(String fullname, String login, String password, User_type user_type) {
        this.fullname = fullname;
        this.login = login;
        this.password = password;
        this.user_type = user_type;
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
}
