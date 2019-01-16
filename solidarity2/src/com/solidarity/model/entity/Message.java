package com.solidarity.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="messages")
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mid;
	
	@Column(name="datetime")
	private String dateTime;
	@Column(name="text")
	private String text;
	
	@Column(name="userid")
	private int userid;
	
	@Column(name="mkoid")
	private int mkoid;
		
	public Message() {}	

	public int getUserid() {
		return userid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}



	public int getMkoid() {
		return mkoid;
	}



	public void setMkoid(int mkoid) {
		this.mkoid = mkoid;
	}



	public int getMid() {
		return mid;
	}



	public void setMid(int mid) {
		this.mid = mid;
	}



	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}



	@Override
	public String toString() {
		return "Message [mid=" + mid + ", dateTime=" + dateTime + ", text=" + text + ", userid=" + userid + ", mkoid="
				+ mkoid + "]";
	}
}

