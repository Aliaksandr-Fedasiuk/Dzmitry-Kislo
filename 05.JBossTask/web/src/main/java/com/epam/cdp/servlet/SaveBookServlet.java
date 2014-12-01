package com.epam.cdp.servlet;

import com.epam.cdp.entity.Book;
import com.epam.cdp.service.BookManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dima on 1.12.14.
 */
@WebServlet(urlPatterns = {"/save", "/save.do"})
@ServletSecurity(httpMethodConstraints = {
        @HttpMethodConstraint(value = "GET", rolesAllowed = "MANAGER"),
        @HttpMethodConstraint(value = "POST", rolesAllowed = "MANAGER")
})
public class SaveBookServlet extends HttpServlet {
    @EJB
    BookManager bookManager;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        Book book = new Book();
        book.setTitle(title);
        bookManager.create(book);
        request.getRequestDispatcher("/books.do").forward(request, response);
    }
}
