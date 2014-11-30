package com.epam.cdp.servlet;

import com.epam.cdp.service.BookManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dima on 1.12.14.
 */
@WebServlet(urlPatterns = {"/input", "/input.do"})
public class InputBookServlet extends HttpServlet{

    @EJB
    BookManager bookManager;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/jsp/input.jsp").forward(request, response);
    }
}

