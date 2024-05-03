package servlets;

import dao.AcademicUnitDAO;
import model.AcademicUnit;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAcademicUnitServlet extends HttpServlet {

    private AcademicUnitDAO academicUnitDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        academicUnitDAO = new AcademicUnitDAO(HibernateUtil.getSessionFactory());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String academicId = request.getParameter("academicId");

       
        AcademicUnit academicUnit = academicUnitDAO.getAcademicUnitById(academicId);

        if (academicUnit != null) {
            academicUnitDAO.deleteAcademicUnit(academicUnit);
            response.sendRedirect("academicUnit.jsp");
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Academic unit not found with ID: " + academicId);
        }
    }
}
