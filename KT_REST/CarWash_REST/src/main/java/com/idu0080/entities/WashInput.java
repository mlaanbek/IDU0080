package com.idu0080.entities;

import javax.persistence.Column;
import javax.persistence.Id;

public class WashInput {
	@Id
	@Column(name="input_id")
	private String id;
	
	@Column(name="input_name")
	private String name;
	
	@Column(name="input_type")
	private String type;
	
	@Column(name="input_price")
	private float price;
	
	@Column(name="input_make")
	private String make;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

}
