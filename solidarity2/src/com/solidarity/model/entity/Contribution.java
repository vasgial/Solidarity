package com.solidarity.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="contributions")
public class Contribution {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="datetime")
	private String datetime;
	
	@Column(name="needid")
	private int needid;
	
	@Column(name="userid")
	private int userid;
	
	@ManyToOne
    @JoinColumn(name = "stateid")
	private ContributionState state;
	

	public int getCid() {
		return cid;
	}
	
	public void setCid(int cid) {
		this.cid = cid;
	}

	public ContributionState getState() {
		return state;
	}

	public void setState(ContributionState state) {
		this.state = state;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public int getNeedid() {
		return needid;
	}

	public void setNeedid(int needid) {
		this.needid = needid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	
	
	@Override
	public String toString() {
		return "Contribution [cid=" + cid + ", quantity=" + quantity + ", datetime=" + datetime + ", needid=" + needid
				+ ", userid=" + userid + ", state=" + state + "]";
	}
	
}

