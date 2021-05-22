package com.cg.onlineflatrental.dao;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import com.cg.onlineflatrental.model.Flat;
import com.cg.onlineflatrental.model.FlatAddress;
import com.cg.onlineflatrental.model.Landlord;
@RunWith(SpringRunner.class)
@DataJpaTest

public class ILandlordJpaDaoTest {
	@Autowired 
	ILandlordJpaDao ilandlordjpadao;
	
	@Autowired
	TestEntityManager testEntityManager;
	
	@Test
	 public void testViewLandlord() throws Exception
	 {
		 Landlord landlord = new Landlord();
	    	Flat flat = new Flat();
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
			
			
			
			flat.setCost((float) 2500);
			flat.setFlatAdress(flatAddress);
			flat.setAvialibilty("Yes");
			
			Landlord saveInDb = testEntityManager.persist(landlord);
		     Landlord getInDb = ilandlordjpadao.findById(landlord.getLandlordId()).get();
		     assertThat(getInDb).isEqualTo(saveInDb);
	 }
	
	@Test
	 public void testViewAllLandlord() throws Exception
	 {
		 Landlord landlord1 = new Landlord();
	    	Flat flat = new Flat();
	    	FlatAddress flatAddress=new FlatAddress();
	    	
	    	landlord1.setLandlordId(3);
	    	landlord1.setLandlordName("Vijeta Choudhary");
	    	landlord1.setLandlordAge(23);
	    	
		 flatAddress.setHouseNo(100);
		 flatAddress.setCity("Bangalore");
		 flatAddress.setStreet("nagpura");
		 flatAddress.setState("Karnataka");
		 flatAddress.setCountry("India");
	   	 flatAddress.setPin(560086);
			
		 flat.setCost((float) 2500);
		 flat.setFlatAdress(flatAddress);
		 flat.setAvialibilty("Yes");
		 
		 
		Landlord landlord2 = new Landlord();
	    	
		 flatAddress.setHouseNo(10);
		 flatAddress.setCity("Faridabad");
		 flatAddress.setStreet("Ballabgarh");
		 flatAddress.setState("Haryana");
		 flatAddress.setCountry("India");
	   	 flatAddress.setPin(360020);
			
		 flat.setCost((float) 16500);
		 flat.setFlatAdress(flatAddress);
		 flat.setAvialibilty("Yes");
		 
		 
		  testEntityManager.persist(landlord1);
	        testEntityManager.persist(landlord2);

	        List<Landlord> landlordList = (List<Landlord>) ilandlordjpadao.findAll();

	        Assert.assertEquals(2, landlordList.size());
	 }
	
	@Test
    public void testUpdateLandlord(){
	 Landlord landlord=new Landlord();
	 Flat flat=new Flat();
	 FlatAddress flatAddress=new FlatAddress();
	 
	 landlord.setLandlordId(3);
 	 landlord.setLandlordName("Vijeta Choudhary");
 	 landlord.setLandlordAge(23);
	 
	 flatAddress.setHouseNo(100);
		flatAddress.setCity("Bangalore");
		flatAddress.setStreet("Kormangala");
		flatAddress.setState("Karnataka");
		flatAddress.setCountry("India");
		flatAddress.setPin(560086);
		
		flat.setCost((float) 2500);
		flat.setFlatAdress(flatAddress);
		flat.setAvialibilty("Yes");
		
	 }
	 
	 
	 
	 
	 @Test
	    public void testAddLandlord()
	    {
		 
		Landlord landlord=new Landlord();
		 Flat flat=new Flat();
		 FlatAddress flatAddress=new FlatAddress();
		 
		 landlord.setLandlordId(3);
	 	 landlord.setLandlordName("Vijeta Choudhary");
	 	 landlord.setLandlordAge(23);
	 	 
		    flatAddress.setHouseNo(100);
			flatAddress.setCity("Bangalore");
			flatAddress.setStreet("Kormangala");
			flatAddress.setState("Karnataka");
			flatAddress.setCountry("India");
			flatAddress.setPin(560086);
			
			flat.setCost((float) 2500);
			flat.setFlatAdress(flatAddress);
			flat.setAvialibilty("Yes");
			
		
		 
			Landlord saveToDb = testEntityManager.persist(landlord);
			Landlord getFromDb = ilandlordjpadao.findById(saveToDb.getLandlordId()).get();//findById
			assertEquals(getFromDb, saveToDb);
			
	    }

	
	 
	 
	

}
