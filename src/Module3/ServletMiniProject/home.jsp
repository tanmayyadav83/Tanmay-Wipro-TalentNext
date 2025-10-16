<%@ page contentType="text/html;charset=UTF-8" language="java" %> <% String user
= (String) session.getAttribute("user"); if (user == null){
response.sendRedirect("index.html"); return; } %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Home</title>
  </head>
  <body>
    <h2>Welcome, <%= user %></h2>
    <p><a href="index.html">Logout</a></p>
  </body>
</html>
