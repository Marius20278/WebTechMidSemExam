package servlets;


import dao.SemesterDao;
import model.Semester;
import util.HibernateUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewSemesterServlet extends HttpServlet {

    private SemesterDao semesterDao;

    public void init() {
        semesterDao = new SemesterDao(HibernateUtil.getSessionFactory());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String semesterId = request.getParameter("id");

        Semester semester = semesterDao.getSemesterById(semesterId);
        if (semester != null) {
            request.setAttribute("semester", semester);
            request.getRequestDispatcher("view-semester.jsp").forward(request, response);
        } else {
            response.getWriter().println("Semester not found with ID: " + semesterId);
        }
    }
}
