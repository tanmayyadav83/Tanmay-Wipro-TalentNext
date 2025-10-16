package com.example.crud.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LogoutServlet extends jakarta.servlet.http.HttpServlet {
    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest req,
                         jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession(false);
        if (s != null) s.invalidate();
        resp.sendRedirect("index.html");
    }
}
