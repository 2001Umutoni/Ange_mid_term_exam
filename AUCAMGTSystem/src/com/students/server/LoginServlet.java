package com.students.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.students.dao.Student_User_Dao;
import com.students.model.Student_Users;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Student_User_Dao userDao = new Student_User_Dao();
        Student_Users user = userDao.getUserByEmail(email, password);

        if (user != null && user.getPassword().equals(password)) {
            // Authentication successful
            request.getSession().setAttribute("user", user);
            response.sendRedirect("dashboard.jsp"); 
        } else {
            // Authentication failed
            request.setAttribute("errorMessage", "Invalid email or password");
            request.getRequestDispatcher("login.jsp").forward(request, response); 
    }
}}
