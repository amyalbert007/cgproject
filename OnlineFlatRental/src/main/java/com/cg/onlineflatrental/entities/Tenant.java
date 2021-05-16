package com.cg.onlineflatrental.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "flataddressId")
	private FlatAddress tenantAddress;
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
	public FlatAddress getTenantAddress() {
		return tenantAddress;
	}
	public void setTenantAddress(FlatAddress tenantAddress) {
		this.tenantAddress = tenantAddress;
	}
	public Tenant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tenant(int tenantId, String tenantName, int tenantAge, FlatAddress tenantAddress) {
		super();
		this.tenantId = tenantId;
		this.tenantName = tenantName;
		this.tenantAge = tenantAge;
		this.tenantAddress = tenantAddress;
	}
	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", tenantName=" + tenantName + ", tenantAge=" + tenantAge
				+ ", tenantAddress=" + tenantAddress + "]";
	}

}
