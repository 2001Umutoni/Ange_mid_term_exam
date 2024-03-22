package com.students.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.students.model.Student_Users;
import com.students.util.HibernateUtil;
import org.hibernate.query.Query;
public class Student_User_Dao {
	

    public Student_User_Dao() {
		
		
	}

	public String saveUser(Student_Users user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            session.close();
            return" User was successfully inserted";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return " failed to insert a User";
        }
        
    }

    public String updateUser(Student_Users user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            session.close();
            session.close();
            return"  User updated successfully ";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return" User  failed to be updated  ";
        }
    }

    public String deleteUser(Student_Users user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
           /* Student_Users user = session.get(Student_Users.class, id);
            if (user != null) {*/
                session.delete(user);
                //System.out.println("Successfully deleted a User");
                transaction.commit();
            session.close();
            return" successfully deleted a User ";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return" User  failed to be deleted ";
        }
    }


    public Student_Users getUserByEmail(String email, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Query the database to get the user by email
            String sql = "FROM Student_Users WHERE email = :email";
            Query<Student_Users> query = session.createQuery(sql, Student_Users.class);

            Student_Users user = query.uniqueResult();
            session.close();

            if (user != null && user.getPassword().equals(password)) {
                return user;
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }}
