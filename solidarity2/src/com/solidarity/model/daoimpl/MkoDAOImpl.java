package com.solidarity.model.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.solidarity.model.dao.MkoDAO;
import com.solidarity.model.entity.Mko;

@Repository
public class MkoDAOImpl implements MkoDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Mko> getMkos() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Mko> query=currentSession.createQuery("from Mko",Mko.class);
		
		List<Mko> mkos=query.getResultList();
		
		return mkos;
		
	}

	@Override
	public void saveMko(Mko mko) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(mko);
		
	}

	@Override
	public Mko getMko(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Mko mko = currentSession.get(Mko.class, id);
		
		return mko;
	}
	
	@Override
	public Mko getMko(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		List<?> mkos=currentSession.createQuery("FROM Mko u where u.username=:username").setParameter("username",username).list();
		if(mkos.size()==0) {
			return null;
		}else {
			return (Mko)mkos.get(0);
		}
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteMko(int id) {
		Session currentSession = sessionFactory.getCurrentSession();	
		Query theQuery = currentSession.createQuery("delete from Mko where mkoid=:id");
		theQuery.setParameter("id", id);
		
		theQuery.executeUpdate();
	
	
	}

}
