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
@Table(name="needs")
public class Need {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int needid;
	
	@Column(name="product_type")
	private String product_type;
	
	@Column(name="product_quantity")
	private int product_quantity;
	
	@Column(name="munit")
	private String unitOfMeasure;
	
	@Column(name="stateid")
	private int stateid;
	
	@Column(name="adid")
	private int adid;
	
	@OneToMany(mappedBy="needid")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Contribution> contributions;

	public int getNeedid() {
		return needid;
	}

	public void setNeedid(int needid) {
		this.needid = needid;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public int getStateid() {
		return stateid;
	}

	public void setStateid(int stateid) {
		this.stateid = stateid;
	}

	public int getAdid() {
		return adid;
	}

	public void setAdid(int adid) {
		this.adid = adid;
	}

	public List<Contribution> getContributions() {
		return contributions;
	}

	public void setContributions(List<Contribution> contributions) {
		this.contributions = contributions;
	}

	@Override
	public String toString() {
		return "Need [needid=" + needid + ", product_type=" + product_type + ", product_quantity=" + product_quantity
				+ ", unitOfMeasure=" + unitOfMeasure + ", stateid=" + stateid + ", adid=" + adid + ", contributions="
				+ contributions + "]";
	}
	
	
	
}

