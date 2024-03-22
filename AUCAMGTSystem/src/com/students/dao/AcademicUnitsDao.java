package com.students.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.students.model.AcademicUnits;
import com.students.util.HibernateUtil;


public class AcademicUnitsDao {
	

    public AcademicUnitsDao() {
		
		// TODO Auto-generated constructor stub
	}

	public String saveAcademicUnit(AcademicUnits academicUnit) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(academicUnit);
            transaction.commit();
            session.close();
            return "Academic unit registered successfully";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "Failed to register academic unit";
        }
    }

    public String updateAcademicUnit(AcademicUnits academicUnit) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(academicUnit);
            transaction.commit();
            return "Failed to update academic unit";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "Failed to update academic unit";
        }
    }

    public String deleteAcademicUnit(  AcademicUnits academicUnit) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            //AcademicUnits academicUnit = session.get(AcademicUnits.class, id);
            //if (academicUnit != null) {
                session.delete(academicUnit);
      
            transaction.commit();
            session.close();
            return "Academic unit deleted successfully";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "Failed to delete academic unit";
        }
    }
 // Method to find an academic unit by ID
    public AcademicUnits findAcademicUnitById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(AcademicUnits.class,id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Method to display Academic Unit 
    public List<AcademicUnits> displayAll(){
    	Transaction tr = null;
    	List<AcademicUnits> AcademicUnit= null;
    	try (Session session = HibernateUtil.getSessionFactory().openSession()){
			tr = session.beginTransaction();
			AcademicUnit = session.createQuery("FROM AcademicUnits", AcademicUnits.class).list();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tr != null) {				
				tr.rollback();
			}
		}
    	return AcademicUnit;
    }
}

