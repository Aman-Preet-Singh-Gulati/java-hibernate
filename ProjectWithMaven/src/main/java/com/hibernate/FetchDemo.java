package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	
	public static void main(String[] args) {
		
		//get , load
		
		// Get: It returns fully initialized object so this method eager load the object  
		//		It is slower than load() because it return fully initialized object which impact the performance of the application
		//      If you are not sure that object exist then use get() method 
		//
		// Load: It always returns PROXY object so this method is lazy load the object  
		//       It is slightly faster.
		//       If you are sure that object exist then use load() method 
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		//get-student:106
		Student student=(Student)session.load(Student.class, 101);		
		Student student1=(Student)session.load(Student.class, 102);		
		
		System.out.println(student);
		System.out.println(student1);
//		
//		Address ad=(Address)session.get(Address.class, 2);		
//		System.out.println(ad.getStreet()+" : "+ad.getCity());
//		
//		Address ad1=(Address)session.get(Address.class, 2);		
//		System.out.println(ad1.getStreet()+" : "+ad1.getCity());

		session.close();
		factory.close();
		
	}
}

