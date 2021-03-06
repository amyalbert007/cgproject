package com.cg.onlineflatrental11.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table (name="Flat")
public class Flat {
	@Id
	private int flatId;
	
	@Column
	private float cost;
	@OneToOne(cascade=CascadeType.ALL)
	
    @JoinColumn(name = "flataddressId")
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
