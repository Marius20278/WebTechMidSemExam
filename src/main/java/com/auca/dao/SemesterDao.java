package com.auca.dao;

import com.auca.model.SemesterModel; // Import SemesterModel
import com.auca.view.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SemesterDao { // Rename the class to SemesterDao
    public void saveSemester(SemesterModel semester) { // Change method name and parameter
        Transaction transaction = null;
        Session session = HibernateUtil.buildSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.save(semester);
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

    public List<SemesterModel> viewSemesterList() { // Change method name and return type
        List<SemesterModel> semesterList = null;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            semesterList = session.createQuery("from SemesterModel", SemesterModel.class).list(); // Update entity name
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace(); // Log or handle the exception
        } finally {
            session.close();
        }

        return semesterList;
    }
}
