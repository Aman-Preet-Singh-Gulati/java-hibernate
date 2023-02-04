package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class FirstDemo {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		// By Default Enabled
		
		/*
		 * Here we are creating the session object for student for the first time
		 * so the object will be created in the cache memory of session object i.e.
		 * query will be fired
		 */

		Student student = session.get(Student.class, 104);
		System.out.println(student);
		
		System.out.println("working something..");
		
		/*
		 * When second time we will again try to access the student object then hibernate will not
		 * fire the SQL query instead it will pull up the student object 
		 * from session's cache memory i.e. first level cache.
		 */
		
		Student student1 = session.get(Student.class,104);
		System.out.println(student1);
		
		/*
		 * Contains function will test that whether the session object has
		 * the student object or not.
		 */
		System.out.println(session.contains(student1));

		session.close();

	}
}
