package com.cg.ofrlandlord.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Landlord")
public class Landlord {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int landlordId;
	@Column
	private String landlordName;
	private int  landlordAge;
	public int getLandlordId() {
		return landlordId;
	}
	public void setLandlordId(int landlordId) {
		this.landlordId = landlordId;
	}
	public String getLandlordName() {
		return landlordName;
	}
	public void setLandlordName(String landlordName) {
		this.landlordName = landlordName;
	}
	public int getLandlordAge() {
		return landlordAge;
	}
	public void setLandlordAge(int landlordAge) {
		this.landlordAge = landlordAge;
	}
	public Landlord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Landlord(int landlordId, String landlordName, int landlordAge) {
		super();
		this.landlordId = landlordId;
		this.landlordName = landlordName;
		this.landlordAge = landlordAge;
	}
	@Override
	public String toString() {
		return "Landlord [landlordId=" + landlordId + ", landlordName=" + landlordName + ", landlordAge=" + landlordAge
				+ "]";
	}
	

}
