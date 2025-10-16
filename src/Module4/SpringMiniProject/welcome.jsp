<%@ page contentType="text/html;charset=UTF-8" %> <%@ page
import="jakarta.servlet.http.HttpSession" %> <% HttpSession s =
request.getSession(false); String user = s != null ? (String)
s.getAttribute("user") : null; if (user == null) {
response.sendRedirect("login.jsp?error=Please+login"); return; } %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Welcome</title>
  </head>
  <body>
    <h2>Welcome, <%= user %></h2>
    <p>This is the restricted welcome page.</p>
    <p><a href="/auth/logout">Logout</a></p>
  </body>
</html>
