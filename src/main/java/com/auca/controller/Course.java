package com.auca.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import com.auca.model.CourseModel;
import com.auca.dao.CourseDao;

@WebServlet("/Course")
public class Course extends HttpServlet {
    private static final long serialVersionUID = 1L;

    static {
        try {
            // Load the MySQL JDBC driver (you should specify the correct driver class)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Course() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve form parameters
            String id = request.getParameter("id");
            String student_id = request.getParameter("student_id");
            String academic_unit_id = request.getParameter("academic_unit_id");
            String teacherID = request.getParameter("teacherID");
            String semester = request.getParameter("semester");
            String courseDefinitionID = request.getParameter("coursedefinitionid");

            // Create a CourseModel object
            CourseModel course = new CourseModel();
            course.setId(id);
            course.setStudent_id(student_id);
            course.setAcademic_unit_id(academic_unit_id);
            course.setTeacherID(teacherID);
            course.setSemester(semester);
            course.setCoursedefinitionid(courseDefinitionID);

            // Create a CourseDao instance and save the course
            CourseDao courseDao = new CourseDao();
            courseDao.saveCourse(course);

            List<CourseModel> courseList = CourseDao.viewCourseList();
            request.setAttribute("courseList", courseList); // Set the attribute

            request.getRequestDispatcher("course.jsp").forward(request, response);
        } catch (Exception e) {
            // Handle the exception - You can log it or show an error message
            e.printStackTrace(); // Log the exception

            // Specify an error message in the response
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Error Occurred</h2>");
            out.println("<p>An error occurred while processing your request. Please try again later.</p>");
            out.println("<p>Error Message: " + e.getMessage() + "</p>"); // Display the exception message
            out.println("</body></html>");
        }
    }
}
