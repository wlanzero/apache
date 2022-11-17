package uz.pdp.service;

import uz.pdp.entity.User;
import uz.pdp.enums.User_type;
import uz.pdp.payment.UserDTO;

public class UserServiceImpl implements UserService{
    @Override
    public User create(UserDTO userDTO) {
        User user = new User();
        if(!isHere(userDTO)){
            user.setFullname(userDTO.getFullname());
            user.setLogin(userDTO.getFullname());
            user.setPassword(userDTO.getPassword());
            user.setUser_type(User_type.USER);
            users.add(user);
        }
        return user;
    }

    @Override
    public User getUser(String login, String password) {
        for(User user:users){
            if(user.getLogin().equals(login)&&user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public static boolean isHere(UserDTO userDTO){
        for(User user:users){
            if(user.getLogin().equals(userDTO.getLogin())&&user.getPassword().equals(userDTO.getPassword())){
                return true;
            }
        }
        return false;
    }
}
