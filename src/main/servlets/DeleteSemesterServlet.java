package servlets;


import dao.SemesterDao;
import model.Semester;
import util.HibernateUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteSemesterServlet extends HttpServlet {

    private SemesterDao semesterDao;

    public void init() {
        semesterDao = new SemesterDao(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String semesterId = request.getParameter("semesterId");

        Semester semester = semesterDao.getSemesterById(semesterId);
        if (semester != null) {
            semesterDao.deleteSemester(semester);
            response.sendRedirect("semester.jsp");
        } else {
            response.getWriter().println("Semester not found with ID: " + semesterId);
        }
    }
}
