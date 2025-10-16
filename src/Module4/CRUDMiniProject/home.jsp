<%@ page contentType="text/html;charset=UTF-8" %> <% String user = (String)
session.getAttribute("user"); if (user == null) {
response.sendRedirect("index.html?error=Please+login"); return; } %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Home</title>
  </head>
  <body>
    <h2>CRUD Operations - Welcome, <%= user %></h2>
    <ul>
      <li><a href="addEmployee.jsp">ADD Employee</a></li>
      <li><a href="deleteEmployee.jsp">DELETE Employee</a></li>
      <li><a href="modifyEmployee.jsp">MODIFY Personal details</a></li>
      <li><a href="findEmployee.jsp">SELECT Employee by Id</a></li>
      <li><a href="employee/list">SELECT ALL Employee</a></li>
    </ul>
    <p><a href="logout">Logout</a></p>
  </body>
</html>
