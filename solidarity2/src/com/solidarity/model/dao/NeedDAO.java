package com.solidarity.model.dao;

import java.util.List;

import com.solidarity.model.entity.Need;

public interface NeedDAO {
	public List<Need> getNeeds();
	public void saveNeed(Need need);
	public Need getNeed(int id);
	public void deleteNeed(int id);
}
