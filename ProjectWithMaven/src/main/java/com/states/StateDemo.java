package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.Certificate;
import com.hibernate.Student;

public class StateDemo {

	
	public static void main(String[] args) {
		
		//Practical of Hibernate Object States:
		/*
		 * Transient: When the object is instantiated and have some values assigned to
		 * 			  it that means Session object at this moment should have been in Transient state
		 *            (setter and getters stage). The object in this stage is neither associated 
		 *            with session's object nor it is in the database.
		 *  
		 * Persistent: s.save(),s.persist(),s.SaveoOrUpdate() method will be called in this stage which brings the object in persistent stage
		 * 			   also it will now give the object reference to the session's object and data will be there in the 
		 * 			   database i.e. object's value is there in both session's object as well as database.
		 * 			   Values will be updated both in session as well as database if any of it is changed.
		 *  
		 * Detached:  c.close(), c.clear() method. Session is closed/cleared but the data is here in the database but not in the
		 * 			  session's object.
		 * 
		 * Removed:   c.delete() then the data will be deleted from database but it will be stayed in session's object. 
		 * 			  Any change in session's value won't be reflected in database.
		 */
		
		System.out.println("Example :");
		
		SessionFactory f=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			
		//Creating student object:
		Student student=new Student();
		student.setId(1414);
		student.setName("Peter");
		student.setCity("ABC");
		student.setCerti(new Certificate("Java Hibernate Course","2 month"));
		//student : Transient
		
		Session s=f.openSession();
		Transaction tx=s.beginTransaction();
		s.save(student);
		//student: Persistent - session,database
		
		student.setName("John");
		
		tx.commit();
		
		s.close();
		
		//student : Detached:
		student.setName("Sachin");
		
		System.out.println(student);
		f.close();
	}
}
