package com.auca.controller;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import com.auca.model.AcademicModel;
import com.auca.model.EAcademicUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


import com.auca.dao.AcademicDao;
/**
 * Servlet implementation class Student
 */
@WebServlet("/Academic")
public class Academic extends HttpServlet {
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
    public Academic() {
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
		        String code = request.getParameter("code");
		        String name = request.getParameter("name");
		        String academicUnitTypeStr = request.getParameter("academicUnitType");
		        EAcademicUnit academicUnitType = EAcademicUnit.valueOf(academicUnitTypeStr);
		        String parentId = request.getParameter("parentId");

		        // Create an AcademicModel object
		        AcademicModel academic = new AcademicModel();
		        academic.setCode(code);
		        academic.setName(name);
		        academic.setAcademicUnitType(academicUnitType);
		        academic.setParentId(parentId);

		        // Create an AcademicDao instance and save the academic unit
		        AcademicDao academicDao = new AcademicDao();
		        academicDao.saveAcademic(academic);

		        List<AcademicModel> academicList = AcademicDao.viewAcademicList();
			    request.setAttribute("academicList", academicList); // Set the attribute
			    request.setAttribute("academicUnitValues", EAcademicUnit.values());

			    request.getRequestDispatcher("academic.jsp").forward(request, response); 
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