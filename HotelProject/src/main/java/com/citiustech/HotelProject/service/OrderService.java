package com.citiustech.HotelProject.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.HotelProject.model.Customers;
import com.citiustech.HotelProject.model.Menu;
import com.citiustech.HotelProject.model.Orders;
import com.citiustech.HotelProject.repository.CustomerRepository;
import com.citiustech.HotelProject.repository.MenuRepository;
import com.citiustech.HotelProject.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private MenuRepository menuRepository;
	
	public static int ordstart = 1;

	public List<Orders> getAllOrder(){
		List<Orders> orderlist = new ArrayList<Orders>();
		orderRepository.findAll().forEach(orderlist::add);
		return orderlist;
	}
	
	public Orders getOrderById(int id){
		Optional<Orders> ord = orderRepository.findById(id);
		Orders ords = ord.get();
		return ords;
	}
	
	public Collection<Orders> getOrderByCustomer(String custid){
		Customers c = new Customers();
		c.setCustid(custid);
		return orderRepository.findByCustomers(c);
	}
	
	public Collection<Orders> getOrderByMenu(int id){
		Menu m = new Menu();
		m.setId(id);
		return orderRepository.findByMenu(m);
	}
	
	public Orders saveOrder(Orders orders){
		Optional<Menu> menus = menuRepository.findById(orders.getMenu().getId());
		Menu me = menus.get();
		
		Optional<Customers> customers = customerRepository.findById(orders.getCustomers().getCustid());
		Customers c = customers.get();
		
		orders.setOrddate(LocalDate.now());
		orders.setAmount(me.getPrice()*orders.getQty());
		orders.setCustomers(c);
		orders.setMenu(me);
		
		orderRepository.save(orders);
		
		return orders;
	}
}
