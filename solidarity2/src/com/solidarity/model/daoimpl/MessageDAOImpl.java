package com.solidarity.model.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.solidarity.model.dao.MessageDAO;
import com.solidarity.model.entity.Message;

@Repository
public class MessageDAOImpl implements MessageDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Message> getMessages() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Message> query = currentSession.createQuery("from Message", Message.class);

		List<Message> messages = query.getResultList();

		return messages;
	}

	@Override
	public void saveMessage(Message message) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(message);

	}

	@Override
	public Message getMessage(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Message message = currentSession.get(Message.class, id);

		return message;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteMessage(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Message where mid=:id");
		theQuery.setParameter("id", id);

		theQuery.executeUpdate();
	}

}
