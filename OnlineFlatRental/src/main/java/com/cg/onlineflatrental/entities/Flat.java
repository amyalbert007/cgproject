package com.cg.onlineflatrental.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="FlatInfo")
public class Flat {
	@Id
	private int flatId;
	
	@Column
	private float cost;
	private FlatAddress flatAddress;
	private String avialibilty;
	
	
	@Override
	public String toString() {
		return "Flat [flatId=" + flatId + ", cost=" + cost + ", flatAddress=" + flatAddress + ", avialibilty="
				+ avialibilty + "]";
	}

	public Flat()
	{

	}
	public Flat(int flatId, float cost, FlatAddress flatAddress, String avialibilty) {
		super();
		this.flatId = flatId;
		this.cost = cost;
		this.flatAddress = flatAddress;
		this.avialibilty = avialibilty;
	}

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

	public void setFlatAdress(FlatAddress flatAddress) {
		this.flatAddress = flatAddress;
	}

	public String getAvialibilty() {
		return avialibilty;
	}

	public void setAvialibilty(String avialibilty) {
		this.avialibilty = avialibilty;
	}

}
