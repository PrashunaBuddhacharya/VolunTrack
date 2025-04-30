<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Login - Voluntrack</title>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="css/login.css" />
  <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<body>
  <div class="container">
    <div class="login-box">
      <h2><i class="fas fa-sign-in-alt"></i> Login to Voluntrack</h2>
      <form action="LoginServlet" method="post">
        <input type="email" name="email" placeholder="Email Address" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
        <div class="register-link">
          Don’t have an account? <a href="register.jsp">Register here</a>
        </div>
        <% 
          String error = request.getParameter("error");
          if (error != null) {
        %>
            <p style="color:red; text-align:center;">Invalid credentials</p>
        <% } %>
      </form>
    </div>
  </div>
</body>
</html>
