package com.cg.onlineflatrental.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Tenant")
public class Tenant {
	@Id
	private int tenantId;
	@Column
	private String tenantName;
	@Column
	private int tenantAge;
	@Column
	private FlatAddress flatAddress;
	public int getTenantId() {
		return tenantId;
	}
	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public int getTenantAge() {
		return tenantAge;
	}
	public void setTenantAge(int tenantAge) {
		this.tenantAge = tenantAge;
	}
	public FlatAddress getFlatAddress() {
		return flatAddress;
	}
	public void setFlatAddress(FlatAddress flatAddress) {
		this.flatAddress = flatAddress;
	}
	public Tenant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tenant(int tenantId, String tenantName, int tenantAge, FlatAddress flatAddress) {
		super();
		this.tenantId = tenantId;
		this.tenantName = tenantName;
		this.tenantAge = tenantAge;
		this.flatAddress = flatAddress;
	}
	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", tenantName=" + tenantName + ", tenantAge=" + tenantAge
				+ ", flatAddress=" + flatAddress + "]";
	}

}
