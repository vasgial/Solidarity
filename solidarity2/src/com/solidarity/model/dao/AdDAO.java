package com.solidarity.model.dao;

import java.util.List;

import com.solidarity.model.entity.Ad;

public interface AdDAO {
	public List<Ad> getAds();
	public void saveAd(Ad ad);
	public Ad getAd(int id);
	public void deleteAd(int id);

}
