<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Login</title>
  </head>
  <body>
    <h2>Login</h2>

    <c:if test="${not empty param.error}">
      <div style="color: red">${param.error}</div>
    </c:if>

    <c:if test="${not empty error}">
      <div style="color: red">${error}</div>
    </c:if>

    <c:if test="${not empty message}">
      <div style="color: green">${message}</div>
    </c:if>

    <form action="/auth/login" method="post">
      <label>Username<br /><input name="username" required /></label><br />
      <label
        >Password<br /><input name="password" type="password" required /></label
      ><br />
      <button type="submit">Login</button>
    </form>

    <p><a href="/">Home</a></p>
  </body>
</html>
