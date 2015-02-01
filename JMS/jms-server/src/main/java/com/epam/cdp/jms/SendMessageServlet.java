package com.epam.cdp.jms;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(description = "Send Message Servlet", urlPatterns = {"/SendMessageServlet", "/SendMessageServlet.do"})
public class SendMessageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        try {
            TopicPublisher topicPublisher = PublisherUtil.getTopicPublisher();
            TopicSession topicSession = PublisherUtil.getTopicSession();
            TextMessage tm = topicSession.createTextMessage(message);
            topicPublisher.publish(tm);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/InputMessageServlet.do").forward(request, response);
    }
}
