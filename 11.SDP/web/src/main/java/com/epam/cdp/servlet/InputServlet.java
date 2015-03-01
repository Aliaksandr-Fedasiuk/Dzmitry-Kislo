package com.epam.cdp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dima on 2.3.15.
 */
@WebServlet(description = "Input User Servlet", urlPatterns = {"/InputServlet", "/InputServlet.do"})
public class InputServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/jsp/input.jsp").forward(
                request, response);
    }

}
