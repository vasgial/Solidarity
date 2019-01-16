package com.solidarity.model.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.solidarity.model.dao.UserDAO;
import com.solidarity.model.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public List<User> getUsers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<User> query=currentSession.createQuery("from User",User.class);
		
		List<User> users=query.getResultList();
		
		return users;
	}


	@Override
	public void saveUser(User user) {
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(user);
	}


	@Override
	public User getUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		User user = currentSession.get(User.class, id);
		
		return user;
	}
	
	
	@Override
	public User getUser(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		List<?> users=currentSession.createQuery("FROM User u where u.username=:username").setParameter("username",username).list();
		if(users.size()==0) {
			return null;
		}else {
			return (User)users.get(0);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteUser(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from User where userid=:id");
		theQuery.setParameter("id", id);
		
		theQuery.executeUpdate();
	}
	
	

}
