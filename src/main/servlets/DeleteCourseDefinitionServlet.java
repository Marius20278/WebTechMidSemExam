package servlets;

import dao.CourseDefinitionDAO;
import model.CourseDefinition;
import util.HibernateUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCourseDefinitionServlet extends HttpServlet {

    private CourseDefinitionDAO courseDefinitionDAO;

    public void init() {
        courseDefinitionDAO = new CourseDefinitionDAO(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseDefinitionId = request.getParameter("courseDefinitionId");

        CourseDefinition courseDefinition = courseDefinitionDAO.getCourseDefinitionById(courseDefinitionId);
        if (courseDefinition != null) {
            courseDefinitionDAO.deleteCourseDefinition(courseDefinition);
            response.sendRedirect(request.getContextPath() + "/courseDefinition.jsp?action=view");
        } else {
            response.getWriter().println("Course Definition not found with ID: " + courseDefinitionId);
        }
    }
}
