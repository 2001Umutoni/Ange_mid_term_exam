package com.students.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.students.model.Courses;
import com.students.util.HibernateUtil;


public class CoursesDao {
	public CoursesDao() {
		
	}

    public String saveCourse(Courses course) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
            return "Course registered successfully";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "fail to registered a course";
        }
    }

    public String updateCourse(Courses course) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(course);
            transaction.commit();
            return "Course updated successfully";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "fail to update a course";
        }
    }

    public String deleteCourse(Courses course) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
           // Courses course = session.get(Courses.class, id);
            //if (course != null) {
                session.delete(course);
                return "Successfully deleted a course";
            
          
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "Failed to delete course";
        }
    }
    public Courses findById(int  courseId) {
    	try (Session ss = HibernateUtil.getSessionFactory().openSession()){
			return ss.get(Courses.class, courseId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    
    public List<Courses> selectAllCourses() {
        Transaction tr = null;
        List<Courses> courses = null;

        try (Session ss = HibernateUtil.getSessionFactory().openSession()){
            tr = ss.beginTransaction();
            courses = ss.createQuery("from Courses", Courses.class).list();
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
        }

        return courses;
    }
}
