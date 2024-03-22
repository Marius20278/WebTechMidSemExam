package com.auca.dao;

import com.auca.model.RegistrationModel;
import com.auca.view.HibernateUtil;


import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RegistrationDao {
    public void saveRegistration(RegistrationModel registration) {
        Transaction transaction = null;
        Session session = HibernateUtil.buildSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.save(registration);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace(); // Log or handle the exception
        } finally {
            session.close();
        }
    }

    public static List<RegistrationModel> viewRegistrationList() {
        List<RegistrationModel> registrationList = null;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            registrationList = session.createQuery("from RegistrationModel", RegistrationModel.class).list();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace(); // Log or handle the exception
        } finally {
            session.close();
        }

        return registrationList;
    }

    public List<RegistrationModel> viewStudentsBySemester(String semester_id) {
        List<RegistrationModel> sregistrationList = null;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();

            sregistrationList = session.createQuery("FROM RegistrationModel WHERE semester_id = :semester_id", RegistrationModel.class)
                .setParameter("semester_id", semester_id) // Replace semester_id with the actual semester ID
                .list();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace(); // Log or handle the exception
        } finally {
            session.close();
        }

        return sregistrationList;
    }
    public List<RegistrationModel> viewStudentsByAcademicUnitAndSemester(String academic_unit_id, String semester_id) {
        List<RegistrationModel> dregistrationList = null;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();

            dregistrationList = session.createQuery("FROM RegistrationModel WHERE academic_unit_id = :academic_unit_id AND semester_id = :semester_id", RegistrationModel.class)
                .setParameter("academic_unit_id", academic_unit_id) // Replace academic_unit_id with the actual academic unit ID
                .setParameter("semester_id", semester_id) // Replace semester_id with the actual semester ID
                .list();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace(); // Log or handle the exception
        } finally {
            session.close();
        }

        return dregistrationList;
    }

    public List<RegistrationModel> viewStudentsByCourseAndSemester(String course_id, String semester_id) {
        List<RegistrationModel> cregistrationList = null;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();

            cregistrationList = session.createQuery("FROM RegistrationModel WHERE course_id = :course_id AND semester_id = :semester_id", RegistrationModel.class)
                .setParameter("course_id", course_id) // Replace course_id with the actual course ID
                .setParameter("semester_id", semester_id) // Replace semester_id with the actual semester ID
                .list();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace(); // Log or handle the exception
        } finally {
            session.close();
        }

        return cregistrationList;
    }


}
