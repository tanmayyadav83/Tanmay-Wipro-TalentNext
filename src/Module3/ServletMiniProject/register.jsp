<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Register</title>
  </head>
  <body>
    <h2>Register new user</h2>
    <form action="register" method="post" onsubmit="return validate();">
      <label
        >Username<br /><input id="username" name="username" required /></label
      ><br />
      <label
        >Password<br /><input
          id="password"
          type="password"
          name="password"
          required /></label
      ><br />
      <label
        >Retype Password<br /><input
          id="password2"
          type="password"
          name="password2"
          required /></label
      ><br />
      <button type="submit">Add</button>
    </form>
    <p><a href="index.html">Back to login</a></p>

    <script>
      function validate() {
        var p = document.getElementById("password").value;
        var p2 = document.getElementById("password2").value;
        if (p !== p2) {
          alert("Passwords do not match");
          return false;
        }
        if (p.length < 6) {
          alert("Password must be at least 6 chars");
          return false;
        }
        return true;
      }
    </script>

    <div style="color: green">${param.message}</div>
    <div style="color: red">${param.error}</div>
  </body>
</html>
