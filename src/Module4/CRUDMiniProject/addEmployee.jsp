<%@ page contentType="text/html;charset=UTF-8" %> <% if
(session.getAttribute("user") == null) {
response.sendRedirect("index.html?error=Please+login"); return; } %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Add Employee</title>
  </head>
  <body>
    <h2>Add Employee</h2>
    <form action="employee/add" method="post">
      <label>Name<br /><input name="name" required /></label>
      <label
        >Gender<br />
        <select name="gender">
          <option>Male</option>
          <option>Female</option>
          <option>Other</option>
        </select>
      </label>
      <label>Designation<br /><input name="designation" /></label>
      <label
        >Salary<br /><input name="salary" type="number" step="0.01"
      /></label>
      <label>City<br /><input name="city" /></label>
      <label>Email<br /><input name="email" type="email" /></label>
      <label>Mobile No<br /><input name="mobile" /></label>
      <button type="submit">Add</button>
    </form>
    <p><a href="home.jsp">Back</a></p>
    <div style="color: green">${param.message}</div>
    <div style="color: red">${param.error}</div>
  </body>
</html>
