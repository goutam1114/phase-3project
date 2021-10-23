package com.simplilearn.webservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ecom_customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private long id;
	
	@Column(name = "customer_name")
	private String name;
	
	@Column(name="customer_mail")
	private String mail;
	
	
	
	public Customer() {
		super();
	}
	public Customer(long id, String name, String description, double price) {
		super();
		this.id = id;
		this.name = name;
		this.mail = description;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mail=" + mail + "]";
	}
	
	
	

}
