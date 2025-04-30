package com.voluntrack.controller;

import java.io.IOException;
import java.sql.Timestamp;

import com.voluntrack.model.UserModel;
import com.voluntrack.service.RegisterService;
import com.voluntrack.util.PasswordUtil;
import com.voluntrack.util.ValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegisterService registerService;

    @Override
    public void init() throws ServletException {
        registerService = new RegisterService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String validationError = validateRegistrationForm(req);
            if (validationError != null) {
                handleError(req, resp, validationError);
                return;
            }

            UserModel user = extractUserModel(req);
            Boolean isAdded = registerService.addUser(user);

            if (isAdded == null) {
                handleError(req, resp, "Server error. Please try again later.");
            } else if (isAdded) {
                handleSuccess(req, resp, "Account created successfully!", "/WEB-INF/pages/login.jsp");
            } else {
                handleError(req, resp, "Registration failed. Please try again.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            handleError(req, resp, "An unexpected error occurred.");
        }
    }

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

        if (ValidationUtil.isNullOrEmpty(fullName)) return "Full name is required.";
        if (ValidationUtil.isNullOrEmpty(username)) return "Username is required.";
        if (ValidationUtil.isNullOrEmpty(email)) return "Email is required.";
        if (ValidationUtil.isNullOrEmpty(phone)) return "Phone is required.";
        if (ValidationUtil.isNullOrEmpty(ageStr)) return "Age is required.";
        if (ValidationUtil.isNullOrEmpty(password)) return "Password is required.";
        if (ValidationUtil.isNullOrEmpty(confirmPassword)) return "Please confirm your password.";

        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            return "Age must be a number.";
        }

        if (!ValidationUtil.isAlphaNumericStartingWithLetters(username))
            return "Username must start with a letter and contain only letters and numbers.";

        if (registerService.isUsernameDuplicate(username))
            return "Username already exists.";

        if (!ValidationUtil.isValidEmail(email)) return "Invalid email format.";
        if (!ValidationUtil.isValidPhoneNumber(phone)) return "Phone must be 10 digits and start with 98.";
        if (!ValidationUtil.isValidPassword(password))
            return "Password must be 8+ chars with uppercase, number, and symbol.";
        if (!ValidationUtil.doPasswordMatch(password, confirmPassword))
            return "Passwords do not match.";
        if (age < 16) return "You must be at least 16 years old.";

        return null;
    }

    private UserModel extractUserModel(HttpServletRequest req) {
        String fullName = req.getParameter("fullName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String location = req.getParameter("location");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String interest = req.getParameter("interest");
        String password = req.getParameter("password");

        String encryptedPassword = PasswordUtil.encrypt(username, password);
        Timestamp registrationDate = new Timestamp(System.currentTimeMillis());

        UserModel user = new UserModel();
        user.setFullName(fullName);
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setLocation(location);
        user.setAge(age);
        user.setGender(gender);
        user.setInterestArea(interest);
        user.setPassword(encryptedPassword);
        user.setRegistrationDate(registrationDate);
        return user;
    }

    private void handleSuccess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage)
            throws ServletException, IOException {
        req.setAttribute("successMessage", message);
        req.getRequestDispatcher(redirectPage).forward(req, resp);
    }

    private void handleError(HttpServletRequest req, HttpServletResponse resp, String message)
            throws ServletException, IOException {
        req.setAttribute("errorMessage", message);
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
