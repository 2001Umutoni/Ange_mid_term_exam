package com.students.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.students.dao.CoursesDao;
import com.students.model.Courses;

@WebServlet("/CoursesServlet")
public class CoursesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CoursesServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add":
                    addCourse(request, response);
                    break;
                case "update":
                    updateCourse(request, response);
                    break;
                case "delete":
                    deleteCourse(request, response);
                    break;
                case "search":
                    searchCourse(request, response);
                    break;
                default:
                    response.sendRedirect("index.jsp");
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    private void addCourse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String courseCode = request.getParameter("courseCode");
        String courseName = request.getParameter("courseName");

        
        Courses course = new Courses();
        course.setCourse_code(courseCode);
        course.setCourse_name(courseName);

      
        CoursesDao coursesDao = new CoursesDao();
        String result = coursesDao.saveCourse(course);

        response.getWriter().write(result);
    }

    private void updateCourse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        String courseCode = request.getParameter("courseCode");
        String courseName = request.getParameter("courseName");

       
        Courses course = new Courses();
        course.setCourseId(courseId);
        course.setCourse_code(courseCode);
        course.setCourse_name(courseName);

        CoursesDao coursesDao = new CoursesDao();
        String result = coursesDao.updateCourse(course);

        response.getWriter().write(result);
    }

    private void deleteCourse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        int courseId = Integer.parseInt(request.getParameter("courseId"));

     
        CoursesDao coursesDao = new CoursesDao();
        String result = coursesDao.deleteCourse(courseId);

        response.getWriter().write(result);
    }

    private void searchCourse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        int courseId = Integer.parseInt(request.getParameter("courseId"));

      
        CoursesDao coursesDao = new CoursesDao();
        Courses course = coursesDao.search(courseId);

        if (course != null) {
           
            request.setAttribute("course", course);
            request.getRequestDispatcher("courseDetails.jsp").forward(request, response);
        } else {
            response.getWriter().write("Course not found!");
        }
    }
}
