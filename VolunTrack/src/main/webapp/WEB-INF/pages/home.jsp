<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Voluntrack - Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<body>
    <header class="navbar">
        <div class="logo">Voluntrack 🌍</div>
        <ul class="nav-links">
              
   <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/opportunities">Opportunities</a></li>
            <li><a href="${pageContext.request.contextPath}/about">About Us</a></li>
            <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
            <li><a href="${pageContext.request.contextPath}/register">Register</a></li>      </ul>
    </header>

    <section class="hero">
        <div class="hero-content">
            <h1>Travel differently, connect globally</h1>
            <p>Explore exciting volunteer programs across 100+ countries</p>
            <div class="hero-buttons">
                <a href="${pageContext.request.contextPath}/opportunities">Discover Opportunities</a>
                <a href="${pageContext.request.contextPath}/register">Join Us</a>
            </div>
        </div>
    </section>

    <section class="features">
        <div class="feature-box">
            <i class="fas fa-hands-helping"></i>
            <h3>Global Impact</h3>
            <p>Volunteer in places that truly need your support and energy.</p>
        </div>
        <div class="feature-box">
            <i class="fas fa-globe-americas"></i>
            <h3>170+ Countries</h3>
            <p>Opportunities in diverse communities and cultures worldwide.</p>
        </div>
        <div class="feature-box">
            <i class="fas fa-users"></i>
            <h3>Join a Community</h3>
            <p>Be part of a growing global family of changemakers and travelers.</p>
        </div>
    </section>

    <footer>
        © 2025 Voluntrack — Empowering Global Volunteering 🌍
    </footer>
</body>
</html>