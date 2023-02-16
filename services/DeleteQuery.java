package services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

public class DeleteQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Connecting to Database");
		SessionFactory factory = null;
		Session session = null;
		factory = new Configuration().
				configure("hibernate.cfg.xml").
				buildSessionFactory();
		System.out.println("Created");
		
		Transaction tx = null;
		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			Teacher teach = session.get(Teacher.class, 4);
			System.out.println("Deleting"+teach);
//			session.delete(teacher);
			session.createQuery("delete from Teacher where f_name='shalini'").
			executeUpdate();
			tx.commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			session.close();
		}
	}

}
