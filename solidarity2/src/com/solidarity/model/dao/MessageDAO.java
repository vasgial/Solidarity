package com.solidarity.model.dao;

import java.util.List;

import com.solidarity.model.entity.Message;

public interface MessageDAO {
	public List<Message> getMessages();
	public void saveMessage(Message message);
	public Message getMessage(int id);
	public void deleteMessage(int id);
}
