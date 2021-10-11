package com.colby.services;

import com.colby.models.User;
import com.colby.repositories.JDBC.UserJDBC;
import com.colby.repositories.UserRepo;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class UserService {

    UserRepo userRepo = new UserJDBC();

    public boolean login(String username, String password) {

        // in order to log in a user, we will need username and password
        // that information is stored in our database
        // the repository layer needs to take care of this

        User u = userRepo.getByUsername(username); // more of the Sole Responsibility Principle at work
        System.out.println(u);
        // check to make sure User object is not null
        if (u != null) {
            // now check to make sure it matches
            if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                System.out.println("working ");
                return true;
            }
        }
        return false;
    }

    public String title( String username){
        User u = userRepo.getByUsername(username);
        return u.getTitle();
    }
    public Boolean admin( String username){
        User u = userRepo.getByUsername(username);
        return u.getIs_admin();
    }

    public List<User> getAllUsers() {

        return userRepo.getAll();
    }

    public User getByUsername(String username){
        return userRepo.getByUsername(username);
    }
}

