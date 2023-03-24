package com.citiustech.HotelProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.HotelProject.model.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, String> {
	Customers findByCustid(String id);
	Customers findByName(String name);
}
