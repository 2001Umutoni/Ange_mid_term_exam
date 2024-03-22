package com.students.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.students.model.CourseDefinition;
import com.students.util.HibernateUtil;


public class CourseDefinitionDao {
	

    public CourseDefinitionDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String saveCourseDefinition(CourseDefinition courseDefinition) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(courseDefinition);
            transaction.commit();
            session.close();
			return "Course Definition registered successfully";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
          
			return "Course Defintion failed to be registered";
        }
    }

    public String updateCourseDefinition(CourseDefinition courseDefinition) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(courseDefinition);
            transaction.commit();
            session.close();
			return "Course Defintion updated successfully";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "Course Defintion  not updated successfully";
        }
    }

    public String deleteCourseDefinition(  CourseDefinition courseDefinition) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            //CourseDefinition courseDefinition = session.get(CourseDefinition.class, id);
           //if (courseDefinition != null) {
                session.delete(courseDefinition);
                transaction.commit();
                session.close();
               return "Successfully deleted a course definition";
           
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "failed to  deleted a course definition";
            
        }
    }
 // Search method for  Course_definition	using id 
 	public CourseDefinition search(int id) {
 		try (Session ss = HibernateUtil.getSessionFactory().openSession()){
 			return ss.get(CourseDefinition.class,id);
 		} catch (Exception e) {
 			e.printStackTrace();
 			return null;
 		}
 	}
 	
}
