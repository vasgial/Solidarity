package com.solidarity.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="needsads_state")
public class AdsNeedsState {
	@Id
	private int ads_stateid;
	
	@Column(name="state")
	private String state;

	public int getAds_stateid() {
		return ads_stateid;
	}

	public void setAds_stateid(int ads_stateid) {
		this.ads_stateid = ads_stateid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "AdsNeedsState [ads_stateid=" + ads_stateid + ", state=" + state + "]";
	}
	
	
}

