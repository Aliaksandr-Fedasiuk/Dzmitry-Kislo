package com.epam.cdp.servlet;

import com.epam.cdp.entity.Book;
import com.epam.cdp.service.BookManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dima on 30.11.14.
 */
@WebServlet(urlPatterns = {"/books", "/books.do"})
public class BookServlet extends HttpServlet {

    @EJB
    BookManager bookManager;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = bookManager.findAll();
        request.setAttribute("books", bookList);
        request.getRequestDispatcher("WEB-INF/jsp_public/list.jsp").forward(request, response);
    }
}
