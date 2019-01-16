package com.solidarity.model.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.solidarity.model.dao.ContributionDAO;
import com.solidarity.model.entity.Contribution;

@Repository
public class ContributionDAOImpl implements ContributionDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Contribution> getContributions() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Contribution> query = currentSession.createQuery("from Contribution", Contribution.class);

		List<Contribution> contributions = query.getResultList();

		return contributions;
	}

	@Override
	public void saveContribution(Contribution contribution) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(contribution);

	}

	@Override
	public Contribution getContribution(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Contribution contribution = currentSession.get(Contribution.class, id);

		return contribution;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteContribution(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Contribution where cid=:id");
		theQuery.setParameter("id", id);

		theQuery.executeUpdate();

	}

}
