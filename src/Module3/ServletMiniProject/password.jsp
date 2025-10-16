<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Change password</title>
  </head>
  <body>
    <h2>Change Password</h2>
    <form action="change-password" method="post" onsubmit="return validate();">
      <label
        >Username<br /><input id="username" name="username" required /></label
      ><br />
      <label
        >Old password<br /><input
          id="old"
          type="password"
          name="oldPassword"
          required /></label
      ><br />
      <label
        >New password<br /><input
          id="newp"
          type="password"
          name="newPassword"
          required /></label
      ><br />
      <label
        >Retype new password<br /><input
          id="newp2"
          type="password"
          name="newPassword2"
          required /></label
      ><br />
      <button type="submit">Change</button>
    </form>
    <p><a href="index.html">Back to login</a></p>

    <script>
      function validate() {
        var n = document.getElementById("newp").value;
        var n2 = document.getElementById("newp2").value;
        if (n !== n2) {
          alert("New passwords do not match");
          return false;
        }
        if (n.length < 6) {
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
