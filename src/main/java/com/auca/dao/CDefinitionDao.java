package com.auca.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.auca.model.CDefinitionModel;

import com.auca.view.HibernateUtil;

public class CDefinitionDao {
	  public void saveCourseDefinition(CDefinitionModel cdefinition) {
	        Transaction transaction = null;
	        Session session = HibernateUtil.buildSessionFactory().openSession();

	        try {
	            transaction = session.beginTransaction();
	            session.save(cdefinition);
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

	    public static List<CDefinitionModel> viewCourseDefinitionList() {
	        List<CDefinitionModel> coursedefinitionList = null;
	        Transaction transaction = null;
	        Session session = HibernateUtil.buildSessionFactory().openSession();

	        try {
	            transaction = session.beginTransaction();
	            coursedefinitionList = session.createQuery("from CDefinitionModel", CDefinitionModel.class).list();
	            transaction.commit();
	        } catch (Exception ex) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            ex.printStackTrace(); // Log or handle the exception
	        } finally {
	            session.close();
	        }

	        return coursedefinitionList;
	    }
}
