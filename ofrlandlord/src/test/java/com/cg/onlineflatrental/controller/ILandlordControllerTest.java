package com.cg.onlineflatrental.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.onlineflatrental.model.Landlord;
import com.cg.onlineflatrental.model.Flat;
import com.cg.onlineflatrental.model.FlatAddress;
import com.cg.onlineflatrental.services.ILandlordService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ILandlordController.class)
class ILandlordControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private ILandlordService ilandlordservice;
    
    public void testNewLandlord() throws Exception{
        String URI = "/landlord/addLandlord";
        Landlord landlord = new Landlord();
		 landlord.setLandlordId(3);
			landlord.setLandlordName("Vijeta Choudhary");
			landlord.setLandlordAge(23);
			
				Flat flat = new Flat();
			       FlatAddress flatAddress=new FlatAddress();
					 flatAddress.setHouseNo(100);
						flatAddress.setCity("Bangalore");
						flatAddress.setStreet("Kormangala");
						flatAddress.setState("Karnataka");
						flatAddress.setCountry("India");
						flatAddress.setPin(760200);
						
						flat.setCost((float) 2500);
						flat.setFlatAddress(flatAddress);
						flat.setAvailability("Yes");
						landlord.set(Flat); 
						
						String jsonInput = this.convertToJson(landlord);
		Mockito.when(ilandlordservice.viewLandlordById(Mockito.any())).thenReturn(landlord);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
	  MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
      String jsonOutput = mockHttpServletResponse.getContentAsString();

		 assertThat(jsonInput).isEqualTo(jsonOutput); 
		 
    }
				
			
	   @Test
	   public void testViewLandlord() throws Exception
	   {
	   String URI= "viewAllLandlord";
	   Landlord landlord = new Landlord();
		 landlord.setLandlordId(3);
			landlord.setLandlordName("Vijeta Choudhary");
			landlord.setLandlordAge(23);
			landlord.setFlat(); {
				Flat flat = new Flat();
			       FlatAddress flatAddress=new FlatAddress();
					 flatAddress.setHouseNo(100);
						flatAddress.setCity("Bangalore");
						flatAddress.setStreet("Kormangala");
						flatAddress.setState("Karnataka");
						flatAddress.setCountry("India");
						flatAddress.setPin(760200);
						
						flat.setCost((float) 2500);
						flat.setFlatAddress(flatAddress);
						flat.setAvailability("Yes");
			}
			String jsonInput = this.convertToJson(landlord);
	   Mockito.when(ilandlordservice.viewLandlordById(Mockito.any())).thenReturn(landlord);
       MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
       MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
       String jsonOutput = mockHttpServletResponse.getContentAsString();

       assertThat(jsonInput).isEqualTo(jsonOutput);
	   }
	   
	   @Test
	    public void testViewAllLandlord() throws Exception{
	        String URI = "/viewLandlord/{landlordId}";
	        
	        Landlord landlord1 = new Landlord();
			 landlord1.setLandlordId(3);
				landlord1.setLandlordName("Vijeta Choudhary");
				landlord1.setLandlordAge(23);
				landlord1.setFlat(); {
					Flat flat = new Flat();
				       FlatAddress flatAddress=new FlatAddress();
						 flatAddress.setHouseNo(100);
							flatAddress.setCity("Bangalore");
							flatAddress.setStreet("Kormangala");
							flatAddress.setState("Karnataka");
							flatAddress.setCountry("India");
							flatAddress.setPin(760200);
							
							flat.setCost((float) 2500);
							flat.setFlatAddress(flatAddress);
							flat.setAvailability("Yes");
				}
			 
				Landlord landlord2 = new Landlord();
				 landlord2.setLandlordId(4);
					landlord2.setLandlordName("Dinesh Kumar");
					landlord2.setLandlordAge(24);
					landlord2.setFlat(); {
						Flat flat = new Flat();
					       FlatAddress flatAddress=new FlatAddress();
							 flatAddress.setHouseNo(10);
								flatAddress.setCity("Faridabad");
								flatAddress.setStreet("Ballabgarh");
								flatAddress.setState("Haryana");
								flatAddress.setCountry("India");
								flatAddress.setPin(360200);
								
								flat.setCost((float) 3500);
								flat.setFlatAddress(flatAddress);
								flat.setAvailability("Yes");
					}
			  List<Landlord> landlordList = new ArrayList<>();
		        landlordList.add(landlord1);
		        landlordList.add(landlord2);

		        String jsonInput = this.convertToJson(landlordList);

		        Mockito.when(ilandlordservice.viewAllLandlord()).thenReturn(landlordList);
		        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		        String jsonOutput = mockHttpServletResponse.getContentAsString();

		        assertThat(jsonInput).isEqualTo(jsonOutput);
	   }
	   
	   @Test
	    public void testDeleteLandlord() throws Exception{
	        String URI = "/deleteLandlord/{landlordId}";
	        
	 	   Landlord landlord = new Landlord();
			 landlord.setLandlordId(3);
				landlord.setLandlordName("Vijeta Choudhary");
				landlord.setLandlordAge(23);
				landlord.setFlat(); {
					Flat flat = new Flat();
				       FlatAddress flatAddress=new FlatAddress();
						 flatAddress.setHouseNo(100);
							flatAddress.setCity("Bangalore");
							flatAddress.setStreet("Kormangala");
							flatAddress.setState("Karnataka");
							flatAddress.setCountry("India");
							flatAddress.setPin(760200);
							
							flat.setCost((float) 2500);
							flat.setFlatAddress(flatAddress);
							flat.setAvailability("Yes");
				}
	 			
	 			 Mockito.when(ilandlordservice.viewLandlordById(Mockito.any())).thenReturn(landlord);
	 		     Mockito.when(ilandlordservice.deleteLandlordById(Mockito.any())).thenReturn(true);
	 		     MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 100).accept(MediaType.APPLICATION_JSON)).andReturn();
	 		     MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	 		     Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	   	   }
	        
	   @Test
	    public void testUpdateFlat() throws Exception{

	        String URI = "/updateLandlord/";
	       
	        Landlord landlord = new Landlord();
			 landlord.setLandlordId(3);
				landlord.setLandlordName("Vijeta Choudhary");
				landlord.setLandlordAge(23);
				landlord.setFlat(); {
					Flat flat = new Flat();
				       FlatAddress flatAddress=new FlatAddress();
						 flatAddress.setHouseNo(100);
							flatAddress.setCity("Bangalore");
							flatAddress.setStreet("Kormangala");
							flatAddress.setState("Karnataka");
							flatAddress.setCountry("India");
							flatAddress.setPin(760200);
							
							flat.setCost((float) 2500);
							flat.setFlatAddress(flatAddress);
							flat.setAvailability("Yes");
				}
	 			String jsonInput = this.convertToJson(landlord);

	 	        Mockito.when(ilandlordservice.updateLandlord(Mockito.any())).thenReturn(landlord);
	 	       MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
		                .andReturn();
	 	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	 	        String jsonOutput = mockHttpServletResponse.getContentAsString();

	 	        assertThat(jsonInput.substring(0,5)).isEqualTo(jsonOutput.substring(0,5));
	   }
	   
	   private String convertToJson(Object landlord) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(landlord);
	    }
	        

}
       

