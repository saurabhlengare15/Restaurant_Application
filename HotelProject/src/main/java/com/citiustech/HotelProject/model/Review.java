package com.citiustech.HotelProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Review {
	
	@Id
	@GeneratedValue
	private int id;
	private String custid;
	private String name;
	private String message;
	
	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(String name, String message) {
		this.name = name;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Review [name=" + name + ", message=" + message + "]";
	}
	
}
