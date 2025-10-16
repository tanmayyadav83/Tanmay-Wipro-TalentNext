package com.example.crud.servlets;

import com.example.crud.dao.EmployeeDAO;
import com.example.crud.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ModifyEmployeeServlet extends jakarta.servlet.http.HttpServlet {
    private final EmployeeDAO dao = new EmployeeDAO();

    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest req,
                          jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession(false) == null || req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("../index.html?error=Please+login");
            return;
        }

        try {
            String sid = req.getParameter("id");
            if (sid == null || sid.isEmpty()) {
                resp.sendRedirect("home.jsp?error=Missing+id");
                return;
            }
            int id = Integer.parseInt(sid);
            Employee e = dao.findById(id);
            if (e == null) {
                resp.sendRedirect("home.jsp?error=No+employee+with+id+"+id);
                return;
            }
            // update fields
            e.setName(req.getParameter("name"));
            e.setGender(req.getParameter("gender"));
            e.setDesignation(req.getParameter("designation"));
            String sal = req.getParameter("salary");
            if (sal != null && !sal.isEmpty()) e.setSalary(Double.valueOf(sal));
            e.setCity(req.getParameter("city"));
            e.setEmail(req.getParameter("email"));
            e.setMobile(req.getParameter("mobile"));

            boolean ok = dao.update(e);
            if (ok) resp.sendRedirect("employee/list?message=Updated+"+id);
            else resp.sendRedirect("home.jsp?error=Could+not+update");
        } catch (Exception ex) {
            resp.sendRedirect("home.jsp?error=" + ex.getMessage());
        }
    }
}
