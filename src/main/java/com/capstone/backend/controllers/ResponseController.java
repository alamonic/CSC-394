package com.capstone.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/responses")
public class ResponseController {
    public ResponseController() {
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
            Long delta = System.currentTimeMillis() - (long)session.getAttribute("Initial Time");
            session.setAttribute("Initial Time", null);
            session.setAttribute("Final Time", delta);
        }
            HashMap<String, String> response = new HashMap<>();
            response.put("status", "yes :D");
            return response;
    }
}
