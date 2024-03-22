package com.students.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.students.model.Semesters;
import com.students.util.HibernateUtil;


public class SemestersDao {
	public SemestersDao() {
		
	}

    public String saveSemester(Semesters semester) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(semester);
            transaction.commit();
            session.close();
            return "Semester registed successfully";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "Semester not  registed successfully";
        }
    }

    public String updateSemester(Semesters semester) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(semester);
            transaction.commit();
            session.close();
            return " successfully updated semester";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "failed to update semester";
        }
    }

    public String deleteSemester(Semesters semester) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            /*Semesters semester = session.get(Semesters.class, id);
            if (semester != null) {*/
                session.delete(semester);
                transaction.commit();
    			session.close();
                return "Successfully deleted a semester";
            
          
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "Semester not deleted ";
        }
    }
    public Semesters getSemesterById(int semId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Semesters.class, semId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Method to display semesters
    public List<Semesters> displayAll(){
    	Transaction tr = null;
    	List<Semesters> semester = null;
    	try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			tr = ss.beginTransaction();
			semester = ss.createQuery("From Semesters", Semesters.class).list();
			tr.commit();
		} catch (Exception e) {
			if(tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
		}
    	return semester;
    }

}

