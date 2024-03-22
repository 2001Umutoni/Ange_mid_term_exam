package com.students.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.students.model.Teachers;
import com.students.util.HibernateUtil;


public class TeachersDao {
	public TeachersDao() {
		
	}
	

    public String saveTeacher(Teachers teacher) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(teacher);
            transaction.commit();
            session.close();
			return "Teacher Registered Seccussfully";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "failed to register  a Teacher";
        }
    }

    public  String updateTeacher(Teachers teacher) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(teacher);
            transaction.commit();
            session.close();
			return "Teacher Updated Seccussfully";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return " fails to   Updated Teacher ";
        }
    }

    public String deleteTeacher(Teachers teacher) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            //Teachers teacher = session.get(Teachers.class, id);
            //if (teacher != null) {
                session.delete(teacher);
                transaction.commit();
    			session.close();
    			return "Successfully deleted a teacher";
              
          
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "failed to delete Teacher";
        
    }
}
	public Teachers findById(int id) {
		try (Session ss = HibernateUtil.getSessionFactory().openSession()){
			return ss.get(Teachers.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}}