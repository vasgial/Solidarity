package com.solidarity.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solidarity.model.entity.Mko;
import com.solidarity.model.service.ModelService;

@RestController
@RequestMapping("/mko")
public class MkoController {
	
	
	@Autowired
	private ModelService modelService; 
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/{username}")
	public Mko myself(@PathVariable String username,HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Credentials", "true");
		return modelService.getMko(username);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/update")
	public void update(@RequestBody Mko mko,HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Credentials", "true");
		modelService.saveMko(mko);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/register")
	public void add(@RequestBody Mko mko,HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Credentials", "true");
		mko.setMkoid(0);
		modelService.saveMko(mko);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/all")
	public List<Mko> update(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Credentials", "true");
		return modelService.getMkos();
	}
	
	
}
