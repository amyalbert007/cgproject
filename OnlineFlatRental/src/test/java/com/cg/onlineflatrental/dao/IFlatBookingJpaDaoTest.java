package com.cg.onlineflatrental.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import com.cg.onlineflatrental.entities.Flat;
import com.cg.onlineflatrental.entities.FlatAddress;
import com.cg.onlineflatrental.entities.FlatBooking;
@RunWith(SpringRunner.class)
@DataJpaTest
class IFlatBookingJpaDaoTest {
	@Autowired 
	IFlatBookingJpaDao iflatjpadao;
	
	@Autowired
	TestEntityManager testEntityManager;
	
	 @Test
	 public void testViewFlatBooking() throws Exception
	 {
		/* FlatBooking flatBooking=new FlatBooking();
		 flatBooking.setBookingNo(4);
		 
		 
		 
		 
			FlatBooking saveInDb = testEntityManager.persist(flatBooking);
			FlatBooking getInDb = iflatjpadao.findById(flatBooking.getBookingNo()).get();
		     assertThat(getInDb).isEqualTo(saveInDb);*/
	 }

	

}
