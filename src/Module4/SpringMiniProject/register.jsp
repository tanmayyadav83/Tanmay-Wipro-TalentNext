<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Register</title>
    <script>
      function validate() {
        var username = document.getElementById("username").value.trim();
        var password = document.getElementById("password").value;
        var emp = document.getElementById("employeeNo").value.trim();
        var email = document.getElementById("email").value.trim();

        if (!username || !password || !emp || !email) {
          alert("All fields are mandatory");
          return false;
        }
        if (!/^[A-Za-z]{1}\d{4}$/.test(emp)) {
          alert("Employee ID must be one alphabet followed by 4 digits");
          return false;
        }
        if (password.length !== 6) {
          alert("Password must be exactly 6 characters");
          return false;
        }
        // Basic email validation
        if (!/^\S+@\S+\.\S+$/.test(email)) {
          alert("Invalid email");
          return false;
        }
        return true;
      }
    </script>
  </head>
  <body>
    <h2>Register</h2>

    <c:if test="${not empty error}">
      <div style="color: red">${error}</div>
    </c:if>

    <c:if test="${not empty message}">
      <div style="color: green">${message}</div>
    </c:if>

    <form action="/auth/register" method="post" onsubmit="return validate();">
      <label
        >Username<br /><input id="username" name="username" required /></label
      ><br />
      <label
        >Password (exactly 6 chars)<br /><input
          id="password"
          name="password"
          type="password"
          required /></label
      ><br />
      <label
        >Employee No (A1234)<br /><input
          id="employeeNo"
          name="employeeNo"
          required /></label
      ><br />
      <label
        >Email<br /><input
          id="email"
          name="email"
          type="email"
          required /></label
      ><br />
      <button type="submit">Register</button>
    </form>

    <p><a href="/">Home</a></p>
  </body>
</html>
