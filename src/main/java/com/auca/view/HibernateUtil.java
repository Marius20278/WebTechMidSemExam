package com.auca.view;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


import com.auca.model.AcademicModel;
import com.auca.model.CDefinitionModel;
import com.auca.model.CourseModel;
import com.auca.model.DepartmentModel;
import com.auca.model.EAcademicUnit;
import com.auca.model.EQualification;
import com.auca.model.RegistrationModel;
import com.auca.model.SemesterModel;
import com.auca.model.StudentCourseModel;
import com.auca.model.StudentModel;
import com.auca.model.TeacherModel;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory buildSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/userdb?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, ""); 
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.addPackage("com.auca.model");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(StudentModel.class);
                configuration.addAnnotatedClass(AcademicModel.class);
                configuration.addAnnotatedClass(SemesterModel.class);
                configuration.addAnnotatedClass(DepartmentModel.class);
                configuration.addAnnotatedClass(CourseModel.class);
                configuration.addAnnotatedClass(StudentCourseModel.class);
                configuration.addAnnotatedClass(RegistrationModel.class);
               configuration.addAnnotatedClass(EAcademicUnit.class);
               configuration.addAnnotatedClass(EQualification.class);
               configuration.addAnnotatedClass(TeacherModel.class);
               configuration.addAnnotatedClass(CDefinitionModel.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            buildSessionFactory();
        }
        return sessionFactory;
    }
}
