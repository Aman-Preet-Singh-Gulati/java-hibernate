package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student student1 = new Student();
		student1.setId(14135);
		student1.setName("Ankit Tiwari");
		student1.setCity("LKO");

		Certificate certificate = new Certificate();
		certificate.setCourse("Andriod");
		certificate.setDuration("2 months");
		student1.setCerti(certificate);

		Student student2 = new Student();
		student2.setId(1213);
		student2.setName("Ravi Tiwari");
		student2.setCity("DELHI");

		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Hibernate");
		certificate1.setDuration("1.5 months");
		student2.setCerti(certificate1);
		
		Student student3 = new Student();
		student3.setId(1234);
		student3.setName("Ravi Tiwari");
		student3.setCity("DELHI");

		Certificate certificate2 = new Certificate();
		certificate2.setCourse("Hibernate");
		certificate2.setDuration("1.5 months");
		student2.setCerti(certificate2);

		Session s = factory.openSession();
		
		// For physical transactions
		Transaction tx = s.beginTransaction();

		// objects save:
		s.save(student1);
		s.save(student2);
		s.save(student3);

		tx.commit();
		s.close();
		factory.close();
	}
}

