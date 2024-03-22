package com.auca.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.text.ParseException;
import com.auca.model.StudentModel;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


import com.auca.dao.StudentDao;/**
 * Servlet implementation class Student
 */
@WebServlet("/Student")
public class Student extends HttpServlet {
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
    public Student() {
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
		        // Retrieve form parameters
		        String regNo = request.getParameter("regNo");
		        String firstName = request.getParameter("firstName");
		        String dateOfBirthStr = request.getParameter("dateOfBirth");

		        // Parse the date string into a java.util.Date
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        java.util.Date utilDate = dateFormat.parse(dateOfBirthStr);

		        // Convert java.util.Date to java.sql.Date
		        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		        // Create a StudentModel object
		        StudentModel student = new StudentModel();
		        student.setRegNo(regNo);
		        student.setFirstName(firstName);
		        student.setDateOfBirth(sqlDate);

		        // Create a StudentDao instance and save the student
		        StudentDao studentDao = new StudentDao();
		        studentDao.saveStudent(student);

		        // Retrieve the list of students from the DAO
		        List<StudentModel> studentList = studentDao.viewStudentList();

		        // Set the list as an attribute in the request
		        request.setAttribute("studentList", studentList);

		        // Forward the request to a JSP page for displaying the list
		        request.getRequestDispatcher("success.jsp").forward(request, response);
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




