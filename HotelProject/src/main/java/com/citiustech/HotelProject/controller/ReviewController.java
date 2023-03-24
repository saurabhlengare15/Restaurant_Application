package com.citiustech.HotelProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.HotelProject.model.Review;
import com.citiustech.HotelProject.repository.ReviewRepository;
import com.citiustech.HotelProject.service.ReviewService;

@RestController
@RequestMapping("review")
@CrossOrigin(origins="http://127.0.0.1:5500")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping(value="save", consumes="application/json")
	public Review saveReview(@RequestBody Review review){
		return reviewService.saveReview(review);
	}
	
	@GetMapping(value="all", produces="application/json")
	public List<Review> getAllReviews(){
		return reviewService.getAllReviews();
	}
	
	@GetMapping(value="get/{id}", produces="application/json")
	public List<Review> getByCustid(@PathVariable String id){
		return reviewService.getReviewByCustid(id);
	}
	
	@GetMapping(value="name/{name}", produces="application/json")
	public List<Review> getReviewByCustomer(@PathVariable String name){
		return reviewService.getReviewByCustomer(name);
	}
	
	@GetMapping(value="gg", produces="application/json")
	public String givemsg(){
		return "hello";
	}
}
