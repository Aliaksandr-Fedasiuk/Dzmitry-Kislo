package com.epam.cdp.jms;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(description = "Input Message Servlet", urlPatterns = {"/InputMessageServlet", "/InputMessageServlet.do"})
public class InputMessageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/jsps/message/input.jsp").forward(request, response);
    }
}
