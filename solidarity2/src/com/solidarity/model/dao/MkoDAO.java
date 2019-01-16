package com.solidarity.model.dao;

import java.util.List;

import com.solidarity.model.entity.Mko;

public interface MkoDAO {

	public List<Mko> getMkos();
	public void saveMko(Mko mko);
	public Mko getMko(int id);
	public Mko getMko(String username);
	public void deleteMko(int id);
}
