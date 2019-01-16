package com.solidarity.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="ads")
public class Ad {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adid;
	
	@Column(name="description")
	private String description;
	
	@Column(name="mkoid")
	private int mkoid;
	
	@ManyToOne
    @JoinColumn(name = "stateid")
	private AdsNeedsState state;
	
	
	@OneToMany(mappedBy="adid")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Need> needs;


	public int getAdid() {
		return adid;
	}


	public void setAdid(int adid) {
		this.adid = adid;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getMkoid() {
		return mkoid;
	}


	public void setMkoid(int mkoid) {
		this.mkoid = mkoid;
	}


	public AdsNeedsState getState() {
		return state;
	}


	public void setState(AdsNeedsState state) {
		this.state = state;
	}


	public List<Need> getNeeds() {
		return needs;
	}


	public void setNeeds(List<Need> needs) {
		this.needs = needs;
	}


	@Override
	public String toString() {
		return "Ad [adid=" + adid + ", description=" + description + ", mkoid=" + mkoid + ", state=" + state
				+ ", needs=" + needs + "]";
	}
	
	
	
}

