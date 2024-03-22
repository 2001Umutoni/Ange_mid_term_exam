package com.students.server;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.students.dao.Student_User_Dao;
import com.students.model.Student_Users;

@WebServlet("/createAccount")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Student_User_Dao userDao = new Student_User_Dao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        saveUser(req, res);
    }

    public void saveUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String role = req.getParameter("role");
            
            Student_Users user = new Student_Users();
            user.setEmail(email);
            user.setPassword(password);
            user.setRole(role);
            
            userDao.saveUser(user);
            
            // Redirect to login page after successful registration
            req.getRequestDispatcher("login.jsp").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exceptions here
            req.getRequestDispatcher("signup.jsp").forward(req, res);
        }
    }
}
