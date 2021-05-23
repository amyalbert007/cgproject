package com.cg.onlineflatrentalapp1.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import com.cg.onlineflatrentalapp.dao.ITenantDao;
import com.cg.onlineflatrentalapp.exception.TenantNotFoundException;
import com.cg.onlineflatrentalapp.model.FlatAddress;
import com.cg.onlineflatrentalapp.model.Tenant;
import com.cg.onlineflatrentalapp.services.ITenantService;




@RunWith(SpringRunner.class)
@SpringBootTest
public class ITenantServiceTest {
	
	 @MockBean
	    private ITenantDao itenantdao;
	 @Autowired
	    private ITenantService itenantservice;
	 
	 Tenant tenant=null;
	 FlatAddress flatAddress=null;

	@Test
	public void testAddTenant01()throws Exception {
		Tenant tenant=new Tenant();
		tenant.setTenantId(1);
		tenant.setAge(18);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(11);
		flatAddress.setHouseNo(101);
		flatAddress.setStreet("MGRoad");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCountry("India");
		flatAddress.setPin(560034);
		tenant.setFlatAddress(flatAddress);
		
	//	Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
	//	assertThat(itenantservice.addTenant(tenant)).isEqualTo(tenant);
	//	List<Tenant> tenantList = (List<Tenant>) itenantdao.findAll();
	//	Assert.assertEquals(10, tenantList.size());
	}
	
	@Test
	public void testAddTenant08()throws Exception {
		Tenant tenant=new Tenant();
		tenant.setTenantId(1);
		tenant.setAge(18);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(11);
		flatAddress.setHouseNo(101);
		flatAddress.setStreet("MGRoad");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCountry("India");
		flatAddress.setPin(560034);
		tenant.setFlatAddress(flatAddress);
	}
	
	@Test
	public void testAddTenant09()throws Exception {
		Tenant tenant=new Tenant();
		tenant.setTenantId(1);
		tenant.setAge(18);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(11);
		flatAddress.setHouseNo(101);
		flatAddress.setStreet("MGRoad");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCountry("India");
		flatAddress.setPin(560034);
		tenant.setFlatAddress(flatAddress);
	}
	
	@Test
	void testAddTenant06() throws Exception {
		//LOGGER.info("Testing testAddTenant01()");
		 flatAddress = new FlatAddress(12,102,"asd","asd","asd",560013,"asdf");
	     tenant = new Tenant(1, 24, flatAddress);
	     Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertNotNull(itenantservice.addTenant(tenant));
	}
	@Test
	void testAddTenant07() throws TenantNotFoundException {
		//LOGGER.info("Testing testAddTenant01()");
		FlatAddress flatAddress = new FlatAddress(101, "street", "city", "state", 600001, "country");
		Tenant tenant = new Tenant(1, 24, flatAddress);
		assertNotNull(itenantservice.addTenant(tenant));
	}
	@Test
	public void testAddTenant02()throws Exception {
		Tenant tenant=new Tenant();
		tenant.setTenantId(100);
		tenant.setAge(19);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(1100);
		flatAddress.setHouseNo(1050);
		//flatAddress.setStreet("");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCountry("India");
		flatAddress.setPin(560034);
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertThat(itenantservice.addTenant(tenant)).isEqualTo(tenant);
	}
	
	@Test
	public void testAddTenant03()throws Exception {
		Tenant tenant=new Tenant();
		tenant.setTenantId(6);
		tenant.setAge(20);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(11);
		flatAddress.setHouseNo(105);
		flatAddress.setStreet("M G Road");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCity("India");
		flatAddress.setPin(560034);
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertThat(itenantservice.addTenant(tenant)).isEqualTo(tenant);
	}
	
	@Test
	public void testAddTenant04()throws Exception {
		Tenant tenant=new Tenant();
		
	    FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(11);
		flatAddress.setHouseNo(105);
		flatAddress.setStreet("M G Road");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCity("India");
		flatAddress.setPin(560034);
		tenant.setTenantId(6);
		tenant.setAge(100);
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertThat(itenantservice.addTenant(tenant)).isEqualTo(tenant);
	}
	
	@Test
	public void testAddTenant05()throws Exception {
		
		flatAddress=new FlatAddress(20, 105, "M G Road", " Bangalore", "Karnataka", 577101, "India");
		tenant=new Tenant(10,20, flatAddress);
		/*tenant.setTenantId(10);
		tenant.setAge(20);
		
		flatAddress.setAddressId(20);
		flatAddress.setHouseNo(1050);
		flatAddress.setStreet("M G Road");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCity("India");
		flatAddress.setPin(560034);*/
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertThat(itenantservice.addTenant(tenant)).isEqualTo(tenant);
	}
	
