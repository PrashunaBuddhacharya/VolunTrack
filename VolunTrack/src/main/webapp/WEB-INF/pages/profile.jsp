<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Volunteer Profile</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/profile.css">
</head>
<body>
    <div class="container">
        <div class="profile-header">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path><circle cx="12" cy="7" r="4"></circle><path d="M4 16v-2a4 4 0 0 1 4-4h8a4 4 0 0 1 4 4v2"></path></svg>
            <h1>Volunteer Profile</h1>
        </div>

        <div class="profile-card">
            <div class="profile-image">
                <img src="https://via.placeholder.com/150" alt="Profile Picture"> </div>
            <div class="profile-info">
                <%
                    //  Get user data from the session or request attributes.  Fallback to empty strings.
                    String fullName = (String) request.getAttribute("fullName");
                    if (fullName == null) {
                        fullName = "";
                    }
                    String username = (String) request.getAttribute("username");
                     if (username == null) {
                        username = "";
                    }
                    String email = (String) request.getAttribute("email");
                    if (email == null) {
                        email = "";
                    }
                    String phone = (String) request.getAttribute("phone");
                    if (phone == null) {
                        phone = "";
                    }
                    String location = (String) request.getAttribute("location");
                    if (location == null) {
                        location = "";
                    }
                    String age = (String) request.getAttribute("age");
                    if (age == null) {
                        age = "";
                    }
                    String gender = (String) request.getAttribute("gender");
                    if (gender == null) {
                        gender = "";
                    }
                    String interest = (String) request.getAttribute("interest");
                     if (interest == null) {
                        interest = "";
                    }
                %>
                <div class="info-group">
                    <span class="label">Full Name:</span>
                    <span class="value"><%= fullName %></span>
                </div>
                <div class="info-group">
                    <span class="label">Username:</span>
                    <span class="value"><%= username %></span>
                </div>
                <div class="info-group">
                    <span class="label">Email:</span>
                    <span class="value"><%= email %></span>
                </div>
                <div class="info-group">
                    <span class="label">Phone:</span>
                    <span class="value"><%= phone %></span>
                </div>
                <div class="info-group">
                    <span class="label">Location:</span>
                    <span class="value"><%= location %></span>
                </div>
                 <div class="info-group">
                    <span class="label">Age:</span>
                    <span class="value"><%= age %></span>
                </div>
                <div class="info-group">
                    <span class="label">Gender:</span>
                    <span class="value"><%= gender %></span>
                </div>
                <div class="info-group">
                    <span class="label">Interest:</span>
                    <span class="value"><%= interest %></span>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
