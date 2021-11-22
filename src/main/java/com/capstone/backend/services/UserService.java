package com.capstone.backend.services;

import com.capstone.backend.data.models.User;
import com.capstone.backend.data.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
        if (!(userRepo.existsById("willis123")) && !(userRepo.existsById("david321"))) {
            loadSeedData();
        }
    }

    @PostConstruct // Seeds default user accounts into DB
    void loadSeedData() {
        userRepo.saveAll(List.of(
                new User("willis123", "password123", "user"),
                new User("david321", "password321", "admin")
        ));
    }

    /*public String createAccount(String username, String password)
    {
        Optional<User> userQuery = userRepo.findById(username);
        if (userQuery.isPresent())
        {
            // Error
            return "userExists";
        }

        User newUser = new User(username, password, "user");
    }*/

    public String validateLoginCreds(String username, String password) {
        // Query DB to find user rows that contain the supplied name and password
        Optional<User> userQuery = userRepo.findById(username);
        //Optional<User> passQuery= userRepo.findByPassword(password);
        Iterable<User> passQuery = userRepo.findAllByPassword(password);

        boolean foundUser = false;
        String passQueryId = null;
        String userQueryId = userQuery.isPresent() ? userQuery.get().getUsername() : null;

        if (userQueryId != null)
        {
            for (User u : passQuery)
            {
                if (u.getUsername().equals(userQueryId))
                {
                    passQueryId = u.getUsername();
                    foundUser = true;
                    break;
                }
            }
        }
        //String passQueryId = passQuery.isPresent() ? passQuery.get().getUsername() : null;

        if (userQuery.isPresent() && foundUser && userQueryId == passQueryId) {
            return userQuery.get().getRole();
        }
        else {
            return "notfound"; // User/pass combo is invalid
        }
    }
}
