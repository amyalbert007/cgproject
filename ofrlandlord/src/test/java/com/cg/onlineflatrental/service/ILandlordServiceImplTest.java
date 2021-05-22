package com.cg.onlineflatrental.service;


import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import com.cg.onlineflatrental.dao.ILandlordJpaDao;
import com.cg.onlineflatrental.exception.LandlordNotFoundException;
import com.cg.onlineflatrental.model.Landlord;
import com.cg.onlineflatrental.services.ILandlordService;
import com.cg.onlineflatrental.model.Flat;
import com.cg.onlineflatrental.model.FlatAddress;



//@RunWith(SpringRunner.class)
@SpringBootTest
public class ILandlordServiceImplTest {
	
	@MockBean
	ILandlordJpaDao ilandlordjpadao;
	
	@Autowired
	ILandlordJpaDao ilandlordjpadao1;
	
	@Autowired
	ILandlordService ilandlordservice;
	
	Landlord landlord=null;
	
	@Test
	void testAddLandlord01() throws LandlordNotFoundException 
	{
		
		landlord=new Landlord(1,"Nidhi",23,flatAddress);
		flatAddress=new FlatAddress(10,"BataRoad","Gurgaon","Haryana",11038,"India");
		flat=new Flat(78, (float) 20000, flatAddress,"Yes");
		Mockito.when(ilandlordjpadao.saveAndFlush(landlord)).thenReturn(landlord);
        assertThat(ilandlordservice.addLandlord(landlord)).isEqualTo(landlord);
	}
	
	
	
	
	@Test
	void testAddLandlord02()  {
		landlord = new Landlord(5,"Ankit",25,flatAddress);
		flatAddress = new FlatAddress(1, "street", "city", "state", 221106, "country");
		flat = new Flat(1, 3456.0f, flatAddress, "yes");
		Mockito.when(ilandlordjpadao.saveAndFlush(landlord)).thenReturn(landlord);
        assertThat(ilandlordservice.addLandlord(landlord)).isEqualTo(landlord);
	}

	
	@Test
	public void testAddLandlord03() {
		landlord = new Landlord(7,"Aman",30,flatAddress);
		FlatAddress flatAddress=new FlatAddress(30,"Hodal","Palwal","Haryana",121106,"India");
		Flat flat=new Flat(45, (float) 30000, flatAddress,"Available");
	}
	
	@Test
	public void testAddLandlord04() 
	{
		landlord = new Landlord(11,"Akash",30,flatAddress);
		FlatAddress flatAddress=new FlatAddress(40,"Jalahalli","Tumkur","Tamil Nadu",360010,"India");
		Flat flat=new Flat(16, (float) 0, flatAddress,"No");
		Mockito.when(ilandlordjpadao.saveAndFlush(landlord)).thenReturn(landlord);
        assertThat(ilandlordservice.addLandlord(landlord)).isEqualTo(landlord);
	
	}
	
	@Test
	public void testAddLandlord05()
	{
		landlord = new Landlord(12,"Disha",28,flatAddress);
		FlatAddress flatAddress=new FlatAddress(-5,"Jalahalli","Mangalore","Delhi",260010,"India");
		Flat flat=new Flat( 10 , (float) 6050, flatAddress,"yes");

	}
	
	@Test
	public void testAddLandlord06() 
	{
		Landlord landlord=new Landlord(15,"Rajshree",42,flatAddress);
		FlatAddress flatAddress=new FlatAddress(60,"","Bangalore","Karnataka",560780,"India");
		Flat flat=new Flat(150, (float) 6050, flatAddress,"No");
		Mockito.when(ilandlordjpadao.saveAndFlush(landlord)).thenReturn(landlord);
        assertThat(ilandlordservice.addLandlord(landlord)).isEqualTo(landlord);

	}
	
	@Test
	public void testAddLandlord07() 
	{
		Landlord landlord=new Landlord(16,"Raj",46,flatAddress);
		FlatAddress flatAddress=new FlatAddress(70,"Vidyaran@ya Pura","Gokarna","Maharashtra",720780,"India");
		Flat flat=new Flat(50, (float) 22890, flatAddress,"no");

	}
	
	@Test
	public void testAddLandlord08() {
		Landlord landlord=new Landlord(16,"Sapna",41,flatAddress);
		FlatAddress flatAddress=new FlatAddress(8,"Vidyaranyapura","","Karnataka",560780,"India");
		Flat flat=new Flat(10, (float) 10050, flatAddress,"yes");
		Mockito.when(ilandlordjpadao.saveAndFlush(landlord)).thenReturn(landlord);
        assertThat(ilandlordservice.addLandlord(landlord)).isEqualTo(landlord);
	}
	
