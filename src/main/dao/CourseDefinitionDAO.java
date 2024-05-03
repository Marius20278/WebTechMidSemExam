package dao;

import model.CourseDefinition;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class CourseDefinitionDAO {

    private final SessionFactory sessionFactory;

    public CourseDefinitionDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveCourseDefinition(CourseDefinition courseDefinition) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(courseDefinition);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateCourseDefinition(CourseDefinition courseDefinition) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(courseDefinition);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteCourseDefinition(CourseDefinition courseDefinition) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(courseDefinition);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public CourseDefinition getCourseDefinitionById(String courseDefinitionId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(CourseDefinition.class, courseDefinitionId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CourseDefinition> getAllCourseDefinitions() {
        try (Session session = sessionFactory.openSession()) {
            Query<CourseDefinition> query = session.createQuery("FROM CourseDefinition", CourseDefinition.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
