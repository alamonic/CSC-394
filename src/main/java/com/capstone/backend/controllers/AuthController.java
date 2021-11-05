package com.capstone.backend.controllers;

import com.capstone.backend.data.models.User;
import com.capstone.backend.data.repos.ResponseRepository;
import com.capstone.backend.data.repos.UserRepository;
import com.capstone.backend.services.ResponseService;
import com.capstone.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@RestController // Indicates the class is a controller and its endpoints will return JSON
@RequestMapping("/api/auth") // Endpoints handle HTTP requests to www.example.com/api/auth/*
public class AuthController {
    private UserRepository userRepo;
    private UserService userService;

    private ResponseRepository responseRepo;
    private ResponseService responseService;

    @Autowired // Tells Spring to instantiate arguments and manage the instances ("Beans")
    public AuthController(UserRepository userRepo, UserService userService, ResponseRepository responseRepo, ResponseService responseService) {
        this.userRepo = userRepo;
        this.userService = userService;

        this.responseRepo = responseRepo;
        this.responseService = responseService;
    }

    @GetMapping // Indicates that this method handles GET requests to endpoint www.example.com/api/auth
    Map<String, String> authLogin(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        String userStatus = userService.validateLoginCreds(username, password);

        // If user found with provided credentials, then create session with cookie as key
        if (userStatus != "notfound") {
            HttpSession session = request.getSession(); // Retrieve existing session if one exists, or create one
            session.setAttribute("Username", username); // Add username to session data for later use
        }

        // Create HashMap so that Spring Boot can auto-serialize return value into JSON:
        HashMap<String, String> jsonResponse = new HashMap<>();
        jsonResponse.put("status", userStatus);
        return jsonResponse;
    }

}
