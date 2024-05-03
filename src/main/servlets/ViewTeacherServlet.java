package servlets;

import dao.TeacherDAO;
import model.Teacher;
import util.HibernateUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewTeacherServlet extends HttpServlet {

    private TeacherDAO teacherDAO;

    public void init() {
        teacherDAO = new TeacherDAO(HibernateUtil.getSessionFactory());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teacherId = request.getParameter("id");

        Teacher teacher = teacherDAO.getTeacherById(teacherId);
        if (teacher != null) {
            request.setAttribute("teacher", teacher);
            request.getRequestDispatcher("view-teacher.jsp").forward(request, response);
        } else {
            response.getWriter().println("Teacher not found with ID: " + teacherId);
        }
    }
}
