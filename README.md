AI Chatbot Web Application
Overview
This project is an AI Chatbot Web Application built using the Model-View-Controller (MVC) architecture. It is developed in Java with Jakarta EE, deployed on Apache Tomcat 10, and uses a MySQL database for persistent storage. The application ensures a clean separation of concerns and provides a scalable foundation for future enhancements.

Features
Interactive chatbot interface

User registration and authentication

Conversation logging and retrieval

RESTful web services for frontend-backend communication

Clear MVC architecture for maintainability

Technologies
Java (Servlets, JSP, JDBC)

Jakarta EE

Apache Tomcat 10

Maven

MySQL

HTML, CSS, JavaScript

Project Structure
Model
Handles data representation and business logic.

Conversation.java
Defines chatbot logic for processing user input and generating responses.

View
Frontend components.

index.html — Main chatbot interface.

style.css — Styles the chat interface.

script.js — Manages client-side logic, AJAX requests, and UI updates.

Controller
Manages the flow of the application.

ChatbotServlet.java — Handles HTTP requests, invokes chatbot logic, and returns responses.

RESTful endpoints under com.chatbot.aichatbot.resources package.

Database
Configured with JDBC. Connection details are defined in beans.xml and web.xml inside the WEB-INF directory.

Tables:

users

id (INT, Primary Key, Auto Increment)

username (VARCHAR)

password (VARCHAR)

email (VARCHAR)

conversations

id (INT, Primary Key, Auto Increment)

user_id (INT, Foreign Key referencing users.id)

message (TEXT)

response (TEXT)

timestamp (DATETIME)
