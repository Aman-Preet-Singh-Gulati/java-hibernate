package com.hibernate;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/*
 * Entity annotation is used when we want to configure the java class as entity i.e.
 * we want to create the table in the database using Hibernate.
 * Now Hibernate can create the object of the same and create the table out of it 
 * similarly can return the same in the form of object back to Java
 * We can change the name of entity with "name" attribute --> @Entity(name="student_details)
 */
@Entity
/*
 * Optional: For creating a table we use @Table annotation and give the name to it as --> 
 * @Table(name="mystudents")
 */
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY) // Strategy
public class Student {

	/*
	 * To make any field (here variable) as primary key we use @Id annotation
	 */
	@Id
	private int id;
	private String name;
	private String city;
	private Certificate certi;

	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public Student(int id, String name, String city, Certificate certi) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.certi = certi;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Certificate getCerti() {
		return certi;
	}

	public void setCerti(Certificate certi) {
		this.certi = certi;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + " : " + this.name + " : " + this.city;
	}

}
