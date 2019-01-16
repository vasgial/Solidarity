package com.solidarity.model.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.solidarity.model.dao.AdDAO;
import com.solidarity.model.entity.Ad;

@Repository
public class AdDAOImpl implements AdDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Ad> getAds() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Ad> query = currentSession.createQuery("from Ad", Ad.class);

		List<Ad> ads = query.getResultList();

		return ads;

	}

	@Override
	public void saveAd(Ad ad) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(ad);

	}

	@Override
	public Ad getAd(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Ad ad = currentSession.get(Ad.class, id);

		return ad;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteAd(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Ad where adid=:id");
		theQuery.setParameter("id", id);

		theQuery.executeUpdate();

	}

}
