package com.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
/*
 * We can change the name of the table as well it is not mandatory that name of the table should be
 * name of the class.
 */
@Table(name="student_address")
public class Address {
	
	/*
	 * For making field primary key
	 */
	@Id
	/*
	 * This annotation is for making the field auto-increment and IDENTITY is to indicate that
	 * the values will be incremented by 1.
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*
	 * We can rename the column, give the length using @Column annotation
	 */
	@Column(name="address_id")
	private int addressId;
	
	@Column(length = 50,name="STREET")
	private String street;
	
	@Column(length = 100,name="CITY")
	private String city;
	
	@Column(name = "is_open")
	private boolean isOpen;
	
	/*
	 * Using this Annotation we can make sure to tell Hibernate to don't make this 
	 * column in table structure
	 */
    @Transient	
	private double x;
	
	@Column(name="added_date")
	/*
	 * Using below annotation we can make sure that we receive only date and not the complete time stamp.
	 * i.e. for formating the date.
	 */
	@Temporal(TemporalType.DATE)
	private Date addedDate;
	
	@Lob
	private byte[] image;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int addressId, String street, String city, boolean isOpen, double x, Date addedDate, byte[] image) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		this.x = x;
		this.addedDate = addedDate;
		this.image = image;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}