<%@ page contentType="text/html;charset=UTF-8" %> <% if
(session.getAttribute("user") == null) {
response.sendRedirect("index.html?error=Please+login"); return; } %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Delete Employee</title>
  </head>
  <body>
    <h2>Delete Employee</h2>
    <form action="employee/delete" method="post">
      <label
        >Employee ID to delete<br /><input name="id" type="number" required
      /></label>
      <button type="submit">Delete</button>
    </form>
    <p><a href="home.jsp">Back</a></p>
    <div style="color: green">${param.message}</div>
    <div style="color: red">${param.error}</div>
  </body>
</html>
