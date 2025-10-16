package com.example.login.servlets;

import com.example.login.dao.UserDAO;
import com.example.login.util.HashUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private final UserDAO dao = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u = req.getParameter("username");
        String p = req.getParameter("password");
        if (u == null || p == null) {
            resp.sendRedirect("index.html?error=Missing+credentials");
            return;
        }
        try {
            String stored = dao.getPasswordHash(u);
            if (stored != null && stored.equals(HashUtil.sha256(p))) {
                HttpSession session = req.getSession(true);
                session.setAttribute("user", u);
                resp.sendRedirect("home.jsp");
            } else {
                resp.sendRedirect("index.html?error=Invalid+username+or+password");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
