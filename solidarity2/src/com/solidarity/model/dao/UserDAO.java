package com.solidarity.model.dao;

import java.util.List;

import com.solidarity.model.entity.User;

public interface UserDAO {
	public List<User> getUsers();
	public void saveUser(User user);
	public User getUser(int id);
	public User getUser(String username);
	public void deleteUser(int id);
}
