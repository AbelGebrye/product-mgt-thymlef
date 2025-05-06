package com.springboot.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	@Column(name="price")
	private double price;
	
	@Column(name="qty")
	private int qty;
	
	
	// define cosntructors
	public Product() {}

	

	public Product(int id, String name, int qty, double price) {
		super();
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
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



	public int getQty() {
		return qty;
	}



	public void setQty(int qty) {
		this.qty = qty;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	// define toString
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", qty=" + qty + ", price=" + price + "]";
	}
}
