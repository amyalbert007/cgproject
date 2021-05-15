package com.cg.onlineflatrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineflatrental.entities.FlatBooking;
import com.cg.onlineflatrental.model.FlatBookingDTO;
import com.cg.onlineflatrental.services.IFlatBookingService;
@CrossOrigin(origins="http://localhost:8099")
@RestController
@RequestMapping("/api/ofr")
public class OnlineFlatRentalController {
	

	@Autowired
	private IFlatBookingService flatBookingService;
	
	


	@PostMapping("/add-flatBooking")
	public ResponseEntity<Object> addFlatBooking(@RequestBody FlatBooking flatBooking) {
		FlatBookingDTO flatBookingDTO = null;
		ResponseEntity<Object> flatBookingResponse = null;
		flatBookingDTO = flatBookingService.addFlatBooking(flatBooking);
		flatBookingResponse = new ResponseEntity<>(flatBookingDTO, HttpStatus.ACCEPTED);
		
		return flatBookingResponse;
	}
	
	
	@PutMapping("/update-flatBooking")
	public ResponseEntity<Object> updateFlatBooking(@RequestBody FlatBooking flatBooking) {
		
		FlatBookingDTO flatBookingDTO = null;
		ResponseEntity<Object> flatBookingResponse = null;
		flatBookingDTO = flatBookingService.updateFlatBooking(flatBooking);
		flatBookingResponse = new ResponseEntity<>(flatBookingDTO, HttpStatus.ACCEPTED);
		return flatBookingResponse;
	}
	@DeleteMapping("/delete-flatBooking/{id}")
	public ResponseEntity<Object> deleteFlatBooking(@PathVariable int id) {
		
		FlatBookingDTO flatBookingDTO = flatBookingService.deleteFlatBooking(id);
		
		return new ResponseEntity<>(flatBookingDTO, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/view-flatBooking/{id}")
	public ResponseEntity<Object> getFlatBookingById(@PathVariable int id) {
		FlatBookingDTO flatBookingDTO = null;
		flatBookingDTO = flatBookingService.viewFlatBooking(id);
		
		return new ResponseEntity<>(flatBookingDTO, HttpStatus.ACCEPTED);
	}
	

	@GetMapping("/view-all-flatBookings")
	public List<FlatBookingDTO> getAllFlatBooking() {
		return flatBookingService.viewAllFlatBooking();
	}
	

	    
}
