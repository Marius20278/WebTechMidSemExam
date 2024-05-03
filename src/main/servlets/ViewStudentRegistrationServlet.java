package servlets;

import dao.StudentRegistrationDao;
import model.StudentRegistration;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewStudentRegistrationServlet extends HttpServlet {
    private StudentRegistrationDao studentRegistrationDao;

    public void init() {
        studentRegistrationDao = new StudentRegistrationDao(HibernateUtil.getSessionFactory());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<StudentRegistration> studentRegistrations = studentRegistrationDao.getAllStudentRegistrations();
            
            request.setAttribute("studentRegistrations", studentRegistrations);
            
            
            request.getRequestDispatcher("studentRegistration.jsp").forward(request, response);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Error retrieving student registrations: " + e.getMessage());
        }
    }
}
