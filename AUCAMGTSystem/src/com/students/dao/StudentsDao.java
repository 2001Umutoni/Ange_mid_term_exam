package com.students.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.students.model.Students;
import com.students.util.*;

public class StudentsDao {

	public StudentsDao() {
		
		
	}
    public String saveStudent(Students student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            session.close();
			return "Data was inserted successfully.";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        	return "Failed to insert data.";
        }
    }

    public void updateStudent(Students student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
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

    public void deleteStudent(  Students student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            //Students student = session.get(Students.class, id);
          //  if (student != null) {
                session.delete(student);
                transaction.commit();
    			session.close();
                System.out.println("Successfully deleted a student");
         
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
public Students search(int id) {
		
		
		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {		
			return ss.get(Students.class, id);
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
		
	}
	
	//list all Students
	public List<Students> displayAll(){
		Transaction tr = null;
		List<Students> student = null;
		try (Session ss = HibernateUtil.getSessionFactory().openSession()){
			tr = ss.beginTransaction();
			student= ss.createQuery("From Students", Students.class).list();
			tr.commit();
		} catch (Exception e) {
			if(tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
		}
		return student;
	}
}
