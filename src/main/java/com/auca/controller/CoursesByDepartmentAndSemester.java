package com.auca.controller;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import com.auca.model.AcademicModel;
import com.auca.model.CourseModel;
import com.auca.model.EAcademicUnit;
import com.auca.model.RegistrationModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


import com.auca.dao.AcademicDao;
import com.auca.dao.CourseDao;
import com.auca.dao.RegistrationDao;
/**
 * Servlet implementation class Student
 */
@WebServlet("/CoursesByDepartmentAndSemester")
public class CoursesByDepartmentAndSemester extends HttpServlet {
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
    public CoursesByDepartmentAndSemester() {
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
		    // Retrieve the academic_unit_id and semester_id parameters from the request
		    String academic_unit_id = request.getParameter("academic_unit_id");
		    String semester = request.getParameter("semester");

		    // Create a CourseDao instance and retrieve the list of courses for the specified academic unit and semester
		    CourseDao courseDao = new CourseDao();
		    List<CourseModel> courseList = courseDao.getCoursesByAcademicUnitAndSemester(academic_unit_id, semester);

		    // Set the attribute for the list of courses
		    request.setAttribute("courseList", courseList);

		    // Forward the request and response to a JSP page to display the list of courses
		    request.getRequestDispatcher("listcourse.jsp").forward(request, response);
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