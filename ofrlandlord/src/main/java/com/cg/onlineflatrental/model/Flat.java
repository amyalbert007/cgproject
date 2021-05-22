package com.cg.onlineflatrental.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table (name="flat")
public class Flat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flatId;
	
	@Column
	private float cost;
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "flataddressId")
	private FlatAddress flatAddress;
	private String avialibilty;
	public int getFlatId() {
		return flatId;
	}
	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public FlatAddress getFlatAddress() {
		return flatAddress;
	}
	public void setFlatAddress(FlatAddress flatAddress) {
		this.flatAddress = flatAddress;
	}
	public String getAvialibilty() {
		return avialibilty;
	}
	public void setAvialibilty(String avialibilty) {
		this.avialibilty = avialibilty;
	}
	public Flat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flat(int flatId, float cost, FlatAddress flatAddress, String avialibilty) {
		super();
		this.flatId = flatId;
		this.cost = cost;
		this.flatAddress = flatAddress;
		this.avialibilty = avialibilty;
	}
	@Override
	public String toString() {
		return "Flat [flatId=" + flatId + ", cost=" + cost + ", flatAddress=" + flatAddress + ", avialibilty="
				+ avialibilty + "]";
	}
	
	
	

}