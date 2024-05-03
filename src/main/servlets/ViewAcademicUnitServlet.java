package servlets;

import dao.AcademicUnitDAO;
import model.AcademicUnit;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewAcademicUnitServlet extends HttpServlet {

    private AcademicUnitDAO academicUnitDAO;

    public void init() {
        academicUnitDAO = new AcademicUnitDAO(HibernateUtil.getSessionFactory());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AcademicUnit> academicUnits = academicUnitDAO.getAllAcademicUnits();
        request.setAttribute("academicUnits", academicUnits);
        request.getRequestDispatcher("/view_academic_units.jsp").forward(request, response);
    }
}
