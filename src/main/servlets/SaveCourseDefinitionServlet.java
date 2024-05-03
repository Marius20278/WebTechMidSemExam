package servlets;

import dao.CourseDefinitionDAO;
import model.CourseDefinition;
import util.HibernateUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveCourseDefinitionServlet extends HttpServlet {

    private CourseDefinitionDAO courseDefinitionDAO;

    public void init() {
        courseDefinitionDAO = new CourseDefinitionDAO(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseDefinitionId = request.getParameter("courseDefinitionId");
        String courseDefinitionCode = request.getParameter("courseDefinitionCode");
        String courseDefinitionDescription = request.getParameter("courseDefinitionDescription");

        CourseDefinition existingCourseDefinition = courseDefinitionDAO.getCourseDefinitionById(courseDefinitionId);
        if (existingCourseDefinition != null) {
            response.getWriter().println("Course Definition with ID " + courseDefinitionId + " already exists.");
        } else {
            CourseDefinition courseDefinition = new CourseDefinition(courseDefinitionId, courseDefinitionCode, courseDefinitionDescription);
            courseDefinitionDAO.saveCourseDefinition(courseDefinition);
            response.sendRedirect(request.getContextPath() + "/courseDefinition.jsp?action=view");
        }
    }
}