	@Test
	public void testUpdateTenant01()throws Exception {
		Tenant tenant=new Tenant();
		tenant.setTenantId(6);
		tenant.setAge(99);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(11);
		flatAddress.setHouseNo(105);
		flatAddress.setStreet("M G Road");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCity("India");
		flatAddress.setPin(560034);
		
		itenantdao.saveAndFlush(tenant);
		flatAddress.setHouseNo(105);
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertEquals(tenant.getAge(),99);
	}

	@Test
	public void testUpdateTenant02()throws Exception {
		Tenant tenant=new Tenant();
		tenant.setTenantId(6);
		tenant.setAge(1);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(1000);
		flatAddress.setHouseNo(0);
		flatAddress.setStreet("M G Road");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCity("India");
		flatAddress.setPin(5600340);
		
		itenantdao.saveAndFlush(tenant);
		flatAddress.setHouseNo(0);
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertEquals(tenant.getAge(),10);
	}
	
	@Test
	public void testUpdateTenant03()throws Exception {
		Tenant tenant=new Tenant();
		tenant.setTenantId(9);
		tenant.setAge(101);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(11);
		flatAddress.setHouseNo(105);
		flatAddress.setStreet("M G Road");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCity("India");
		flatAddress.setPin(560034);
		
		itenantdao.saveAndFlush(tenant);
		flatAddress.setHouseNo(105);
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertEquals(tenant.getAge(),101);
	}
	
	@Test
	public void testUpdateTenant04()throws Exception {
		Tenant tenant=new Tenant();
		tenant.setTenantId(9);
		tenant.setAge(101);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(11);
		flatAddress.setHouseNo(105);
		flatAddress.setStreet("M G Road");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCity("India");
		flatAddress.setPin(560034);
		
		itenantdao.saveAndFlush(tenant);
		flatAddress.setHouseNo(105);
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertEquals(tenant.getAge(),101);
	}
	
	@Test
	public void testUpdateTenant05()throws Exception {
		Tenant tenant=new Tenant();
		tenant.setTenantId(9);
		tenant.setAge(101);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(11);
		flatAddress.setHouseNo(105);
		flatAddress.setStreet("M G Road");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCity("India");
		flatAddress.setPin(560034);
		
		itenantdao.saveAndFlush(tenant);
		flatAddress.setHouseNo(105);
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertEquals(tenant.getAge(),101);
	}
	
	@Test
	public void testUpdateTenant06()throws Exception {
		Tenant tenant=new Tenant();
		tenant.setTenantId(9);
		tenant.setAge(101);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(11);
		flatAddress.setHouseNo(105);
		flatAddress.setStreet("M G Road");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCity("India");
		flatAddress.setPin(560034);
		
		itenantdao.saveAndFlush(tenant);
		flatAddress.setHouseNo(105);
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertEquals(tenant.getAge(),101);
	}
	
	@Test
	public void testUpdateTenant07()throws Exception {
		Tenant tenant=new Tenant();
		tenant.setTenantId(9);
		tenant.setAge(101);
		FlatAddress flatAddress=new FlatAddress();
		flatAddress.setAddressId(11);
		flatAddress.setHouseNo(105);
		flatAddress.setStreet("M G Road");
		flatAddress.setCity("Bangalore");
		flatAddress.setState("Karnataka");
		flatAddress.setCity("India");
		flatAddress.setPin(560034);
		
		itenantdao.saveAndFlush(tenant);
		flatAddress.setHouseNo(105);
		
		Mockito.when(itenantdao.saveAndFlush(tenant)).thenReturn(tenant);
		assertEquals(tenant.getAge(),101);
	}
	
	

	@Test
	void testViewAllTenant02() {
		//LOGGER.info("Testing testViewAllTenant01()");
		assertNotNull(itenantservice.viewAllTenants());
	}
	@Test
	void testViewAllTenant03() {
		//LOGGER.info("Testing testViewAllTenant01()");
		assertNotNull(itenantservice.viewAllTenants());
	}
	
	@Test
	void testDeleteTenant02() throws TenantNotFoundException {
	//	LOGGER.info("Testing testDeleteTenant02()");
		try
		{
			itenantservice.deleteTenant(6);
		}
		catch(TenantNotFoundException exception)
		{
			assertEquals("No Tenant found in given ID", exception.getMessage());
		}
	}
	
	
	
}
