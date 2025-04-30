<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us - Voluntrack</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/about.css" />
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
    <nav class="navbar">
        <div class="logo">
            <img src="https://images.pexels.com/photos/6646919/pexels-photo-6646919.jpeg?auto=compress&cs=tinysrgb&w=40&h=40" alt="Voluntrack Logo" class="logo-img" onerror="this.onerror=null; this.src=''; this.nextElementSibling.style.display='block';">
            <span class="image-fallback" style="display: none;">Logo not available</span>
        </div>
        <ul class="nav-links">
            <li><a href="#">Home</a></li>
            <li><a href="#">Opportunities</a></li>
            <li><a href="#">Resources</a></li>
            <li><a href="#" class="cta-button">Get Involved</a></li>
        </ul>
    </nav>

    <section class="mission-section">
        <h2>Our Mission</h2>
        <p>At Voluntrack, we believe in creating a world where youth are empowered through cross-cultural volunteering experiences. Our platform connects passionate individuals with impactful volunteering opportunities across the globe, helping communities grow while volunteers gain life-changing experiences.</p>
        <div class="decorative-element">
            <span class="signature">Voluntrack Team</span>
            <span class="tagline">Volunteering Abroad <i class="fas fa-arrow-right"></i> Connecting the World</span>
        </div>
    </section>

    <section class="story-section">
        <h2>Our Story</h2>
        <div class="story-content">
            <div class="story-image">
                <img src="https://images.pexels.com/photos/6646917/pexels-photo-6646917.jpeg?auto=compress&cs=tinysrgb&w=500&h=300" alt="Voluntrack Story" class="story-img" onerror="this.onerror=null; this.src=''; this.nextElementSibling.style.display='block';">
                <span class="image-fallback" style="display: none;">Image not available</span>
            </div>
            <div class="story-text">
                <p>Founded in 2020 by a group of passionate travelers and philanthropists, Voluntrack emerged from a shared vision to bridge cultural gaps through volunteering. We noticed the transformative power of global experiences and created a platform to make them accessible to youth worldwide, fostering growth, understanding, and positive impact.</p>
            </div>
        </div>
    </section>
</body>
</html>