package com.citiustech.HotelProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.HotelProject.model.Customers;
import com.citiustech.HotelProject.repository.CustomerRepository;

@Service	
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional
	public void saveCustomer(Customers customers){
		customerRepository.save(customers);
	}
	
	public List<Customers> getallCustomers(){
		List<Customers> customerlist = new ArrayList<Customers>();
		customerRepository.findAll().forEach(customerlist::add);
		return customerlist;
	}
	
	public Customers getCustomerById(String cid){
		Optional<Customers> cust = customerRepository.findById(cid);
		Customers custd = cust.get();
		return custd;
	}
	
	@Transactional
	public void updateCustomer(String id, Customers customers){
		customerRepository.save(customers);
	}
	
	@Transactional
	public void deleteCustomer(String cid){
		customerRepository.deleteById(cid);
	}
	
	@Transactional
	public Customers findByName(String name){
		return customerRepository.findByName(name);
	}
}
