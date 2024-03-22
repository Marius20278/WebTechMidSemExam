package com.auca.dao;

import com.auca.model.StudentCourseModel;
import com.auca.view.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentCourseDao {
    public void saveStudentCourse(StudentCourseModel studentCourse) {
        Transaction transaction = null;
        Session session = HibernateUtil.buildSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.save(studentCourse);
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

    public static List<StudentCourseModel> viewStudentCourseList() {
        List<StudentCourseModel> studentCourseList = null;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            studentCourseList = session.createQuery("from StudentCourseModel", StudentCourseModel.class).list();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace(); // Log or handle the exception
        } finally {
            session.close();
        }

        return studentCourseList;
    }

}

