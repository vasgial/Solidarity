package com.solidarity.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cont_state")
public class ContributionState {
	
	@Id
	private int cont_stateid;
	
	@Column(name="state")
	private String state;
	
	
	public ContributionState() {
		
	}
	
	public ContributionState(int cont_stateid) {
		this.cont_stateid=cont_stateid;
	}
	
	
	public int getCont_stateid() {
		return cont_stateid;
	}

	
	
	public void setCont_stateid(int cont_stateid) {
		this.cont_stateid = cont_stateid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ContributionState [cont_stateid=" + cont_stateid + ", state=" + state + "]";
	}

	
	
}

