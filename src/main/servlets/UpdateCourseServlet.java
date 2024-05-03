package servlets;

import dao.CourseDao;
import model.Course;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateCourseServlet extends HttpServlet {

    private CourseDao courseDAO;

    public void init() {
        courseDAO = new CourseDao(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseId = request.getParameter("courseId");
        String courseCode = request.getParameter("courseCode");
        String courseName = request.getParameter("courseName");

        if (courseId == null || courseCode == null || courseName == null ||
            courseId.isEmpty() || courseCode.isEmpty() || courseName.isEmpty()) {
            response.getWriter().println("Invalid input parameters.");
            return;
        }

        Course course = courseDAO.getCourseById(courseId);
        if (course != null) {
            course.setCourseCode(courseCode);
            course.setCourseName(courseName);

            courseDAO.updateCourse(course);
            response.sendRedirect("course.jsp");
        } else {
            response.getWriter().println("Course not found with ID: " + courseId);
        }
    }
}
