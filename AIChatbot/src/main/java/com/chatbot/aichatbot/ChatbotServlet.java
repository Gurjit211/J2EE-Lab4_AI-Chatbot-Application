package com.chatbot.aichatbot;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/chatbot")
public class ChatbotServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Session session;

    @Override
    public void init() throws ServletException {
        session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        String userQuery = request.getParameter("userQuery");
        String botResponse = generateResponse(userQuery);  // Simulated AI response

        // Save to database
        Transaction tx = session.beginTransaction();
        Conversation conversation = new Conversation();
        conversation.setUserQuery(userQuery);
        conversation.setChatbotResponse(botResponse);
        session.save(conversation);
        tx.commit();

        // Create JSON response
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("userQuery", userQuery);
        jsonResponse.put("chatbotResponse", botResponse);

        out.print(jsonResponse);
        out.flush();
    }

    @Override
    public void destroy() {
        session.close();
    }

    // Simulated AI response generator
    private String generateResponse(String query) {
        if (query.toLowerCase().contains("hello")) {
            return "Hello! How can I help you today?";
        } else if (query.toLowerCase().contains("bye")) {
            return "Goodbye! Have a great day!";
        } 
        else {
            return "I'm not sure how to respond to that. Can you rephrase?";
        }
    }
}
