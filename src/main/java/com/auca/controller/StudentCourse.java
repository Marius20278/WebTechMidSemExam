package com.auca.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auca.dao.CourseDao;
import com.auca.dao.StudentCourseDao;
import com.auca.model.CourseModel;
import com.auca.model.StudentCourseModel;

@WebServlet("/StudentCourse")
public class StudentCourse extends HttpServlet {
    private static final long serialVersionUID = 1L;

    static {
        try {
            // Load the MySQL JDBC driver (you should specify the correct driver class)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public StudentCourse() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests if needed
        // For example, you can display a form for input
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve form parameters
            int ID = Integer.parseInt(request.getParameter("ID"));
            String studentID = request.getParameter("studentID");
            String courseID = request.getParameter("courseID");
            int credits = Integer.parseInt(request.getParameter("credits"));
            double results = Double.parseDouble(request.getParameter("results"));

            // Create a StudentCourseModel object
            StudentCourseModel studentCourse = new StudentCourseModel();
            studentCourse.setID(ID);
            studentCourse.setStudentID(studentID);
            studentCourse.setCourseID(courseID);
            studentCourse.setCredits(credits);
            studentCourse.setResults(results);

            // Create a StudentCourseDao instance and save the student course
            StudentCourseDao studentCourseDao = new StudentCourseDao();
            studentCourseDao.saveStudentCourse(studentCourse);

            List<StudentCourseModel> studentCourseList = StudentCourseDao.viewStudentCourseList();
            request.setAttribute("studentCourseList", studentCourseList); // Set the attribute
           
            request.getRequestDispatcher("studentcourse.jsp").forward(request, response);

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
