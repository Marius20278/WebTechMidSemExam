package dao;

import model.Student;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.Query;
import java.util.List;

public class StudentDao {

    private final SessionFactory sessionFactory;

    public StudentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Student getStudentById(String studentId) {
        Student student = null;
        try (Session session = sessionFactory.openSession()) {
            student = session.get(Student.class, studentId);
            if (student != null && student.getRegistrations() != null) {
                Hibernate.initialize(student.getRegistrations()); // Initialize lazy collection
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }


    public List<Student> getAllStudents() {
        List<Student> students = null;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM Student", Student.class);
            students = query.getResultList();
            for (Student student : students) {
                if (student.getRegistrations() != null) {
                    Hibernate.initialize(student.getRegistrations()); // Initialize lazy collection
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }


    public void updateStudent(Student student) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteStudent(String studentId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                session.delete(student);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
