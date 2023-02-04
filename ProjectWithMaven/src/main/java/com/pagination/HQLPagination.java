package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.Student;

public class HQLPagination {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();

		Query query = s.createQuery("from Student");

		// implementing pagination using Hibernate

		query.setFirstResult(10); // starting position for the starting pointer

		query.setMaxResults(7); // Total number of records shown in first page/block

		List<Student> list = query.list();

		for (Student st : list) {
			System.out.println(st.getId()+" : "+st.getName() + " : " + st.getCity());
		}

		s.close();

		factory.close();

	}

}
