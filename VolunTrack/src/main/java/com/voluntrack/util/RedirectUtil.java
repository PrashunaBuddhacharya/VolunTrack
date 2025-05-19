package com.voluntrack.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectUtil {

    /**
     * Sets a message in session scope and redirects the user.
     *
     * @param req       HttpServletRequest
     * @param resp      HttpServletResponse
     * @param type      Message type (e.g., "error", "success")
     * @param message   The message text
     * @param path      The URL to redirect to (e.g., "/home", "/login")
     */
    public void setMsgAndRedirect(HttpServletRequest req, HttpServletResponse resp,
                                   String msgType, String message, String path) throws IOException {
        req.getSession().setAttribute(msgType, message);
        resp.sendRedirect(req.getContextPath() + path);
    }
}
