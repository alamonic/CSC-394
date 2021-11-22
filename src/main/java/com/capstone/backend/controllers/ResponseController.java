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

    void getFinalTime(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("Initial Time") != null) {
            Long delta = System.currentTimeMillis() - (long) session.getAttribute("Initial Time");
            session.setAttribute("Initial Time", null);
            session.setAttribute("Final Time", delta);
        }
    }

    @GetMapping
    Iterable<Response> getAllResponses() {
        return responseRepo.findAll();
    }

    /*@GetMapping("/getallresponses")
    Map<String, String> getResponseOutput(HttpServletRequest request) {
        HttpSession session = request.getSession();
    }*/

    @PostMapping
    Map<String, String> createResponse(@RequestBody String level, HttpServletRequest request) {
        getFinalTime(request); // Stop the timer
        HttpSession session = request.getSession();

        Long delta = -1L;
        if (session.getAttribute("Final Time") != null)
        {
            delta = (long) session.getAttribute("Final Time");
        }
        String username = (String) session.getAttribute("Username");

        int hardness = 1;
        switch (level) {
            case "level=very":
                hardness = 5;
                break;
            case "level=moderate":
                hardness = 3;
                break;
            case "level=easy":
                hardness = 1;
                break;
        }

        Response R = new Response(
            null, hardness, 0,
            0, 0, 0,
            userRepo.findById(username).get()
        );

        R.SetCurrentDuration(delta);

        responseRepo.save(R);

        HashMap<String, String> response = new HashMap<>();
        response.put("status", R.toString());
        return response;
    }
}