	@Test
	public void testAddFlat09() 
	{
		Landlord landlord = new Landlord(19,"Vidya",37,flatAddress);
		FlatAddress flatAddress=new FlatAddress(19,"Kormangala","Bangal1ore","Andra Pradesh",860700,"India");
		Flat flat=new Flat(25, (float) 32000, flatAddress,"Y");
		Mockito.when(ilandlordjpadao.saveAndFlush(landlord)).thenReturn(landlord);
        assertThat(ilandlordservice.addLandlord(landlord)).isEqualTo(landlord);
	}
	
	
	@Test
	public void testAddLandlord10() 
	{
		Landlord landlord = new Landlord(20,"Archana",40,flatAddress);
		FlatAddress flatAddress=new FlatAddress(32,"Magadi","Gokarna","Goa",60780,"India");
		Flat flat=new Flat(32, (float) 29600, flatAddress,"Yes");
		Mockito.when(ilandlordjpadao.saveAndFlush(landlord)).thenReturn(landlord);
        assertThat(ilandlordservice.addLandlord(landlord)).isEqualTo(landlord);
	}

	
	@Test
	public void testUpdateLandlord11() throws LandlordNotFoundException
	{
		Landlord landlord= new Landlord(21,"Ayushi",32,flatAddress);
		FlatAddress flatAddress=new FlatAddress(32,"Magadi","Gokarna","Goa",60780,"India");
		Flat flat=new Flat(32, (float) 29600, flatAddress,"Yes");
		try
		{
			Landlord landlord1=ilandlordservice.updateLandlord(landlord);
			assertEquals("Ayushi", landlord1.getLandlordName());
		}
		catch(LandlordNotFoundException exception)
		{
			assertEquals("landlord with given id was not found", exception.getMessage());
		}
	}
	
	
	@Test
	void testUpdateLandlord12()  {
		Landlord landlord=new Landlord();
		Flat flat=new Flat();
		FlatAddress flatAddress=new FlatAddress();
		
		landlord.setLandlordId(3);
	       landlord.setLandlordName("Vijeta Choudhary");
	       landlord.setLandlordAge(23);
	       
		flat.getFlatId();
		flatAddress.setHouseNo(100);
		flatAddress.setCity("Bangalore");
		flatAddress.setStreet("Kormangala");
		flatAddress.setState("Karnataka");
		flatAddress.setCountry("India");
		flatAddress.setPin(560086);
		
		flat.setCost((float) 2500);
		flat.setFlatAddress(flatAddress);
		flat.setAvailability("Yes");
        iflatjpadao.save(flat);

       flatAddress.setPin(56008);
        Mockito.when(iflatjpadao.save(flat)).thenReturn(flat);
		assertEquals(landlord.getFlatAddress().getPin(), 56008);
    
	}
	@Test
	void testUpdateLandlord19() throws LandlordNotFoundException {
	
		Landlord landlord =new Landlord();
		Flat flat=new Flat();
		FlatAddress flatAddress=new FlatAddress();
		
		 
	       landlord.setLandlordId(3);
	       landlord.setLandlordName("Vijeta Choudhary");
	       landlord.setLandlordAge(23);
		flatAddress.setHouseNo(10);
		flatAddress.setCity("Bangalore");
		flatAddress.setStreet("Kormangala");
		flatAddress.setState("Karnataka");
		flatAddress.setCountry("India");
		flatAddress.setPin(560086);
		flat.getFlatId();
		flat.setCost((float) 2500);
		flat.setFlatAddress(flatAddress);
		flat.setAvailability("Yes");
        ilandlordjpadao.save(landlord);

        
        Mockito.when(ilandlordjpadao.save(landlord)).thenReturn(landlord);
		
		
	}
	
