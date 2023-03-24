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

import com.citiustech.HotelProject.model.Menu;
import com.citiustech.HotelProject.service.MenuService;

@RestController
@EnableWebMvc
@RequestMapping("menu")
@CrossOrigin(origins="http://127.0.0.1:5500")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@PostMapping(value="save",consumes="application/json")
	public void saveMenu(@RequestBody Menu menu){
		menuService.saveMenu(menu);
	}
	
	@GetMapping(value="getall", produces="application/json")
	public List<Menu> getAllMenus(){
		return menuService.getAllMenus();
	}
	
	@GetMapping(value="get/{id}", produces="application/json")
	public Menu getMenuById(@PathVariable int id){
		return menuService.getMenuById(id);
	}
	
	@PutMapping(value="update/{id}", consumes="application/json")
	public void updateMenu(@PathVariable int id, @RequestBody Menu menu){
		menuService.updateMenu(id, menu);
	}
	
	@DeleteMapping(value="delete/{id}")
	public void deleteMenu(@PathVariable int id){
		menuService.deleteMenu(id);
	}
}
