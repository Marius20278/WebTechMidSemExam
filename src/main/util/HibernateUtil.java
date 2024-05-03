package util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import dao.TeacherDAO;
import model.AcademicUnit;
import model.Course;
import model.CourseDefinition;
import model.Semester;
import model.Student;
import model.StudentRegistration;
import model.Teacher;
import model.User;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/MidProject?useSSL=false");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "123");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Course.class);
                configuration.addAnnotatedClass(Semester.class);
                configuration.addAnnotatedClass(Teacher.class);
                configuration.addAnnotatedClass(AcademicUnit.class);
                configuration.addAnnotatedClass(CourseDefinition.class);
                configuration.addAnnotatedClass(StudentRegistration.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}