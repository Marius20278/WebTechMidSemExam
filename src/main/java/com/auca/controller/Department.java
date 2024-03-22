package com.auca.controller;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import com.auca.model.DepartmentModel;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


import com.auca.dao.DepartmentDao;
/**
 * Servlet implementation class Student
 */
@WebServlet("/Department")
public class Department extends HttpServlet {
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
    public Department() {
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
		        String id = request.getParameter("ID");
		        String AcademicUnitID = request.getParameter("AcademicUnitID");
		        String DepartmentName = request.getParameter("DepartmentName");

		        // Create a DepartmentModel object
		        DepartmentModel department = new DepartmentModel();
		        department.setID(id);
		        department.setAcademicUnitID(AcademicUnitID);
		        department.setDepartmentName(DepartmentName);

		        // Create a DepartmentDao instance and save the department
		        DepartmentDao departmentDao = new DepartmentDao();
		        departmentDao.saveDepartment(department);

		        List<DepartmentModel> departmentList = DepartmentDao.viewDepartmentList();
			    request.setAttribute("departmentList", departmentList); // Set the attribute
			 

			    request.getRequestDispatcher("department.jsp").forward(request, response); 
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