package com.citiustech.HotelProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Admin {
	
	private String adminid;
	private String email;
	private String pwd;
	
	public Admin(){
		
	}

	public Admin(String adminid, String email, String pwd) {
		this.adminid = adminid;
		this.email = email;
		this.pwd = pwd;
	}

	@Id
	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", email=" + email + ", pwd=" + pwd + "]";
	}
	
}
