package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import model.Student;
import util.HibernateUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StudentServlet extends HttpServlet {
    private StudentDao studentDao;

    public void init() {
        studentDao = new StudentDao(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dateOfBirthStr = request.getParameter("dateOfBirth");
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            Date dateOfBirth = formatter.parse(dateOfBirthStr);
            
            Student student = new Student();
            student.setStudentId(studentId);
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setDateOfBirth(dateOfBirthStr);
            
            studentDao.saveStudent(student);
            
            response.setContentType("text/html;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_CREATED) ;
            
            response.getWriter().println("Stud	ent added successfully with ID: " + studentId);
            response.sendRedirect("student.jsp");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Error adding student: " + e.getMessage());
        }
    }
}
