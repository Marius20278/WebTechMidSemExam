package servlets;

import dao.UserDao;
import model.User;
import util.HibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {

        
        userDao = new UserDao(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");


        User newUser = new User(email, password, role);

        userDao.saveUser(newUser);

        response.sendRedirect("success.html");
    }
}
