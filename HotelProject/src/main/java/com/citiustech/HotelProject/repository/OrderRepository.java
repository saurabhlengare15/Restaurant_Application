package com.citiustech.HotelProject.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.HotelProject.model.Customers;
import com.citiustech.HotelProject.model.Menu;
import com.citiustech.HotelProject.model.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer> {
	Collection<Orders> findByCustomers(Customers c);
	Collection<Orders> findByMenu(Menu m);
}
