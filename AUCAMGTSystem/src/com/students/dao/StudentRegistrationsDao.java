package com.students.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.students.model.StudentRegistrations;
import com.students.util.HibernateUtil;


public class StudentRegistrationsDao {
	public StudentRegistrationsDao() {
		// 
	}

    public String saveStudentRegistration(StudentRegistrations studentRegistration) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(studentRegistration);
            transaction.commit();
        	session.close();
			return "Student Registration registered successfully";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "Failed to save Student_Registration";
        }
    }

    public String updateStudentRegistration(StudentRegistrations studentRegistration) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(studentRegistration);
            transaction.commit();
            session.close();
			return "Student Registration updated successfully";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "Failed to updated Student Registration";
        }
    }

    public String deleteStudentRegistration(StudentRegistrations studentRegistration) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            /*StudentRegistrations studentRegistration = session.get(StudentRegistrations.class, id);
            if (studentRegistration != null) {
                session.delete(studentRegistration);
                System.out.println("Successfully deleted a student registration");*/
                session.delete( studentRegistration);
    			transaction.commit();
    			session.close();
    			return "Student Registration deleted successfully";
    		} catch (Exception e) {
    			if (transaction != null) {
    				transaction.rollback();
    			}
    			e.printStackTrace();
    		}
    		return "Failed to deleted Student Registration";
    	}
    	
    	// Method to search StudentRegistration
    	public StudentRegistrations search(int regid) {
    	    try (Session ss = HibernateUtil.getSessionFactory().getCurrentSession()){
    	        Transaction tx = ss.beginTransaction();
    	        StudentRegistrations registration = ss.get(StudentRegistrations.class, regid);
    	        tx.commit();
    	        return registration;
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	        return null;
    	    }
    	}

}
