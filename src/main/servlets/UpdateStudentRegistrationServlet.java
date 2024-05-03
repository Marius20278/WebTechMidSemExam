package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.AcademicUnitDAO;
import dao.SemesterDao;
import dao.StudentDao;
import dao.StudentRegistrationDao;
import model.StudentRegistration;
import util.HibernateUtil;

public class UpdateStudentRegistrationServlet extends HttpServlet {
    private StudentRegistrationDao studentRegistrationDao;
    private AcademicUnitDAO academicUnitDAO;
    private SemesterDao semesterDao;
    private StudentDao studentDao;
    

    public void init() {
        studentRegistrationDao = new StudentRegistrationDao(HibernateUtil.getSessionFactory());
        academicUnitDAO = new AcademicUnitDAO(HibernateUtil.getSessionFactory());
        semesterDao = new SemesterDao(HibernateUtil.getSessionFactory());
        studentDao = new StudentDao(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String registrationId = request.getParameter("registrationId");
        String registrationCode = request.getParameter("registrationCode");
        String registrationDateStr = request.getParameter("registrationDate");
        String studentId = request.getParameter("studentId");
        String semesterId = request.getParameter("semesterId");
        String departmentId = request.getParameter("departmentId");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Semester Id = " + semesterId);
        try {
            Date registrationDate = formatter.parse(registrationDateStr);
            
            StudentRegistration studentRegistration = studentRegistrationDao.getStudentRegistrationById(registrationId);
             
            
            if (studentRegistration != null) {
                studentRegistration.setRegistrationCode(registrationCode);
                studentRegistration.setRegistrationDate(registrationDate);
                studentRegistration.setDepartment(academicUnitDAO.getAcademicUnitById(departmentId));
                studentRegistration.setSemester(semesterDao.getSemesterById(semesterId));
                studentRegistration.setStudent(studentDao.getStudentById(studentId));
                
                studentRegistrationDao.updateStudentRegistration(studentRegistration);
                
                response.sendRedirect(request.getContextPath() + "/viewStudentRegistration");
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().println("Student registration with ID: " + registrationId + " not found");
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            e.printStackTrace();
            response.getWriter().println("Error updating student registration: " + e.getMessage());
        }
    }
}
