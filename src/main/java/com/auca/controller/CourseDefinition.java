package com.auca.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auca.dao.CDefinitionDao;

import com.auca.model.CDefinitionModel;


/**
 * Servlet implementation class CDefinition
 */

@WebServlet("/CourseDefinition")
public class CourseDefinition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseDefinition() {
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
		        String course_code = request.getParameter("course_code");
		        String name = request.getParameter("name");
		        String description = request.getParameter("description");
		      
		        

		        // Create an AcademicModel object
		        CDefinitionModel coursedefinition = new CDefinitionModel();
		        
		        coursedefinition.setId(id);
		        coursedefinition.setCourse_code(course_code);
		        coursedefinition.setName(name);
		        coursedefinition.setDescription(description);
		      

		        // Create an AcademicDao instance and save the academic unit
		        CDefinitionDao coursedefinitionDao = new CDefinitionDao();
		        coursedefinitionDao.saveCourseDefinition(coursedefinition);

		        List<CDefinitionModel> coursedefinitionList = CDefinitionDao.viewCourseDefinitionList();
			    request.setAttribute("coursedefinitionList", coursedefinitionList); // Set the attribute
			 

			    request.getRequestDispatcher("coursedefinition.jsp").forward(request, response); 
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


