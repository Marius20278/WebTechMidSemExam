package com.auca.controller;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import com.auca.model.RegistrationModel;
import com.auca.model.CourseModel;
import com.auca.model.EAcademicUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.auca.dao.CourseDao;
import com.auca.dao.RegistrationDao;
/**
 * Servlet implementation class Student
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 static {
	        try {
	            // Load the MySQL JDBC driver (you should specify the correct driver class)
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		    // Retrieve form parameters
		    String student_id = request.getParameter("student_id");
		    String course_id = request.getParameter("course_id");
		    String semester_id = request.getParameter("semester_id");
		    String id = request.getParameter("id");
		    String academic_unit_id = request.getParameter("academic_unit_id");

		    // Create a RegistrationModel object
		    RegistrationModel registration = new RegistrationModel();
		    registration.setStudent_id(student_id);
		    registration.setCourse_id(course_id);
		    registration.setSemester_id(semester_id);
		    registration.setId(id);
		    registration.setAcademic_unit_id(academic_unit_id);

		    // Create a RegistrationDao instance and save the registration
		    RegistrationDao registrationDao = new RegistrationDao();
		    registrationDao.saveRegistration(registration);

		    List<RegistrationModel> registrationList = RegistrationDao.viewRegistrationList();
            request.setAttribute("registrationList", registrationList); // Set the attribute

            request.getRequestDispatcher("registration.jsp").forward(request, response);
		    
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