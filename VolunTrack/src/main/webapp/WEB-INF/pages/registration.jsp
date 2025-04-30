<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Volunteer Registration</title>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/registration.css" />
  <script>
    function handleSubmit(event) {
      event.preventDefault(); // Prevent default form submission
      // Optionally, add client-side validation here
      window.location.href = "login.jsp"; // Redirect to login page
    }
  </script>
</head>
<body>
  <div class="container">
    <div class="image-side">
      <div class="overlay">
        <h2>Make a Difference</h2>
        <p>Join our community of volunteers and help create positive change in your neighborhood and beyond.</p>
        <div class="pin-style">Volunteering Community</div>
      </div>
    </div>

    <div class="form-side">
      <div class="form-header">
        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path><polyline points="14 2 14 8 20 8"></polyline><line x1="16" y1="13" x2="8" y2="13"></line><line x1="16" y1="17" x2="8" y2="17"></line><polyline points="10 9 9 9 8 9"></polyline></svg>
        <h1>Create Your Account</h1>
      </div>

      <!-- Add server message if available -->
      <%
        String success = (String) request.getAttribute("successMessage");
        String error = (String) request.getAttribute("errorMessage");
      %>
      <% if (success != null) { %>
        <div class="success-message"><%= success %></div>
      <% } %>
      <% if (error != null) { %>
        <div class="error-message"><%= error %></div>
      <% } %>

      <!-- Updated form with username -->
      <form action="register" method="post">
        <div class="form-group">
          <label for="fullName">Full Name</label>
          <input type="text" id="fullName" name="fullName" placeholder="Enter your full name" required>
        </div>

        <div class="form-group">
          <label for="username">Username</label>
          <input type="text" id="username" name="username" placeholder="Choose a username" required>
        </div>

        <div class="form-group">
          <label for="email">Email Address</label>
          <input type="email" id="email" name="email" placeholder="Enter your email address" required>
        </div>

        <div class="form-group">
          <label for="phone">Phone Number</label>
          <input type="tel" id="phone" name="phone" placeholder="Enter your phone number">
        </div>

        <div class="form-group">
          <label for="location">Location</label>
          <input type="text" id="location" name="location" placeholder="Enter your city and state">
        </div>

        <div class="form-group">
          <label for="age">Age</label>
          <input type="number" id="age" name="age" placeholder="Enter your age" min="16" max="120">
        </div>

        <div class="form-group">
          <label for="gender">Gender</label>
          <select id="gender" name="gender">
            <option value="" disabled selected>Select Gender</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="nonbinary">Non-binary</option>
            <option value="other">Other</option>
            <option value="prefer-not">Prefer not to say</option>
          </select>
        </div>

        <div class="form-group">
          <label for="interest">Area of Interest</label>
          <select id="interest" name="interest">
            <option value="" disabled selected>Select an area of interest</option>
            <option value="education">Education</option>
            <option value="health">Healthcare</option>
            <option value="environment">Environment</option>
            <option value="animal">Animal Welfare</option>
            <option value="community">Community Service</option>
            <option value="disaster">Disaster Relief</option>
            <option value="arts">Arts & Culture</option>
          </select>
        </div>

        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" id="password" name="password" placeholder="Create a password" required>
        </div>

        <div class="form-group">
          <label for="confirmPassword">Confirm Password</label>
          <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm your password" required>
        </div>

        <button type="submit">Register</button>
      </form>
    </div>
  </div>
</body>
</html>
