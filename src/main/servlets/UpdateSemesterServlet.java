package servlets;

import dao.SemesterDao;
import model.Semester;
import util.HibernateUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateSemesterServlet extends HttpServlet {

    private SemesterDao semesterDao;

    public void init() {
        semesterDao = new SemesterDao(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String semesterId = request.getParameter("semesterId");
        String semesterName = request.getParameter("semesterName");
        String startingDateStr = request.getParameter("startingDate");
        String endDateStr = request.getParameter("endDate");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            if (semesterId == null || semesterId.isEmpty()) {
                throw new IllegalArgumentException("Semester ID is null or empty.");
            }

            Date startingDate = formatter.parse(startingDateStr);
            Date endDate = formatter.parse(endDateStr);

            Semester semester = new Semester(semesterId, semesterName, startingDate, endDate);
            semesterDao.updateSemester(semester);

            response.sendRedirect("semester.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error updating semester: " + e.getMessage());
        }
    }
}
