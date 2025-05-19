package com.voluntrack.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import com.voluntrack.model.UserModel;
import com.voluntrack.service.RegisterService;
import com.voluntrack.util.PasswordUtil;
import com.voluntrack.util.ValidationUtil;

/**
 * RegistrationController handles user registration requests and processes form
 * submissions.
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/register" })
public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final RegisterService registerService = new RegisterService();
    private static final List<String> VALID_INTERESTS = Arrays.asList(
        "education", "health", "environment", "animal", "community", "disaster", "arts"
    );

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Validate form inputs
            String validationMessage = validateRegistrationForm(req);
            if (validationMessage != null) {
                handleError(req, resp, validationMessage);
                return;
            }

            // Extract UserModel and register
            UserModel userModel = extractUserModel(req);
            Boolean isAdded = registerService.addUser(userModel);

            if (isAdded != null && isAdded) {
                handleSuccess(req, resp, "Your account is successfully created!", "/WEB-INF/pages/login.jsp");
            } else {
                handleError(req, resp, "Could not register your account. Please try again later!");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the error for debugging
            handleError(req, resp, "An unexpected error occurred. Please try again later!");
        }
    }

    // Validate form inputs
    private String validateRegistrationForm(HttpServletRequest req) {
        String fullName = req.getParameter("fullName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String location = req.getParameter("location");
        String ageStr = req.getParameter("age");
        String gender = req.getParameter("gender");
        String interest = req.getParameter("interest");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        // Check for null or empty fields
        if (ValidationUtil.isNullOrEmpty(fullName)) {
            return "Full name is required.";
        }
        if (ValidationUtil.isNullOrEmpty(username)) {
            return "Username is required.";
        }
        if (ValidationUtil.isNullOrEmpty(email)) {
            return "Email is required.";
        }
        if (ValidationUtil.isNullOrEmpty(phone)) {
            return "Phone number is required.";
        }
        if (ValidationUtil.isNullOrEmpty(location)) {
            return "Location is required.";
        }
        if (ValidationUtil.isNullOrEmpty(ageStr)) {
            return "Age is required.";
        }
        if (ValidationUtil.isNullOrEmpty(gender)) {
            return "Gender is required.";
        }
        if (ValidationUtil.isNullOrEmpty(interest)) {
            return "Interest area is required.";
        }
        if (ValidationUtil.isNullOrEmpty(password)) {
            return "Password is required.";
        }
        if (ValidationUtil.isNullOrEmpty(confirmPassword)) {
            return "Please confirm the password.";
        }

        // Validate field formats
        if (!ValidationUtil.isAlphabetic(fullName.replaceAll("\\s", ""))) {
            return "Full name must contain only letters.";
        }
        if (!ValidationUtil.isAlphanumericStartingWithLetter(username)) {
            return "Username must start with a letter and contain only letters and numbers.";
        }
        if (!ValidationUtil.isValidEmail(email)) {
            return "Invalid email format.";
        }
        if (!ValidationUtil.isValidPhoneNumber(phone)) {
            return "Phone number must be 10 digits and start with 98.";
        }
        try {
            int age = Integer.parseInt(ageStr);
            if (age < 16) {
                return "You must be at least 16 years old to register.";
            }
        } catch (NumberFormatException e) {
            return "Age must be a valid number.";
        }
        if (!isValidGender(gender)) {
            return "Invalid gender selection.";
        }
        if (!VALID_INTERESTS.contains(interest)) {
            return "Please select a valid area of interest.";
        }
        if (!ValidationUtil.isValidPassword(password)) {
            return "Password must be at least 8 characters long, with 1 uppercase letter, 1 number, and 1 symbol.";
        }
        if (!ValidationUtil.doPasswordsMatch(password, confirmPassword)) {
            return "Passwords do not match.";
        }

        return null; // All validations passed
    }

    // Custom gender validation to support additional options
    private boolean isValidGender(String gender) {
        return gender != null && Arrays.asList("male", "female", "nonbinary", "other", "prefer-not").contains(gender.toLowerCase());
    }

    // Extract UserModel from form data
    private UserModel extractUserModel(HttpServletRequest req) throws Exception {
        String fullName = req.getParameter("fullName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String location = req.getParameter("location");
        int age = Integer.parseInt(req.getParameter("age")); // Already validated
        String gender = req.getParameter("gender");
        String interest = req.getParameter("interest");
        String password = PasswordUtil.encrypt(fullName, req.getParameter("password"));
        Timestamp registrationDate = Timestamp.valueOf(LocalDateTime.now());

        return new UserModel(fullName, username, email, phone, location, age, gender, interest, password, registrationDate);
    }

    // Handle successful registration
    private void handleSuccess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage)
            throws ServletException, IOException {
        req.setAttribute("successMessage", message);
        req.getRequestDispatcher(redirectPage).forward(req, resp);
    }

    // Handle validation or processing errors
    private void handleError(HttpServletRequest req, HttpServletResponse resp, String message)
            throws ServletException, IOException {
        req.setAttribute("errorMessage", message);
        // Preserve form inputs
        req.setAttribute("fullName", req.getParameter("fullName"));
        req.setAttribute("username", req.getParameter("username"));
        req.setAttribute("email", req.getParameter("email"));
        req.setAttribute("phone", req.getParameter("phone"));
        req.setAttribute("location", req.getParameter("location"));
        req.setAttribute("age", req.getParameter("age"));
        req.setAttribute("gender", req.getParameter("gender"));
        req.setAttribute("interest", req.getParameter("interest"));
        req.getRequestDispatcher("/WEB-INF/pages/registration.jsp").forward(req, resp);
    }
}