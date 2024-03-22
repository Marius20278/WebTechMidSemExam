package com.auca.dao;

import com.auca.model.TeacherModel;
import com.auca.view.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TeacherDao {
    public void saveTeacher(TeacherModel teacher) {
        Transaction transaction = null;
        Session session = HibernateUtil.buildSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.save(teacher);
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

    public static List<TeacherModel> viewTeacherList() {
        List<TeacherModel> teacherList = null;
        Transaction transaction = null;
        Session session = HibernateUtil.buildSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            teacherList = session.createQuery("from TeacherModel", TeacherModel.class).list();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace(); // Log or handle the exception
        } finally {
            session.close();
        }

        return teacherList;
    }
}
