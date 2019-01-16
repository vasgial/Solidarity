package com.solidarity.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.solidarity.model.dao.AdDAO;
import com.solidarity.model.dao.ContributionDAO;
import com.solidarity.model.dao.MessageDAO;
import com.solidarity.model.dao.MkoDAO;
import com.solidarity.model.dao.NeedDAO;
import com.solidarity.model.dao.UserDAO;
import com.solidarity.model.entity.Ad;
import com.solidarity.model.entity.Contribution;
import com.solidarity.model.entity.Message;
import com.solidarity.model.entity.Mko;
import com.solidarity.model.entity.Need;
import com.solidarity.model.entity.User;

@Service
public class ModelServiceImpl implements ModelService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private MkoDAO mkoDAO;

	@Autowired
	private AdDAO adDAO;

	@Autowired
	private ContributionDAO contributionDAO;

	@Autowired
	private MessageDAO messageDAO;

	@Autowired
	private NeedDAO needDAO;

	// User Methods Implementation
	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		userDAO.saveUser(user);
	}

	@Override
	@Transactional
	public User getUser(int id) {
		return userDAO.getUser(id);
	}
	
	@Override
	@Transactional
	public User getUser(String username) {
		return userDAO.getUser(username);
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}

	// Mko Methods Implementation
	@Override
	@Transactional
	public List<Mko> getMkos() {
		return mkoDAO.getMkos();
	}

	@Override
	@Transactional
	public void saveMko(Mko mko) {
		mkoDAO.saveMko(mko);
	}

	@Override
	@Transactional
	public Mko getMko(int id) {
		return mkoDAO.getMko(id);
	}
	
	@Override
	@Transactional
	public Mko getMko(String username) {
		return mkoDAO.getMko(username);
	}

	@Override
	@Transactional
	public void deleteMko(int id) {
		mkoDAO.deleteMko(id);
	}

	// Ad Methods Implementation
	@Override
	@Transactional
	public List<Ad> getAds() {
		return adDAO.getAds();
	}

	@Override
	@Transactional
	public void saveAd(Ad ad) {
		adDAO.saveAd(ad);
	}

	@Override
	@Transactional
	public Ad getAd(int id) {
		return adDAO.getAd(id);
	}

	@Override
	@Transactional
	public void deleteAd(int id) {
		adDAO.deleteAd(id);
	}

	// Contribution Methods Implementation
	@Override
	@Transactional
	public List<Contribution> getContributions() {
		return contributionDAO.getContributions();
	}

	@Override
	@Transactional
	public void saveContribution(Contribution contribution) {
		contributionDAO.saveContribution(contribution);
	}

	@Override
	@Transactional
	public Contribution getContribution(int id) {
		return contributionDAO.getContribution(id);
	}

	@Override
	@Transactional
	public void deleteContribution(int id) {
		contributionDAO.deleteContribution(id);
	}

	// Message Methods Implementation
	@Override
	@Transactional
	public List<Message> getMessages() {
		return messageDAO.getMessages();
	}

	@Override
	@Transactional
	public void saveMessage(Message message) {
		messageDAO.saveMessage(message);
	}

	@Override
	@Transactional
	public Message getMessage(int id) {
		return messageDAO.getMessage(id);
	}

	@Override
	@Transactional
	public void deleteMessage(int id) {
		messageDAO.deleteMessage(id);
	}

	// Need Methods Implementation
	@Override
	@Transactional
	public List<Need> getNeeds() {
		return needDAO.getNeeds();
	}

	@Override
	@Transactional
	public void saveNeed(Need need) {
		needDAO.saveNeed(need);
	}

	@Override
	@Transactional
	public Need getNeed(int id) {
		return needDAO.getNeed(id);
	}

	@Override
	@Transactional
	public void deleteNeed(int id) {
		userDAO.deleteUser(id);
	}

}
