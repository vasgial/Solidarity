package com.solidarity.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solidarity.model.entity.Ad;
import com.solidarity.model.service.ModelService;

@RestController
@RequestMapping("/ads")
public class AdController {
	
	@Autowired
	private ModelService modelService; 
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/{id}")
	public Ad getAd(@PathVariable int id,HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Credentials", "true");
		return modelService.getAd(id);
		
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/all")
	public List<Ad> getAds(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Credentials", "true");
		return modelService.getAds();
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/update")
	public void updateAd(@RequestBody Ad ad, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Credentials", "true");
		modelService.saveAd(ad);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/register")
	public void adAd(@RequestBody Ad ad, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Credentials", "true");
		ad.setAdid(0);
		modelService.saveAd(ad);
	}
	
	
}
