package com.solidarity.model.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.solidarity.model.dao.NeedDAO;
import com.solidarity.model.entity.Need;

@Repository
public class NeedDAOImpl implements NeedDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Need> getNeeds() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Need> query = currentSession.createQuery("from Need", Need.class);

		List<Need> needs = query.getResultList();

		return needs;
	}

	@Override
	public void saveNeed(Need need) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(need);

	}

	@Override
	public Need getNeed(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Need need = currentSession.get(Need.class, id);

		return need;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteNeed(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Need where needid=:id");
		theQuery.setParameter("id", id);

		theQuery.executeUpdate();

	}

}
