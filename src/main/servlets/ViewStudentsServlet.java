package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StudentDao;
import model.Student;
import util.HibernateUtil;
import java.io.IOException;
import java.util.List;

public class ViewStudentsServlet extends HttpServlet {
    private StudentDao studentDao;

    public void init() {
        studentDao = new StudentDao(HibernateUtil.getSessionFactory());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Student> students = studentDao.getAllStudents();
            
            ObjectMapper mapper = new ObjectMapper();
            String jsonStudents = mapper.writeValueAsString(students);
            
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonStudents);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Error viewing students: " + e.getMessage());
        }
    }
}
