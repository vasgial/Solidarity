package com.solidarity.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solidarity.model.entity.User;
import com.solidarity.model.service.ModelService;

@RestController
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private ModelService modelService;
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/register")
	public User register(@RequestBody User user,HttpServletResponse response) {
		user.setUserid(0);
		modelService.saveUser(user);
		response.addHeader("Access-Control-Allow-Credentials", "true");
		return user;
	}
	
}
