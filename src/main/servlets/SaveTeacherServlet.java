package servlets;

import dao.TeacherDAO;
import model.Teacher;
import util.HibernateUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveTeacherServlet extends HttpServlet {

    private TeacherDAO teacherDAO;

    public void init() {
        teacherDAO = new TeacherDAO(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teacherId = request.getParameter("teacherId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String qualification = request.getParameter("qualification");
        String courseId = request.getParameter("courseId");

        try {
            Teacher existingTeacher = teacherDAO.getTeacherById(teacherId);
            if (existingTeacher != null) {
                response.sendRedirect(request.getContextPath() + "/teacher?action=duplicate");
            } else {
                Teacher teacher = new Teacher(teacherId, firstName, lastName, qualification, null);
                teacherDAO.saveTeacher(teacher, courseId);
                response.sendRedirect(request.getContextPath() + "/teacher.jsp?status=success");
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Error saving teacher: " + e.getMessage());
            e.printStackTrace(); 
        }
    }
}
