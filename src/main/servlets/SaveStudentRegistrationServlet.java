package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List; // Import List
import dao.StudentRegistrationDao;
import dao.StudentDao;
import dao.SemesterDao;
import dao.AcademicUnitDAO;
import model.StudentRegistration;
import model.Student;
import model.Semester;
import model.AcademicUnit;
import util.HibernateUtil;

public class SaveStudentRegistrationServlet extends HttpServlet {
    private StudentRegistrationDao studentRegistrationDao;
    private StudentDao studentDao;
    private SemesterDao semesterDao;
    private AcademicUnitDAO academicUnitDao;

    public void init() {
        studentRegistrationDao = new StudentRegistrationDao(HibernateUtil.getSessionFactory());
        studentDao = new StudentDao(HibernateUtil.getSessionFactory());
        semesterDao = new SemesterDao(HibernateUtil.getSessionFactory());
        academicUnitDao = new AcademicUnitDAO(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String registrationId = request.getParameter("registrationId");
        String registrationCode = request.getParameter("registrationCode");
        String registrationDateStr = request.getParameter("registrationDate");
        String studentId = request.getParameter("studentId");
        String semesterId = request.getParameter("semesterId");
        String departmentId = request.getParameter("departmentId");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date registrationDate = formatter.parse(registrationDateStr);

            Student student = studentDao.getStudentById(studentId);
            Semester semester = semesterDao.getSemesterById(semesterId);
            AcademicUnit department = academicUnitDao.getAcademicUnitById(departmentId);

            StudentRegistration studentRegistration = new StudentRegistration(registrationId, registrationCode, registrationDate, student, semester, department);

            studentRegistrationDao.saveStudentRegistration(studentRegistration);

            List<StudentRegistration> studentRegistrations = studentRegistrationDao.getAllStudentRegistrations();
            request.setAttribute("studentRegistrations", studentRegistrations);

            request.getRequestDispatcher("studentRegistration.jsp").forward(request, response);

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Error adding student registration: " + e.getMessage());
        }
    }
}
