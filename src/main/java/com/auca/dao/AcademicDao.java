package com.auca.dao;

import com.auca.model.AcademicModel;
import com.auca.view.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AcademicDao {
    public void saveAcademic(AcademicModel academic) {
        Transaction transaction = null;
        Session session = HibernateUtil.buildSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.save(academic);
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

    public static List<AcademicModel> viewAcademicList() {
        List<AcademicModel> academicList = null;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            academicList = session.createQuery("from AcademicModel", AcademicModel.class).list();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace(); // Log or handle the exception
        } finally {
            session.close();
        }

        return academicList;
    }
}
