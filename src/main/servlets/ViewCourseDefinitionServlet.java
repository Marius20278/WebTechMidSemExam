package servlets;

import dao.CourseDefinitionDAO;
import model.CourseDefinition;
import util.HibernateUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewCourseDefinitionServlet extends HttpServlet {

    private CourseDefinitionDAO courseDefinitionDAO;

    public void init() {
        courseDefinitionDAO = new CourseDefinitionDAO(HibernateUtil.getSessionFactory());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseDefinitionId = request.getParameter("id");

        CourseDefinition courseDefinition = courseDefinitionDAO.getCourseDefinitionById(courseDefinitionId);
        if (courseDefinition != null) {
            request.setAttribute("courseDefinition", courseDefinition);
            request.getRequestDispatcher("view-course-definition.jsp").forward(request, response);
        } else {
            response.getWriter().println("Course Definition not found with ID: " + courseDefinitionId);
        }
    }
}
