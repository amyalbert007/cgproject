package com.cg.onlineflatrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
	
	


	
	@PostMapping("/addFlat")
	public FlatBookingDTO addFlatBooking(@RequestBody FlatBooking flatBooking)
	{
		return flatBookingService.addFlatBooking(flatBooking);
	}
	
	
	@PutMapping("/updateFlat")
	public FlatBookingDTO updateFlatBooking(@RequestBody FlatBooking flatBooking){
		return flatBookingService.updateFlatBooking(flatBooking);
	}
	
	@DeleteMapping("/deleteFlat/{id}")
	public FlatBookingDTO deleteFlatBooking(@PathVariable int id){
		
		return flatBookingService.deleteFlatBooking(id);
	}
	@GetMapping("/viewAllFlat/{id}")
	public FlatBookingDTO getFlatBookingById(@PathVariable int id){
		return flatBookingService.viewFlatBooking(id);
	}
	

	@GetMapping("/view-all-flatBookings")
	public List<FlatBookingDTO> getAllFlatBooking() {
		return flatBookingService.viewAllFlatBooking();
	}
	

	    
}
