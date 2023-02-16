package services;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

public class UpdateQuery {

	public static void main(String[] args) throws Exception{
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
			Teacher teacher = session.get(Teacher.class, 2);
			System.out.println(teacher);
			System.out.println("Updating teacher");
			teacher.setF_name("sheetal");
			teacher.setEmail("sheetu@gl.com");
//			session.update(teacher);
			session.createQuery("update Teacher set email='sheetal@gl.com' where f_name='sheetal'")
			.executeUpdate();
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
