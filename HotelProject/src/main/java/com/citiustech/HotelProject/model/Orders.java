package com.citiustech.HotelProject.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Orders {
	private int ordid;
	private LocalDate orddate;
	private int qty;
	private double amount;

	public Orders(){
		
	}

	public Orders(int ordid, LocalDate orddate, int qty) {
		this.ordid = ordid;
		this.orddate = orddate;
		this.qty = qty;
	}

	@Id
	@GeneratedValue
	public int getOrdid() {
		return ordid;
	}

	public void setOrdid(int ordid) {
		this.ordid = ordid;
	}

	public LocalDate getOrddate() {
		return orddate;
	}

	public void setOrddate(LocalDate orddate) {
		this.orddate = orddate;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	@Override
	public String toString() {
		return "Orders [ordid=" + ordid + ", orddate=" + orddate + ", qty=" + qty + ", amount=" + amount
				+ ", customers=" + customers + ", menu=" + menu + "]";
	}

	private Customers customers;
	
	@ManyToOne(targetEntity=Customers.class, cascade ={CascadeType.ALL})
	@JoinColumn(name="custid")
	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	
	private Menu menu;

	@ManyToOne(targetEntity=Menu.class)
	@JoinColumn(name="id")
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
