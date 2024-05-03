package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import dao.CourseDao;
import dao.SemesterDao;
import dao.AcademicUnitDAO;
import model.Course;
import model.Semester;
import model.AcademicUnit;
import util.HibernateUtil;

public class SaveCourseServlet extends HttpServlet {

    private CourseDao courseDao;
    private SemesterDao semesterDao;
    private AcademicUnitDAO academicUnitDao;

    public void init() {
        courseDao = new CourseDao(HibernateUtil.getSessionFactory());
        semesterDao = new SemesterDao(HibernateUtil.getSessionFactory());
        academicUnitDao = new AcademicUnitDAO(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseId = request.getParameter("courseId");
        String courseCode = request.getParameter("courseCode");
        String courseName = request.getParameter("courseName");
        String semesterId = request.getParameter("semesterId");
        String departmentId = request.getParameter("departmentId");

        try {
            Semester semester = semesterDao.getSemesterById(semesterId);
            AcademicUnit department = academicUnitDao.getAcademicUnitById(departmentId);

            Course existingCourse = courseDao.getCourseById(courseId);
            if (existingCourse != null) {
                response.getWriter().println("Course with ID " + courseId + " already exists.");
            } else {
                Course course = new Course(courseId, courseCode, courseName, semester, department);
                courseDao.saveCourse(course);
                response.sendRedirect("course.jsp");
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Error adding course: " + e.getMessage());
        }
    }
}
