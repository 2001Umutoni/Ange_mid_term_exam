package com.students.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.students.dao.StudentsDao;
import com.students.model.Students;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private StudentsDao dao;

    public StudentServlet() {
        this.dao = new StudentsDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String submitAction = req.getParameter("submitAction");

        switch (submitAction) {
            case "create":
                save(req, res);
                break;
            case "update":
                update(req, res);
                break;
            case "delete":
                delete(req, res);
                break;
            case "search":
                search(req, res);
                break;
            default:
                break;
        }
    }

    protected void save(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dateOfBirth = req.getParameter("dob");

        if (firstName.isEmpty() || lastName.isEmpty() || dateOfBirth.isEmpty()) {
            req.setAttribute("error", "Insert fields");
            req.getRequestDispatcher("/Student.jsp").forward(req, res);
        } else {
            Students student = new Students();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setDob(dateOfBirth);

            dao.saveStudent(student);

            req.getRequestDispatcher("/Student.jsp").forward(req, res);
        }
    }

    protected void update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String studentIdString = req.getParameter("id");

        try {
            int studentId = Integer.parseInt(studentIdString);
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String dateOfBirth = req.getParameter("dob");

            if (firstName.isEmpty() || lastName.isEmpty() || dateOfBirth.isEmpty()) {
                req.setAttribute("error", "Insert fields");
                req.getRequestDispatcher("/Student.html").forward(req, res);
            } else {
                Students student = new Students(studentId);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setDob(dateOfBirth);

                dao.updateStudent(student);

                req.getRequestDispatcher("/Student.jsp").forward(req, res);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String studentIdString = req.getParameter("id");

        try {
            int studentId = Integer.parseInt(studentIdString);

            Students student = new Students(studentId);
            dao.deleteStudent(student);

            req.getRequestDispatcher("/Student.jsp").forward(req, res);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    protected void search(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String studentIdString = req.getParameter("id");

        try {
            int studentId = Integer.parseInt(studentIdString);
            Students student = dao.search(studentId);

            if (student != null) {
                req.setAttribute("student", student);
                req.getRequestDispatcher("/Student.jsp").forward(req, res);
            } else {
                req.setAttribute("error", "Student not found");
                req.getRequestDispatcher("/Student.jsp").forward(req, res);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
