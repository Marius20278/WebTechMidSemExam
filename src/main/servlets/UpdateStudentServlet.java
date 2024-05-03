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

public class UpdateStudentServlet extends HttpServlet {
    private StudentDao studentDao;

    public void init() {
        studentDao = new StudentDao(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dateOfBirthStr = request.getParameter("dateOfBirth");

        try {
            System.out.println("Received studentId: " + studentId);

            Student student = studentDao.getStudentById(studentId);

            System.out.println("Retrieved student: " + student);

            if (student != null) {
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setDateOfBirth(dateOfBirthStr);

                studentDao.updateStudent(student);

                response.setContentType("text/html;charset=UTF-8");
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().println("Student updated successfully");
                response.sendRedirect("student.jsp");
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().println("Student with ID " + studentId + " not found");
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Error updating student: " + e.getMessage());
        }
    }
}
