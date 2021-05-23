package com.cg.onlineflatrentalapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
public class Tenant {
	public Tenant(int tenantId, int age, FlatAddress flatAddress) {
		super();
		this.tenantId = tenantId;
		this.age = age;
		this.flatAddress = flatAddress;
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer tenantId;
	private Integer age;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="FlatAddressID")
	private FlatAddress flatAddress;
  
	public Tenant()
	{
		super();
	}

	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public FlatAddress getFlatAddress() {
		return flatAddress;
	}

	public void setFlatAddress(FlatAddress flatAddress) {
		this.flatAddress = flatAddress;
	}

	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", age=" + age + ", flatAddress=" + flatAddress + "]";
	}
	

}
