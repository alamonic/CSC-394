package com.capstone.backend.controllers;

import com.capstone.backend.data.models.Response;
import com.capstone.backend.data.models.User;
import com.capstone.backend.data.repos.ResponseRepository;
import com.capstone.backend.data.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/responses")
public class ResponseController {
    private ResponseRepository responseRepo;
    private UserRepository userRepo;
    @Autowired
    public ResponseController(ResponseRepository responseRepo, UserRepository userRepo) {
        this.responseRepo = responseRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/starttimer")
    Map<String, String> startTimer(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("Initial Time") == null) {
            session.setAttribute("Initial Time", System.currentTimeMillis());
        }
        HashMap<String, String> response = new HashMap<>();
        response.put("status", "yes :D");
        return response;
        }

    @GetMapping("/stopttimer")
    Map<String, String> getFinalTime(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("Initial Time") != null) {
            Long delta = System.currentTimeMillis() - (long) session.getAttribute("Initial Time");
            session.setAttribute("Initial Time", null);
            session.setAttribute("Final Time", delta);
        }
            HashMap<String, String> response = new HashMap<>();
            response.put("status", "yes :D");
            return response;
    }

    @GetMapping
    Iterable<Response> getAllResponses() {
        return responseRepo.findAll();
    }

    @PostMapping
    Map<String, String> createResponse(@RequestBody String level, HttpServletRequest request) {
        getFinalTime(request); // Stop the timer
        HttpSession session = request.getSession();

        Long delta = (long) session.getAttribute("Final Time");
        String username = (String) session.getAttribute("Username");

        int hardness = 1;
        switch (level) {
            case "very":
                hardness = 5;
                break;
            case "moderate":
                hardness = 3;
                break;
            case "easy":
                hardness = 1;
                break;
        }

        responseRepo.save(
                new Response(
                null, hardness, 0,
                0, 0, 0,
                userRepo.findById(username).get()
                ));

        HashMap<String, String> response = new HashMap<>();
        response.put("status", "yes :D");
        return response;
    }
}
