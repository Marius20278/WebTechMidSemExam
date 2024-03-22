package com.auca.dao;

import com.auca.model.CourseModel;
import com.auca.view.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CourseDao {
    public void saveCourse(CourseModel course) {
        Transaction transaction = null;
        Session session = HibernateUtil.buildSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.save(course);
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

    public static List<CourseModel> viewCourseList() {
        List<CourseModel> courseList = null;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            courseList = session.createQuery("from CourseModel", CourseModel.class).list();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace(); // Log or handle the exception
        } finally {
            session.close();
        }

        return courseList;
    }
    public List<CourseModel> getCoursesByAcademicUnitAndSemester(String academic_unit_id, String semester) {
        List<CourseModel> courseList = null;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();

            // Modify the query to select courses based on academic_unit_id and semester_id
            String hql = "FROM CourseModel c WHERE c.semester.semester = :semester AND c.academic_unit_id = :academic_unit_id";

            courseList = session.createQuery(hql, CourseModel.class)
                .setParameter("semester", semester)
                .setParameter("academic_unit_id", academic_unit_id)
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

        return courseList;
    }
    public List<CourseModel> getCoursesByStudentId(String student_id) {
        List<CourseModel> coursesList = null;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();

            // Assuming you have a Many-to-Many relationship between StudentModel and CourseModel
            String hql = "FROM CourseModel c WHERE  student_id = :student_id";

            coursesList = session.createQuery(hql, CourseModel.class)
                .setParameter("student_id", student_id)
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

        return coursesList;
    }

}
