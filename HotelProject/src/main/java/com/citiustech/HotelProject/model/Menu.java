package com.citiustech.HotelProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Menu {
	
	private int id;
	private String name;
	private double price;
	private String description;
	
	public Menu(){
		
	}

	public Menu(int id, String name, double price, String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	@Id
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
	}
	
}
