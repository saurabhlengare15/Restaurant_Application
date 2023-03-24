package com.citiustech.HotelProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.citiustech.HotelProject.model.Customers;
import com.citiustech.HotelProject.service.CustomerService;

@RestController
@EnableWebMvc
@RequestMapping("customer")
@CrossOrigin(origins="http://127.0.0.1:5500")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value="save", consumes="application/json")
	public void saveCustomer(@RequestBody Customers customers){
		customerService.saveCustomer(customers);
	}
	
	@PutMapping(value="update/{id}", consumes="application/json")
	public void updateCustomer(@PathVariable String id, @RequestBody Customers customers){
		customerService.updateCustomer(id, customers);
	}
	
	@DeleteMapping(value="delete/{id}")
	public void deleteCustomer(@PathVariable String id){
		customerService.deleteCustomer(id);
	}
	
	@GetMapping(value="getall", produces="application/json")
	public List<Customers> getAllCustomers(){
		return customerService.getallCustomers();
	}
	
	@GetMapping(value="get/{id}", produces="application/json")
	public Customers getCustomerById(@PathVariable String id){
		return customerService.getCustomerById(id);
	}
}
