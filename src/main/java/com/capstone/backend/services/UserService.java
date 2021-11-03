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
                new User("david321", "password321", "user")
        ));
    }

    public String validateLoginCreds(String username, String password) {
        Optional<User> userQuery = userRepo.findById(username);
        Optional<User> passQuery= userRepo.findByPassword(password);

        String userQueryId = userQuery.isPresent() ? userQuery.get().getUsername() : null;
        String passQueryId = passQuery.isPresent() ? passQuery.get().getUsername() : null;

        if (userQuery.isPresent() && passQuery.isPresent() && userQueryId == passQueryId) {
            return userQuery.get().getRole();
        }
        else {
            return "notfound";
        }
    }
}
