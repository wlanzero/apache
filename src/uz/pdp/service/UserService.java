package uz.pdp.service;

import uz.pdp.entity.User;
import uz.pdp.enums.User_type;
import uz.pdp.payment.UserDTO;

import java.util.ArrayList;

public interface UserService {
    ArrayList<User> users = new ArrayList<>();
    User create(UserDTO userDTO);
    User getUser(String login, String password);
}
