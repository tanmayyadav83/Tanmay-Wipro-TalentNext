package com.example.crud.servlets;

import com.example.crud.dao.EmployeeDAO;
import com.example.crud.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AddEmployeeServlet extends jakarta.servlet.http.HttpServlet {
    private final EmployeeDAO dao = new EmployeeDAO();

    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest req,
                          jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession(false) == null || req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("../index.html?error=Please+login");
            return;
        }

        try {
            Employee e = new Employee();
            e.setName(req.getParameter("name"));
            e.setGender(req.getParameter("gender"));
            e.setDesignation(req.getParameter("designation"));
            String salary = req.getParameter("salary");
            if (salary != null && !salary.isEmpty()) e.setSalary(Double.valueOf(salary));
            e.setCity(req.getParameter("city"));
            e.setEmail(req.getParameter("email"));
            e.setMobile(req.getParameter("mobile"));

            Integer id = dao.add(e);
            resp.sendRedirect("addEmployee.jsp?message=Added+ID+" + id);
        } catch (Exception ex) {
            resp.sendRedirect("addEmployee.jsp?error=" + ex.getMessage());
        }
    }
}
