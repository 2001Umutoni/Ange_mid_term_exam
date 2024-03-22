package com.students.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.students.dao.CourseDefinitionDao;
import com.students.model.CourseDefinition;

@WebServlet("/CourseDefinitionServlet")
public class CourseDefinitionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CourseDefinitionServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add":
                    addCourseDefinition(request, response);
                    break;
                case "update":
                    updateCourseDefinition(request, response);
                    break;
                case "delete":
                    deleteCourseDefinition(request, response);
                    break;
                case "search":
                    searchCourseDefinition(request, response);
                    break;
                default:
                    response.sendRedirect("index.jsp");
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    private void addCourseDefinition(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String courseName = request.getParameter("courseName");
        String courseDescription = request.getParameter("courseDescription");
        int courseCredits = Integer.parseInt(request.getParameter("courseCredits"));

        CourseDefinition courseDefinition = new CourseDefinition(courseName, courseDescription, courseCredits);
        CourseDefinitionDao courseDefinitionDao = new CourseDefinitionDao();
        String result = courseDefinitionDao.saveCourseDefinition(courseDefinition);

        response.getWriter().write(result);
    }

    private void updateCourseDefinition(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        String courseName = request.getParameter("courseName");
        String courseDescription = request.getParameter("courseDescription");
        int courseCredits = Integer.parseInt(request.getParameter("courseCredits"));

        CourseDefinition courseDefinition = new CourseDefinition(courseId, courseName, courseDescription, courseCredits);
        CourseDefinitionDao courseDefinitionDao = new CourseDefinitionDao();
        String result = courseDefinitionDao.updateCourseDefinition(courseDefinition);

        response.getWriter().write(result);
    }

    private void deleteCourseDefinition(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));

        CourseDefinitionDao courseDefinitionDao = new CourseDefinitionDao();
        CourseDefinition courseDefinition = courseDefinitionDao.search(courseId);

        String result;
        if (courseDefinition != null) {
            result = courseDefinitionDao.deleteCourseDefinition(courseDefinition);
        } else {
            result = "Course Definition not found!";
        }

        response.getWriter().write(result);
    }

    private void searchCourseDefinition(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));

        CourseDefinitionDao courseDefinitionDao = new CourseDefinitionDao();
        CourseDefinition courseDefinition = courseDefinitionDao.search(courseId);

        if (courseDefinition != null) {
            
            request.setAttribute("courseDefinition", courseDefinition);
            request.getRequestDispatcher("courseDefinitionDetails.jsp").forward(request, response);
        } else {
            response.getWriter().write("Course Definition not found!");
        }
    }
}
