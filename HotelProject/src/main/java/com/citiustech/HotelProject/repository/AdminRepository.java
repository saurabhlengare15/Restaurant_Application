package com.citiustech.HotelProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.citiustech.HotelProject.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, String> {
	Admin findByAdminid(String id);
}
