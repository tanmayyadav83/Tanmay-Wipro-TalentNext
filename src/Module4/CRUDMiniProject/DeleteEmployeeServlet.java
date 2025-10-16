package com.example.crud.servlets;

import com.example.crud.dao.EmployeeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class DeleteEmployeeServlet extends jakarta.servlet.http.HttpServlet {
    private final EmployeeDAO dao = new EmployeeDAO();

    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest req,
                          jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession(false) == null || req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("../index.html?error=Please+login");
            return;
        }

        String sid = req.getParameter("id");
        if (sid == null || sid.isEmpty()) {
            resp.sendRedirect("deleteEmployee.jsp?error=Missing+id");
            return;
        }
        try {
            int id = Integer.parseInt(sid);
            boolean ok = dao.delete(id);
            if (ok) resp.sendRedirect("deleteEmployee.jsp?message=Deleted+"+id);
            else resp.sendRedirect("deleteEmployee.jsp?error=No+employee+with+id+"+id);
        } catch (Exception ex) {
            resp.sendRedirect("deleteEmployee.jsp?error=" + ex.getMessage());
        }
    }
}
