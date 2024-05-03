package dao;

import model.AcademicUnit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class AcademicUnitDAO {

    private final SessionFactory sessionFactory;

    public AcademicUnitDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveAcademicUnit(AcademicUnit academicUnit) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(academicUnit);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateAcademicUnit(AcademicUnit academicUnit) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(academicUnit);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteAcademicUnit(AcademicUnit academicUnit) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(academicUnit);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public AcademicUnit getAcademicUnitById(String academicId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(AcademicUnit.class, academicId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<AcademicUnit> getAllAcademicUnits() {
        try (Session session = sessionFactory.openSession()) {
            Query<AcademicUnit> query = session.createQuery("FROM AcademicUnit", AcademicUnit.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
