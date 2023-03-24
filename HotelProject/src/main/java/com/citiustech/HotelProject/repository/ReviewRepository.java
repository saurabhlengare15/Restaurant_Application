package com.citiustech.HotelProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.HotelProject.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	List<Review> findByName(String name);
	List<Review> findByCustid(String id);
}
