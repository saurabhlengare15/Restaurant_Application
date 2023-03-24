
package com.citiustech.HotelProject.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.citiustech.HotelProject.exception.AccountNotFoundException;
import com.citiustech.HotelProject.model.Admin;
import com.citiustech.HotelProject.model.Customers;
import com.citiustech.HotelProject.service.AuthService;

@RestController
@EnableWebMvc
@RequestMapping("/auth")
@CrossOrigin(origins="http://127.0.0.1:5500")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping(value="admin", consumes="application/json")
	private ResponseEntity<?> adminlogin(@RequestBody Admin a) throws AccountNotFoundException{
		authService.AdminLogin(a);
		Map<String, String> info = new HashMap<>();
		info.put("AdminId", a.getAdminid());
		return new ResponseEntity<>(info, HttpStatus.OK);
	}
	
	@PostMapping(value="customer", consumes="application/json")
	private ResponseEntity<?> customerlogin(@RequestBody Customers c) throws AccountNotFoundException{
		authService.CustomerLogin(c);
		Map<String, String> info = new HashMap<>();
		info.put("CustomerId", c.getCustid());
		return new ResponseEntity<>(info, HttpStatus.OK);
	}
	
	@GetMapping(value="login", produces="application/json")
	public String loginT(){
		return "hello";
	}
}
