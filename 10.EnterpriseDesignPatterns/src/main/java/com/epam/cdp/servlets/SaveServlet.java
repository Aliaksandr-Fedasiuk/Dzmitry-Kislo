package com.epam.cdp.servlets;

import com.epam.cdp.service.TicketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dima on 15.2.15.
 */
@WebServlet(description = "Save User Servlet", urlPatterns = {"/SaveServlet", "/SaveServlet.do"})
public class SaveServlet extends HttpServlet {
    private TicketService ticketService = new TicketService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Integer place = Integer.valueOf(request.getParameter("place"));
        Long userId = ticketService.registerUser(name, password);
        ticketService.buyTickets(userId, place);
        request.getRequestDispatcher("/InputServlet.do").forward(request, response);
    }
}
