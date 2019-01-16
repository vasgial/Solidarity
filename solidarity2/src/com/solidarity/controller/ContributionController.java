package com.solidarity.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solidarity.model.entity.Contribution;
import com.solidarity.model.entity.ContributionState;
import com.solidarity.model.helper.ContributionList;
import com.solidarity.model.service.ModelService;

@RestController
@RequestMapping("/contribution")
public class ContributionController {
	
	@Autowired
	private ModelService modelService;
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/{id}")
	public Contribution getContribution(@PathVariable int id,HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Credentials", "true");
		return modelService.getContribution(id);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/all")
	public List<Contribution> getContributions(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Credentials", "true");
		return modelService.getContributions();
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/update")
	public void updateContribution(@RequestBody Contribution contribution, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Credentials", "true");
		modelService.saveContribution(contribution);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping("/registerList")
	public void adContributions(@RequestParam("username") String username, @RequestBody ContributionList contributionList, HttpServletResponse response) {
		
		response.addHeader("Access-Control-Allow-Credentials", "true");
		
		int userid=modelService.getUser(username).getUserid();
		
		List<Contribution> contributions=contributionList.getContributions();
		Date date = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        //to convert Date to String, use format method of SimpleDateFormat class.
        String dateTime = dateFormat.format(date);
        
        ContributionState contState=new ContributionState(1);
        
        
		for(int i=0;i<contributions.size();i++) {
			contributions.get(i).setCid(0);
			contributions.get(i).setUserid(userid);
			contributions.get(i).setDatetime(dateTime);
			contributions.get(i).setState(contState);
			modelService.saveContribution(contributions.get(i));
		}
	}
	
	
	
}
