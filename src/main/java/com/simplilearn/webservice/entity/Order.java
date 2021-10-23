package com.simplilearn.webservice.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ecom_orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private long id;

	@Column(name = "order_name")
	private String name;

	@Column(name = "order_description")
	private String description;

	@Column(name = "order_price")
	private double price;

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Set<Product> products;

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Order() {
		super();
	}

	public Order(long id, String name, String description, double price, Set<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.products = products;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", products=" + products + "]";
	}

}
