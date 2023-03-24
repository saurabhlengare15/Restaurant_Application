package com.citiustech.HotelProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.HotelProject.model.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer> {
	
}
