package com.voluntrack.controller;

import java.io.IOException;

import com.voluntrack.model.UserModel;
import com.voluntrack.service.LoginService;
import com.voluntrack.util.RedirectUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ValidationUtil validationUtil;
    private final RedirectUtil redirectionUtil;
    private final LoginService loginService;

    private static final String LOGIN_PAGE = "/WEB-INF/pages/login.jsp";
    private static final String HOME_PAGE = "/WEB-INF/pages/home.jsp";
    private static final String ADMIN_PAGE = "/WEB-INF/pages/admin/dashboard.jsp";

    public LoginController() {
        this.validationUtil = new ValidationUtil();
        this.redirectionUtil = new RedirectionUtil();
        this.loginService = new LoginService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("full_name");
        String password = req.getParameter("password");
        
        System.out.println("Login attempt - Full Name: [" + fullName + "], Password: [" + password + "]");

        // Input validation
        if (validationUtil.isNullOrEmpty(fullName) || validationUtil.isNullOrEmpty(password)) {
            System.out.println("Validation failed: Redirecting to login.jsp");
            redirectionUtil.setMsgAndRedirect(req, resp, "error", "Please fill all the fields!", LOGIN_PAGE);
            return;
        }

        // Admin login logic
        if ("admin".equals(fullName) && "adminpassword".equals(password)) {
            System.out.println("Admin login successful!");
            req.getSession().setAttribute("full_name", fullName);
            redirectionUtil.setMsgAndRedirect(req, resp, "success", "Welcome Admin!", ADMIN_PAGE);
            return;
        }

        // Regular user login
        UserModel userModel = new UserModel();
        userModel.setFullName(fullName);
        userModel.setPassword(password);

        Boolean isValid = loginService.loginUser(userModel);

        if (isValid == null) {
            System.out.println("Database connection error: Redirecting to login.jsp");
            redirectionUtil.setMsgAndRedirect(req, resp, "error", "Database error, please try again later!", LOGIN_PAGE);
        } else if (isValid) {
            System.out.println("Credentials valid: Redirecting to home.jsp");
            req.getSession().setAttribute("full_name", fullName);
            redirectionUtil.setMsgAndRedirect(req, resp, "success", "Successfully Logged In!", HOME_PAGE);
        } else {
            System.out.println("Credentials invalid: Redirecting to login.jsp");
            redirectionUtil.setMsgAndRedirect(req, resp, "error", "Either full name or password is incorrect!", LOGIN_PAGE);
        }
    }
}
