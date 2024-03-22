package com.auca.controller;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import com.auca.model.AcademicModel;
import com.auca.model.EAcademicUnit;
import com.auca.model.RegistrationModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


import com.auca.dao.AcademicDao;
import com.auca.dao.RegistrationDao;
/**
 * Servlet implementation class Student
 */
@WebServlet("/StudentByCourseAndSemester")
public class StudentByCourseAndSemester extends HttpServlet {
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
    public StudentByCourseAndSemester() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
		        // Retrieve the course_id and semester_id parameters from the request
		        String course_id = request.getParameter("course_id");
		        String semester_id = request.getParameter("semester_id");

		        // Create a RegistrationDao instance and retrieve the list of students for the specified course and semester
		        RegistrationDao registrationDao = new RegistrationDao();
		        List<RegistrationModel> cregistrationList = registrationDao.viewStudentsByCourseAndSemester(course_id, semester_id);

		        // Set the attribute for the list of students
		        request.setAttribute("cregistrationList", cregistrationList);

		        // Forward the request and response to the sregistration.jsp page
		        request.getRequestDispatcher("sregistration.jsp").forward(request, response);
		    } catch (Exception e) {
		        e.printStackTrace();

		        response.setContentType("text/html");
		        PrintWriter out = response.getWriter();
		        out.println("<html><body>");
		        out.println("<h2>Error Occurred</h2>");
		        out.println("<p>An error occurred while processing your request. Please try again later.</p>");
		        out.println("<p>Error Message: " + e.getMessage() + "</p>");
		        out.println("</body></html>");
		    }
	    }
}