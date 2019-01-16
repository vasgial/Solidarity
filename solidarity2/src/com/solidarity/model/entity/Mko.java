package com.solidarity.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;



@Entity
@Table(name="mko")
public class Mko {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mkoid;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="companyname")
	private String companyName;
	@Column(name="afm")
	private String afm;
	@Column(name="email")
	private String email;
	@Column(name="telephone")
	private String telephone;
	@Column(name="address")
	private String address;
	
	@OneToMany(mappedBy="mkoid")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Message> messages;
	
	@OneToMany(mappedBy="mkoid")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Ad> ads;
	
	public Mko() {}

	
	public Mko(String username, String password, String companyName, String afm, String email, String telephone,
			String address) {
		super();
		this.username = username;
		this.password = password;
		this.companyName = companyName;
		this.afm = afm;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getMkoid() {
		return mkoid;
	}

	
	public List<Ad> getAds() {
		return ads;
	}


	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}


	public void setMkoid(int mkoid) {
		this.mkoid = mkoid;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAfm() {
		return afm;
	}

	public void setAfm(String afm) {
		this.afm = afm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public String getRole() {
		return "MKO";
	}
	
	@Override
	public String toString() {
		return "MKO [mkoid=" + mkoid + ", username=" + username + ", password=" + password + ", companyName="
				+ companyName + ", afm=" + afm + ", email=" + email + ", telephone=" + telephone + ", address="
				+ address + ", messages=" + messages + ", ads=" + ads + "]";
	}


	

}
