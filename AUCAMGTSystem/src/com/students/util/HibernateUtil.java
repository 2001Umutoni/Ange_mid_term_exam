package com.students.util;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		try {
		
			Configuration configuration = new Configuration();

			
			configuration.configure("hibernate.cfg.xml");

		
			sessionFactory = configuration.buildSessionFactory();
		} catch (Throwable ex) {
			
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void exit() {
		sessionFactory.close();
	}

	
			
		
	
	public static void main(String[] args) {
		getSessionFactory();
		 
		exit();

	}

	public HibernateUtil() {
		// TODO Auto-generated constructor stub
	}

}
