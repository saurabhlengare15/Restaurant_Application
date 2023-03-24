package com.citiustech.HotelProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.HotelProject.model.Customers;
import com.citiustech.HotelProject.model.Review;
import com.citiustech.HotelProject.repository.CustomerRepository;
import com.citiustech.HotelProject.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Review saveReview(Review review){
		Customers c = customerRepository.findByName(review.getName());
		review.setCustid(c.getCustid());
		return reviewRepository.save(review);
	}
	
	public List<Review> getAllReviews(){
		return reviewRepository.findAll();
	}
	
	public List<Review> getReviewByCustomer(String name){
		return reviewRepository.findByName(name);
	}
	
	public List<Review> getReviewByCustid(String id){
		return reviewRepository.findByCustid(id);
	}
}
