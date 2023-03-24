package com.citiustech.HotelProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.HotelProject.model.Menu;
import com.citiustech.HotelProject.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Transactional
	public void saveMenu(Menu menu){
		menuRepository.save(menu);
	}
	
	public List<Menu> getAllMenus(){
		List<Menu> menulist = new ArrayList<Menu>();
		menuRepository.findAll().forEach(menulist::add);
		return menulist;
	}
	
	public Menu getMenuById(int id){
		Optional<Menu> menu = menuRepository.findById(id);
		Menu m = menu.get();
		return m;
	}
	
	@Transactional
	public void updateMenu(int id, Menu menu){
		menuRepository.save(menu);
	}
	
	@Transactional
	public void deleteMenu(int id){
		menuRepository.deleteById(id);
	}
}
