package com.capstone.backend.services;

import com.capstone.backend.data.models.Response;
import com.capstone.backend.data.models.User;
import com.capstone.backend.data.repos.ResponseRepository;
import com.capstone.backend.data.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ResponseService {
    private ResponseRepository responseRepo;
    private UserRepository userRepo;

    @Autowired
    public ResponseService(ResponseRepository responseRepo, UserRepository userRepo) {
        this.userRepo = userRepo;
        this.responseRepo = responseRepo;
        if ((userRepo.existsById("willis123"))) {
            loadSeedData();
        }
    }

    @PostConstruct
        // Seeds default user accounts into DB
    void loadSeedData() {
        responseRepo.saveAll(List.of(
                new Response(1125, "one comment", 1, 2, 3, 4, 5, userRepo.findById("willis123").get()),
                new Response(1125, "oen comment", 3, 3, 3, 3, 3, userRepo.findById("willis123").get()),
                new Response(1125, "eno comment", 3, 3, 1, 5, 2, userRepo.findById("willis123").get())
        ));
    }
}
