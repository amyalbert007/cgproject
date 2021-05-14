package com.cg.onlineflatrental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cg.onlineflatrental.OnlineFlatRentalRestClient;
import com.cg.onlineflatrental.entities.FlatBooking;

public class OnlineFlatRentalRestClient {
	@Autowired
	   RestTemplate restTemplate;


	public void getFlatBookingDetails() {
		
	final String uri = "http://localhost:8099/booking/getFlatBookingByNo/7";
 RestTemplate restTemplate = new RestTemplate();
 
 
 HttpHeaders headers = new HttpHeaders();
HttpEntity <String> entity = new HttpEntity<String>(headers);
 
  ResponseEntity<FlatBooking> response = restTemplate.getForEntity(uri, FlatBooking.class);
System.out.println(response.getBody().toString());
// System.out.println(restTemplate.exchange(uri, HttpMethod.GET, entity, String.class).getBody().toString());
// restTemplate.exchange("http://localhost:8085/booking/", HttpMethod.POST, entity, String.class).getBody();
//restTemplate.exchange("http://localhost:8085/products/"+id, HttpMethod.PUT, entity, String.class).getBody();
//restTemplate.exchange("http://localhost:8085/products/"+id, HttpMethod.DELETE, entity, String.class).getBody();

	}
	public static void main(String[] args) {
		OnlineFlatRentalRestClient client= new OnlineFlatRentalRestClient();
		client.getFlatBookingDetails();
	}

}
