package dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.StudentRegistration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class StudentRegistrationDao {

    private final SessionFactory sessionFactory;

    public StudentRegistrationDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveStudentRegistration(StudentRegistration studentRegistration) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(studentRegistration);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<StudentRegistration> getAllStudentRegistrations() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<StudentRegistration> criteria = builder.createQuery(StudentRegistration.class);
            criteria.from(StudentRegistration.class);
            return session.createQuery(criteria).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateStudentRegistration(StudentRegistration studentRegistration) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(studentRegistration);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteStudentRegistration(StudentRegistration studentRegistration) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(studentRegistration);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public StudentRegistration getStudentRegistrationById(String registrationId) {
        try (Session session = sessionFactory.openSession()) {
            StudentRegistration studentRegistration = session.get(StudentRegistration.class, registrationId);
            if (studentRegistration != null) {
                Hibernate.initialize(studentRegistration.getStudent());
            }
            return studentRegistration;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
