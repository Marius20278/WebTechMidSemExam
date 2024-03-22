package com.auca.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import com.auca.model.TeacherModel;
import com.auca.model.EQualification;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


import com.auca.dao.TeacherDao;
/**
 * Servlet implementation class Student
 */
@WebServlet("/Teacher")
public class Teacher extends HttpServlet {
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
    public Teacher() {
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
		        String tutor = request.getParameter("tutor");
		        String assistant_tutor = request.getParameter("assistant_tutor");
		        String qualification = request.getParameter("qualification");
		        EQualification qualifications = EQualification.valueOf(qualification);
		       

		        // Create an AcademicModel object
		        TeacherModel teacher = new TeacherModel();
		        teacher .setCode(code);
		        teacher.setName(name);
		        teacher.setTutor(assistant_tutor);
		        teacher.setAssistant_tutor(assistant_tutor);
		        teacher.setQualification(qualifications);
		        
		      

		        // Create an AcademicDao instance and save the academic unit
		        TeacherDao teacherDao = new TeacherDao();
		        teacherDao.saveTeacher(teacher);

		        List<TeacherModel> teacherList = TeacherDao.viewTeacherList();
			    request.setAttribute("teacherList", teacherList); // Set the attribute
			    request.setAttribute("qualificationValues", EQualification.values());

			    request.getRequestDispatcher("teacher.jsp").forward(request, response); 
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