	  @Test
	    public void testViewLandlordById() throws Exception{
		  
		 Landlord landlord = new Landlord();
		 Flat flat=new Flat();
	       FlatAddress flatAddress=new FlatAddress();
	       
	       landlord.setLandlordId(3);
	       landlord.setLandlordName("Vijeta Choudhary");
	       landlord.setLandlordAge(23);
	       
	            flat.setFlatId(1);
	            flatAddress.setHouseNo(100);
				flatAddress.setCity("Bangalore");
				flatAddress.setStreet("nagpura");
				flatAddress.setState("Karnataka");
				flatAddress.setCountry("India");
				flatAddress.setPin(560086);
				
			//	flat.setFlatId(100);
				flat.setCost((float) 2500);
				flat.setFlatAddress(flatAddress);
				flat.setAvailability("Yes");
				
				Mockito.when(ilandlordjpadao.save(landlord)).thenReturn(landlord);
				assertEquals(landlord.getLandlordId(),3);
	    }
		
	  
	  @Test
	    public void testViewAllLandlord() throws Exception{
		  Flat flat=new Flat();
			 FlatAddress flatAddress=new FlatAddress();
			 Landlord landlord1=new Landlord();
			 flatAddress.setHouseNo(10);
			 flatAddress.setCity("Bangalore");
			 flatAddress.setStreet("nagpura");
			 flatAddress.setState("Karnataka");
			 flatAddress.setCountry("India");
		   	 flatAddress.setPin(560086);
				
			 flat.setCost((float) 2500);
			 flat.setFlatAddress(flatAddress);
			 flat.setAvailability("Yes");
			 
			 Flat flat=new Flat();
			 FlatAddress flatAddress=new FlatAddress();
			 flatAddress.setHouseNo(150);
			 flatAddress.setCity("Mysore");
			 flatAddress.setStreet("Nandi Layout");
			 flatAddress.setState("Kerala");
			 flatAddress.setCountry("India");
		   	 flatAddress.setPin(460020);
				
			 flat.setCost((float) 16500);
			 flat.setFlatAddress(flatAddress2);
			 flat.setAvailability("No");

	        List<Landlord> ticketList = new ArrayList<>();
	        ticketList.add(landlord1);
	        ticketList.add(landlord2);

	        Mockito.when(ilandlordjpadao.findAll()).thenReturn(landlordList);
	        assertThat(iflatjpadao.findAll()).isEqualTo(ticketList);
	    }
	  
	  @Test
	    public void testDeleteLandlord() throws Exception{
		  Flat flat = new Flat();
		  Landlord landlord=new Landlord();
	       FlatAddress flatAddress=new FlatAddress();
	       		flat.setFlatId(3); 
	       		flat.getFlatId();
	       		flatAddress.setHouseNo(10);
				flatAddress.setCity("Bangalore");
				flatAddress.setStreet("Kormangala");
				flatAddress.setState("Karnataka");
				flatAddress.setCountry("India");
				flatAddress.setPin(560086);
				
				//flat.setFlatId(100);
				flat.setCost((float) 2500);
				flat.setFlatAddress(flatAddress);
				flat.setAvailability("Yes");

				Mockito.when(ilandordjpadao.save(landlord)).thenReturn(landlord);
				ilandlordjpadao.deleteById(landlord.getLandlordId());
				assertNotEquals(landlord, new Landlord());
	    }
	 
	  
	  @Test
		void testViewAllLandlordByName01() throws  LandlordtNotFoundException {

			try {
				ilandlordservice.findByLandlordNameAndLandlordAge("Aditya",13);
			} catch (InvalidFlatInputException exception) {
				assertEquals("Availability can be only [YES | NO | Yes | No | yes | no | Y | N | y | n]", exception.getMessage());
			}
		}


		@Test
		void testViewAllLandlordByName03() throws LandlordNotFoundException {

			try {

				assertNotNull(ilandlordservice.findBylandlordNameAndlandlordAge("Aman", 30));
			} catch (LandlordNotFoundException exception) {
				assertEquals("No Landlord available for given name", exception.getMessage());
			}
		}

		@Test
		void testViewAllLandlord1() {
			try {
				assertNull(ilandlordservice.viewAllLandlord());
			} catch (AssertionFailedError exception) {
				assertNotNull(ilandlordservice.viewAllLandlord());
			}

		}
		
		@Test
		void testDeleteLandlord1() throws LandlordNotFoundException {
			try {
				assertNull(ilandlordservice.deleteLandlordById(26));
			} catch (LandlordNotFoundException exception) {
				assertEquals("landlord with given id was not found", exception.getMessage());
			}
		}

		@Test
		void testViewLandlord() throws LandlordNotFoundException {
			try {
				assertEquals(1200, ilandlordservice.viewLandlordById(26).getLandlordName());
			} catch (LandlordNotFoundException exception) {
				assertEquals("landlord with given id was not found", exception.getMessage());
			}
		}

}