package com.example.login.servlets;

import com.example.login.dao.UserDAO;
import com.example.login.util.HashUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private final UserDAO dao = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u = req.getParameter("username");
        String p = req.getParameter("password");
        String p2 = req.getParameter("password2");
        if (u == null || p == null || p2 == null || !p.equals(p2)) {
            resp.sendRedirect("register.jsp?error=Validation+failed");
            return;
        }
        try {
            boolean ok = dao.createUser(u, HashUtil.sha256(p));
            if (ok) {
                resp.sendRedirect("register.jsp?message=User+created.+Please+login");
            } else {
                resp.sendRedirect("register.jsp?error=Could+not+create+user");
            }
        } catch (Exception e) {
            resp.sendRedirect("register.jsp?error=" + e.getMessage());
        }
    }
}
