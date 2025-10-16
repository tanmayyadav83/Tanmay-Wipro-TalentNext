package com.example.crud.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // Very simple hard-coded authentication for demo purposes.
    // Username: admin  Password: admin
    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest req,
                          jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("admin".equals(username) && "admin".equals(password)) {
            HttpSession session = req.getSession(true);
            session.setAttribute("user", username);
            resp.sendRedirect("home.jsp");
        } else {
            resp.sendRedirect("index.html?error=Invalid+credentials");
        }
    }
}
