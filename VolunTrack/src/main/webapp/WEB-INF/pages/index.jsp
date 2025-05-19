<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Voluntrack - Home</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<body>
<header class="navbar">
<div class="logo">Voluntrack 🌍</div>
<ul class="nav-links">
<li><a href="${pageContext.request.contextPath}/opportunities">Opportunities</a></li>
<li><a href="${pageContext.request.contextPath}/about">About Us</a></li>
<li><a href="${pageContext.request.contextPath}/contact">Contact</a></li>
<li><a href="${pageContext.request.contextPath}/profile" class="profile-link">Profile</a></li>
</ul>
</header>

<section class="hero">
<img src="resources/cartoon.png" alt="Community Education in Brazil"  class="hero-image">
<div class="hero-content">
<h1>Make a Difference, One Step at a Time</h1>
<p>Join hands with volunteers across the globe to create meaningful change.</p>
<div class="hero-buttons">
<a href="${pageContext.request.contextPath}/opportunities">Explore Opportunities</a>
<a href="${pageContext.request.contextPath}/register">Join Us</a>
</div>
</div>
</section>

<section class="section">
<div class="section-title">
<h2>Featured Projects</h2>
<p>Discover meaningful volunteer opportunities making a real impact in communities worldwide</p>
</div>
<div class="cards-container">
<div class="card">
<div class="card-img-container">
<img src="https://cdn.pixabay.com/photo/2017/07/25/01/22/cat-2536662_1280.jpg" alt="Animal Shelter Volunteering" class="card-img">
</div>
<div class="card-content">
<h3 class="card-title">Animal Shelter Support</h3>
<p class="card-text">Help care for abandoned animals and assist with adoption events at local shelters.</p>
<a href="${pageContext.request.contextPath}/opportunities" class="card-link">Learn More →</a>
</div>
</div>
<div class="card">
<div class="card-img-container">
<img src="resources/brazil.jpg" alt="Community Education in Brazil" class="card-img">
</div>
<div class="card-content">
<h3 class="card-title">Education Initiative</h3>
<p class="card-text">Teach and mentor underserved students to help bridge the educational gap.</p>
<a href="${pageContext.request.contextPath}/opportunities" class="card-link">Learn More →</a>
</div>
</div>
<div class="card">
<div class="card-img-container">
<img src="resources/v.jpg" alt="Community Education in Brazil" class="card-img">
</div>
<div class="card-content">
<h3 class="card-title">Environmental Cleanup</h3>
<p class="card-text">Join community efforts to clean beaches, parks, and nature reserves.</p>
<a href="${pageContext.request.contextPath}/opportunities" class="card-link">Learn More →</a>
</div>
</div>
</div>
</section>

<section class="quote-section">
<div class="quote">
"The best way to find yourself is to lose yourself in the service of others."
</div>
<div class="quote-author">- Mahatma Gandhi</div>
</section>

<section class="section">
<div class="section-title">
<h2>Why Volunteer With Us</h2>
<p>Discover how volunteering can transform communities while enriching your own life</p>
</div>
<div class="cards-container">
<div class="card">
<div class="card-img-container">
<img src="resources/cartoon.png" alt="Community Education in Brazil" class="card-img">
</div>
<div class="card-content">
<h3 class="card-title">Make Real Impact</h3>
<p class="card-text">Our carefully vetted opportunities ensure your time creates meaningful change for communities in need.</p>
</div>
</div>
<div class="card">
<div class="card-img-container">
<img src="https://cdn.pixabay.com/photo/2015/01/09/11/08/startup-594090_1280.jpg" alt="Skill Development" class="card-img">
</div>
<div class="card-content">
<h3 class="card-title">Develop New Skills</h3>
<p class="card-text">Gain valuable experience and develop transferable skills that enhance your personal and professional life.</p>
</div>
</div>
<div class="card">
<div class="card-img-container">
<img src="resources/india.jpg" alt="Community Education in Brazil" class="card-img">
</div>
<div class="card-content">
<h3 class="card-title">Join a Global Community</h3>
<p class="card-text">Connect with like-minded individuals from around the world who share your passion for service.</p>
</div>
</div>
</div>
</section>

<section class="stats-section">
<div class="section-title">
<h2>Our Impact Together</h2>
<p>Together we're creating positive change across communities worldwide</p>
</div>
<div class="stats-container">
<div class="stat-item">
<div class="stat-number">10,000+</div>
<div class="stat-text">Active Volunteers</div>
</div>
<div class="stat-item">
<div class="stat-number">500+</div>
<div class="stat-text">Partner Organizations</div>
</div>
<div class="stat-item">
<div class="stat-number">75</div>
<div class="stat-text">Countries Served</div>
</div>
<div class="stat-item">
<div class="stat-number">1.2M</div>
<div class="stat-text">Volunteer Hours</div>
</div>
</div>
</section>

<section class="quote-section">
<div class="quote">
"Never doubt that a small group of thoughtful, committed citizens can change the world; indeed, it's the only thing that ever has."
</div>
<div class="quote-author">- Margaret Mead</div>
</section>

<footer>
© 2025 Voluntrack — Empowering Global Volunteering 🌍
</footer>

<script>
document.addEventListener('DOMContentLoaded', function() {
  // Add any additional JavaScript functionality here
});
</script>
</body>
</html>