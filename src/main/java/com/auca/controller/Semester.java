package com.auca.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import com.auca.model.SemesterModel;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


import com.auca.dao.SemesterDao;/**
 * Servlet implementation class Student
 */
@WebServlet("/Semester")
public class Semester extends HttpServlet {
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
    public Semester() {
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
			 String id = request.getParameter("id");
			 String name = request.getParameter("name");
			 String startDateString = request.getParameter("startDate");
			 String endDateString = request.getParameter("endDate");

			 LocalDate startDate = null;
			 LocalDate endDate = null;

			 try {
			     startDate = LocalDate.parse(startDateString);
			     endDate = LocalDate.parse(endDateString);
			 } catch (DateTimeParseException e) {
			     // Handle the parsing error here
			 }

			 // Create a SemesterModel object
			 SemesterModel semester = new SemesterModel();
			 semester.setId(id);
			 semester.setName(name);

			 if (startDate != null && endDate != null) {
			     semester.setStartDate(startDate);
			     semester.setEndDate(endDate);
			 } else {
			     // Handle the case where date parsing failed
			 }


		        // Create a StudentDao instance and save the student
		        SemesterDao semesterDao = new SemesterDao();
		        semesterDao.saveSemester(semester);

		        // Retrieve the list of students from the DAO
		        List<SemesterModel> semesterList = semesterDao.viewSemesterList();

		        // Set the list as an attribute in the request
		        request.setAttribute("semesterList", semesterList);

		        // Forward the request to a JSP page for displaying the list
		        request.getRequestDispatcher("semester.jsp").forward(request, response);
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




