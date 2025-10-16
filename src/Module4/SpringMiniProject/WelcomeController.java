package com.example.springlogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(HttpServletRequest req) {
        HttpSession s = req.getSession(false);
        if (s == null || s.getAttribute("user") == null) {
            return "redirect:/login?error=Please+login";
        }
        // user is present, show welcome
        return "welcome";
    }
}
