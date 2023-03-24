package com.citiustech.HotelProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.HotelProject.exception.AccountNotFoundException;
import com.citiustech.HotelProject.exception.LoginFailedException;
import com.citiustech.HotelProject.model.Admin;
import com.citiustech.HotelProject.model.Customers;
import com.citiustech.HotelProject.repository.AdminRepository;
import com.citiustech.HotelProject.repository.CustomerRepository;

@Service
public class AuthService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public void AdminLogin(Admin admin) throws AccountNotFoundException{
		Admin adm = adminRepository.findByAdminid(admin.getAdminid());
		if(adm != null){
			if(adm.getPwd().compareTo(admin.getPwd()) == 0){
				
			}else{
				throw new LoginFailedException("Username or Password is incorrect...");
			}
		}else{
			throw new AccountNotFoundException("Admin not found with id: "+admin.getAdminid());
		}
	}
	
	public void CustomerLogin(Customers customers) throws AccountNotFoundException{
		Customers csm = customerRepository.findByCustid(customers.getCustid());
		if(csm != null){
			if(csm.getPwd().compareTo(customers.getPwd()) == 0){
				
			}else{
				throw new LoginFailedException("Username or Password is incorrect...");
			}
		}else{
			throw new AccountNotFoundException("Customer not found with id: "+customers.getCustid());
		}
	}
}
