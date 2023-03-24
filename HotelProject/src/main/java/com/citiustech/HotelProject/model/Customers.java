package com.citiustech.HotelProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customers {
	private String custid;
	private String pwd;
	private String email;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customers(){
		
	}

	public Customers(String custid, String pwd, String email, String name) {
		this.custid = custid;
		this.pwd = pwd;
		this.email = email;
		this.name = name;
	}

	@Id
	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customers [custid=" + custid + ", pwd=" + pwd + ", email=" + email + ", name=" + name + "]";
	}
	
}
