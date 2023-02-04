package com.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project started" );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
		/*
		 * Session factory is the interface hence we can't make it's object 
         * Instead we will make new object of Configuration class.
         * 
		 * OR SessionFactory factory = new
		 * Configuration().configure().buildSessionFactory();
		 */
        
         // Creating student
        Student st = new Student();
        st.setId(104);
        st.setName("Aman Preet");
        st.setCity("Noida");
        System.out.println(st);
        
        // Accessing the CurrentSession from session factory.
        Session session = factory.openSession();
        
		/*
		 * //Before saving the Student object (st) we need to begin the transaction
		 * session.beginTransaction();
		 * 
		 * // Saving the object using session's save function session.save(st);
		 * 
		 * // To see things processed physically in the database file we need to comit
		 * the transaction session.getTransaction().commit();
		 * 
		 * // Closing the session after we are done with each processing step.
		 * session.close();
		 */
        
        // Creating object of Address class
        Address ad = new Address();
        ad.setStreet("street 1");
        ad.setCity("Kanpur");
        ad.setOpen(false);
        ad.setAddedDate(new Date());
        ad.setX(1234.234);
        
        // Reading image
        FileInputStream fis = new FileInputStream("C:\\Users\\Pc\\Desktop\\My_pic.jpeg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        // Saving the object using session's save function
        session.save(ad);
        
        // To see things processed physically in the database file we need to comit the transaction
        session.getTransaction().commit();
        
        // Closing the session after we are done with each processing step.
        session.close();
        
    }
}
