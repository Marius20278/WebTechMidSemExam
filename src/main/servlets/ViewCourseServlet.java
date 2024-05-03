package servlets;


import dao.CourseDao;
import model.Course;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewCourseServlet extends HttpServlet {

    private CourseDao courseDao;

    public void init() {
        courseDao = new CourseDao(HibernateUtil.getSessionFactory());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseId = request.getParameter("id");

        Course course = courseDao.getCourseById(courseId);
        if (course != null) {
            request.setAttribute("course", course);
            request.getRequestDispatcher("course.html").forward(request, response);
        } else {
            response.getWriter().println("Course not found with ID: " + courseId);
        }
    }
}

