package com.solidarity.model.service;

import java.util.List;

import com.solidarity.model.entity.Ad;
import com.solidarity.model.entity.Contribution;
import com.solidarity.model.entity.Message;
import com.solidarity.model.entity.Mko;
import com.solidarity.model.entity.Need;
import com.solidarity.model.entity.User;

public interface ModelService {

	// User Methods
	public List<User> getUsers();
	public void saveUser(User user);
	public User getUser(int id);
	public User getUser(String username);
	public void deleteUser(int id);
	
	//Mko Methods
	public List<Mko> getMkos();
	public void saveMko(Mko mko);
	public Mko getMko(int id);
	public Mko getMko(String username);
	public void deleteMko(int id);
	
	//Ad Methods
	public List<Ad> getAds();
	public void saveAd(Ad ad);
	public Ad getAd(int id);
	public void deleteAd(int id);
	
	//Contribution Methods
	public List<Contribution> getContributions();
	public void saveContribution(Contribution contribution);
	public Contribution getContribution(int id);
	public void deleteContribution(int id);
	
	//Message Methods
	public List<Message> getMessages();
	public void saveMessage(Message message);
	public Message getMessage(int id);
	public void deleteMessage(int id);
	
	//Need Methods
	public List<Need> getNeeds();
	public void saveNeed(Need need);
	public Need getNeed(int id);
	public void deleteNeed(int id);

	
}
