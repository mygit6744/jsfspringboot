package com.yugandhar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@Column
	private  Integer id;
	@Column
	private  String name;
	@Column
	private  float price;

	

	public Product() {
		super();
	}

	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}
}