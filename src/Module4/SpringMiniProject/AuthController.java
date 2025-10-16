package com.example.springlogin.controller;

import com.example.springlogin.dao.UserDAO;
import com.example.springlogin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDAO userDAO;

    // handle registration POST
    @PostMapping("/register")
    public String register(HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String employeeNo = req.getParameter("employeeNo");
        String email = req.getParameter("email");

        // validations
        if (!StringUtils.hasText(username) || !StringUtils.hasText(password)
                || !StringUtils.hasText(employeeNo) || !StringUtils.hasText(email)) {
            req.setAttribute("error", "All fields are mandatory");
            return "register";
        }

        // employee id: one alphabet followed by exactly 4 digits
        if (!employeeNo.matches("^[A-Za-z]{1}\\d{4}$")) {
            req.setAttribute("error", "Employee ID must be single alphabet followed by exactly 4 digits (e.g. A1234)");
            return "register";
        }

        // password exactly 6 characters
        if (password.length() != 6) {
            req.setAttribute("error", "Password must be exactly 6 characters long");
            return "register";
        }

        // create
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.setEmployeeNo(employeeNo);
        u.setEmail(email);

        try {
            boolean ok = userDAO.createUser(u);
            if (ok) {
                req.setAttribute("message", "Registration successful. Please login.");
                return "login";
            } else {
                req.setAttribute("error", "Could not create user.");
                return "register";
            }
        } catch (Exception ex) {
            req.setAttribute("error", "Error: " + ex.getMessage());
            return "register";
        }
    }

    // handle login POST
    @PostMapping("/login")
    public String login(HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (!StringUtils.hasText(username) || !StringUtils.hasText(password)) {
            req.setAttribute("error", "Username and password required");
            return "login";
        }

        boolean valid = userDAO.validateLogin(username, password);
        if (valid) {
            HttpSession session = req.getSession(true);
            session.setAttribute("user", username);
            return "redirect:/welcome";
        } else {
            // determine reason for failure
            if (userDAO.findByUsername(username) == null) {
                req.setAttribute("error", "There is no such user in the system");
            } else {
                req.setAttribute("error", "The combination of username/password is wrong");
            }
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req) {
        HttpSession s = req.getSession(false);
        if (s != null) s.invalidate();
        return "redirect:/login";
    }
}
