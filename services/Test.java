package services;

import java.sql.Connection;

import java.sql.DriverManager;
import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Connecting to database");
		SessionFactory factory = null;
		Session session = null;
		List<Teacher> teacher =  null;
		try {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
		System.out.println("created");
		
		Teacher t1 = new Teacher("Shalini", "Garg", "shalini@gmail.com");
		Teacher t2 = new Teacher("paras", "Garg", "p.garg@gmail.com");
		Teacher t3 = new Teacher("mahima", "sharma", "mahima@gmail.com");
		Teacher t4 = new Teacher("anusha", "ariga", "ariga@gmail.com");
		
		session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		teacher = session.createQuery("from Teacher").list();
			
			tx.commit();
		}
		catch(Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		for(Teacher teachers:teacher) 
			System.out.println("teacher"+teacher);
		
		
		

	}

}
