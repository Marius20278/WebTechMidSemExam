package com.auca.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.auca.model.DepartmentModel;

import com.auca.view.HibernateUtil;

public class DepartmentDao {
	  public void saveDepartment(DepartmentModel department) {
	        Transaction transaction = null;
	        Session session = HibernateUtil.buildSessionFactory().openSession();

	        try {
	            transaction = session.beginTransaction();
	            session.save(department);
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

	  public static List<DepartmentModel> viewDepartmentList() {
	        List<DepartmentModel> departmentList = null;
	        Transaction transaction = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            transaction = session.beginTransaction();
	            departmentList = session.createQuery("from DepartmentModel", DepartmentModel.class).list();
	            transaction.commit();
	        } catch (Exception ex) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            ex.printStackTrace();
	        } finally {
	            session.close();
	        }

	        return departmentList;
	    }
}
