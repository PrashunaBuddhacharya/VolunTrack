<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login - Voluntrack</title>
    <!-- Set contextPath variable for reuse -->
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}/css/login.css" />
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <div class="login-box">
            <h2><i class="fas fa-sign-in-alt"></i> Login to Voluntrack</h2>

            <!-- Display error message if available -->
            <c:if test="${not empty error}">
                <p class="error-message">${error}</p>
            </c:if>

            <!-- Display success message if available -->
            <c:if test="${not empty success}">
                <p class="success-message">${success}</p>
            </c:if>

            <form action="${contextPath}/login" method="post">
                <div class="row">
                    <div class="col">
                        <input type="text" id="full_name" name="full_name" placeholder="Full Name" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <input type="password" id="password" name="password" placeholder="Password" required>
                    </div>
                </div>
                <button type="submit" class="login-button">Login</button>
                <div class="register-link">
                    Don’t have an account? <a href="${contextPath}/registration.jsp">Register here</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
