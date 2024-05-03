package servlets;

import dao.TeacherDAO;
import model.Teacher;
import util.HibernateUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteTeacherServlet extends HttpServlet {

    private TeacherDAO teacherDAO;

    public void init() {
        teacherDAO = new TeacherDAO(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teacherId = request.getParameter("teacherId");

        Teacher teacher = teacherDAO.getTeacherById(teacherId);
        if (teacher != null) {
            teacherDAO.deleteTeacher(teacher);
            response.sendRedirect(request.getContextPath() + "/teacher.jsp?action=view");
        } else {
            response.getWriter().println("Teacher not found with ID: " + teacherId);
        }
    }
}
