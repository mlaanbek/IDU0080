package com.idu0080.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wash")
public class Wash {
	@Id
	@Column(name="wash_id")
	private String wash_id;
	
	@Column(name="wash_name")
	private String wash_name;
	
	@Column(name="wash_duration")
	private int wash_duration;
	
	@Column(name="wash_type")
	private String wash_type;
	

	public String getWash_type() {
		return wash_type;
	}

	public void setWash_type(String wash_type) {
		this.wash_type = wash_type;
	}

	@Column(name="price")
	private float wash_price;

	public String getWash_id() {
		return wash_id;
	}

	public void setWash_id(String wash_id) {
		this.wash_id = wash_id;
	}

	public String getWash_name() {
		return wash_name;
	}

	public void setWash_name(String wash_name) {
		this.wash_name = wash_name;
	}

	public int getWash_duration() {
		return wash_duration;
	}

	public void setWash_duration(int wash_duration) {
		this.wash_duration = wash_duration;
	}

	public float getWash_price() {
		return wash_price;
	}

	public void setWash_price(float wash_price) {
		this.wash_price = wash_price;
	}
	
}
