package com.cg.onlineflatrental.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class FlatAddress {
	@Id
	private int id;
	@Column
	private int houseNo;
	private String street;
	private String city;
	private String state;
	private long pin;
	private String country;
	public FlatAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FlatAddress(int id, int houseNo, String street, String city, String state, long pin, String country) {
		super();
		this.id = id;
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.country = country;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getPin() {
		return pin;
	}
	public void setPin(long pin) {
		this.pin = pin;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "FlatAddress [id=" + id + ", houseNo=" + houseNo + ", street=" + street + ", city=" + city + ", state="
				+ state + ", pin=" + pin + ", country=" + country + "]";
	}
	
	
	

}
