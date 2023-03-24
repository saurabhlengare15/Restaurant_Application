package com.citiustech.HotelProject.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.citiustech.HotelProject.model.Orders;
import com.citiustech.HotelProject.service.OrderService;


@RestController
@EnableWebMvc
@RequestMapping("order")
@CrossOrigin(origins="http://127.0.0.1:5500")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value="all", produces="application/json")
	public List<Orders> getAllOrders(){
		return orderService.getAllOrder();
	}
	
	@GetMapping("{id}")
	public Orders getOrderById(@PathVariable int id){
		return orderService.getOrderById(id);
	}
	
	@PostMapping(value="save", consumes="application/json")
	public Orders saveOrder(@RequestBody Orders orders){
		return orderService.saveOrder(orders);
	}
	
	@GetMapping("get/{custid}")
	public Collection<Orders> getOrderByCustomer(@PathVariable String custid){
		return orderService.getOrderByCustomer(custid);
	}
}
