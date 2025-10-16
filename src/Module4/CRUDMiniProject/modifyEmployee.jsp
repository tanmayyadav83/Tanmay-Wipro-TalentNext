<%@ page contentType="text/html;charset=UTF-8" %> <% if
(session.getAttribute("user") == null) {
response.sendRedirect("index.html?error=Please+login"); return; } %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Modify Employee</title>
  </head>
  <body>
    <h2>Modify Employee</h2>
    <p>Enter employee id to load for modification:</p>
    <form action="employee/find" method="get">
      <input type="hidden" name="redirect" value="modify" />
      <label>ID<br /><input name="id" type="number" required /></label>
      <button type="submit">Load</button>
    </form>
    <p><a href="home.jsp">Back</a></p>
    <div style="color: red">${param.error}</div>
  </body>
</html>
