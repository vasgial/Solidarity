package com.solidarity.model.dao;

import java.util.List;

import com.solidarity.model.entity.Contribution;

public interface ContributionDAO {
	public List<Contribution> getContributions();
	public void saveContribution(Contribution contribution);
	public Contribution getContribution(int id);
	public void deleteContribution(int id);

}
