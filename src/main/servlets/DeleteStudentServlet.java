package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import util.HibernateUtil;

import java.io.IOException;

public class DeleteStudentServlet extends HttpServlet {
    private StudentDao studentDao;

    public void init() {
        studentDao = new StudentDao(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        
        try {
            studentDao.deleteStudent(studentId);
            
            request.getRequestDispatcher("/student.jsp").forward(request, response);
        } catch (Exception e) {
            response.setContentType("text/html;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Error deleting student: " + e.getMessage());
        }
    }
}
