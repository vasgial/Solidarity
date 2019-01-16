package com.solidarity.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.solidarity.model.entity.Need;
import com.solidarity.model.service.ModelService;

@RestController
@RequestMapping("/need")
public class NeedController {
	
	@Autowired
	private ModelService modelService; 
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/{id}")
	public Need getNeed(@PathVariable int id,HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Credentials", "true");
		return modelService.getNeed(id);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/all")
	public List<Need> getNeeds(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Credentials", "true");
		return modelService.getNeeds();
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/update")
	public void updateNeed(@RequestBody Need need, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Credentials", "true");
		modelService.saveNeed(need);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/registerList")
	public void adNeed(@RequestBody List<Need> needs, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Credentials", "true");
		for(int i=0;i<needs.size();i++) {
			needs.get(i).setNeedid(0);
			modelService.saveNeed(needs.get(i));
		}
	}
	
	
}
