package com.solidarity.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solidarity.model.entity.User;
import com.solidarity.model.service.ModelService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private ModelService modelService; 
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/{username}")
	public User myself(@PathVariable String username,HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Credentials", "true");
		return modelService.getUser(username);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/update")
	public void update(@RequestBody User user,HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Credentials", "true");
		modelService.saveUser(user);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/all")
	public List<User> update(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Credentials", "true");
		return modelService.getUsers();
	}
	
	
	
}
