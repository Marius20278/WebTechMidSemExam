package servlets;

import dao.AcademicUnitDAO;
import model.AcademicUnit;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateAcademicUnitServlet extends HttpServlet {

    private AcademicUnitDAO academicUnitDAO;

    public void init() {
        academicUnitDAO = new AcademicUnitDAO(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String academicId = request.getParameter("academicId");
        String academicCode = request.getParameter("academicCode");
        String academicName = request.getParameter("academicName");
        String type = request.getParameter("type");


        AcademicUnit academicUnit = academicUnitDAO.getAcademicUnitById(academicId);
        academicUnit.setAcademicCode(academicCode);
        academicUnit.setAcademicName(academicName);
        academicUnit.setType(type);


        academicUnitDAO.updateAcademicUnit(academicUnit);

        response.sendRedirect("academicUnit.jsp");
    }
}
