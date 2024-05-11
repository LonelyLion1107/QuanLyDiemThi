package oop.project.qldiemthi.function;

import oop.project.qldiemthi.entity.User;

public class UserFunction {
    public UserFunction() {
    }

    public boolean checkUser(User user) {
        if(user != null) {
            if("admin".equals(user.getUserName()) && "admin".equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
