package servlets;

import dao.CourseDefinitionDAO;
import model.CourseDefinition;
import util.HibernateUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateCourseDefinitionServlet extends HttpServlet {

    private CourseDefinitionDAO courseDefinitionDAO;

    public void init() {
        courseDefinitionDAO = new CourseDefinitionDAO(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseDefinitionId = request.getParameter("courseDefinitionId");
        String courseDefinitionCode = request.getParameter("courseDefinitionCode");
        String courseDefinitionDescription = request.getParameter("courseDefinitionDescription");

        CourseDefinition courseDefinition = courseDefinitionDAO.getCourseDefinitionById(courseDefinitionId);
        if (courseDefinition != null) {
            courseDefinition.setCourseDefinitionCode(courseDefinitionCode);
            courseDefinition.setCourseDefinitionDescription(courseDefinitionDescription);

            courseDefinitionDAO.updateCourseDefinition(courseDefinition);
            response.sendRedirect(request.getContextPath() + "/courseDefinition.jsp?action=view");
        } else {
            response.getWriter().println("Course Definition not found with ID: " + courseDefinitionId);
        }
    }
}
