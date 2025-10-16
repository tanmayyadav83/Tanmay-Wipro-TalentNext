<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Error</title>
  </head>
  <body>
    <h2>Error</h2>
    <div style="color: red">${requestScope['javax.servlet.error.message']}</div>
    <p><a href="/">Home</a></p>
  </body>
</html>
