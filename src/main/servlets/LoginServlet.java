package servlets;

import dao.UserDao;
import model.User;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User loggedInUser = userDao.login(email, password);

        if (loggedInUser != null) {
            request.getSession().setAttribute("user", loggedInUser);
            request.getSession().setMaxInactiveInterval(60);

            String role = loggedInUser.getRole();
            switch (role) {
                case "admin":
                    response.sendRedirect("home.html");
                    break;
                case "student":
                    response.sendRedirect("homeStudent.html");
                    break;
                case "teacher":
                    response.sendRedirect("homeTeacher.html");
                    break;
                default:
                    response.sendRedirect("home.html");
            }
        } else {
            response.sendRedirect("login.html?error=1");
        }
    }

}
