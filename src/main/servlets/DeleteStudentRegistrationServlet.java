package servlets;

import dao.StudentRegistrationDao;
import model.StudentRegistration;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteStudentRegistrationServlet extends HttpServlet {

    private StudentRegistrationDao studentRegistrationDao;

    public void init() {
        studentRegistrationDao = new StudentRegistrationDao(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String registrationId = request.getParameter("registrationId");

        try {
            StudentRegistration studentRegistration = studentRegistrationDao.getStudentRegistrationById(registrationId);
            if (studentRegistration != null) {
                studentRegistrationDao.deleteStudentRegistration(studentRegistration);
                response.sendRedirect(request.getContextPath() + "/viewStudentRegistration");
            } else {
                response.getWriter().println("Student registration not found with ID: " + registrationId);
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Error deleting student registration: " + e.getMessage());
        }
    }
}
