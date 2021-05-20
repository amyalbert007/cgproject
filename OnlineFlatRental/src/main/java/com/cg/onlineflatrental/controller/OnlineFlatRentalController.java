package com.cg.onlineflatrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineflatrental.entities.FlatBooking;
import com.cg.onlineflatrental.exception.FlatBookingNotFoundException;
import com.cg.onlineflatrental.exception.InvalidFlatInputException;
import com.cg.onlineflatrental.model.FlatBookingDTO;
import com.cg.onlineflatrental.services.IFlatBookingService;

@RestController
@RequestMapping("/api/ofr")
public class OnlineFlatRentalController {
	

	@Autowired
	private IFlatBookingService flatBookingService;
	
	
	
	
	
	


	@PostMapping("/addFlat1")
    public FlatBooking addFlatBooking1(@RequestBody FlatBooking flatBooking) throws InvalidFlatInputException
    {
        return flatBookingService.addFlatBooking1(flatBooking);
    }
	//@PostMapping("/addFlat")
	//public FlatBookingDTO addFlatBooking(@RequestBody FlatBooking flatBooking)
	//{
	//	return flatBookingService.addFlatBooking(flatBooking);
	//}
	
	
	
	
	
	
	
	
	
	
	//@PutMapping("/updateFlat")
	//public FlatBooking updateFlatBooking(@RequestBody FlatBooking flatBooking){
	//		return flatBookingService.updateFlatBooking(flatBooking);
	//	}
	//public FlatBookingDTO updateFlatBooking(@RequestBody FlatBooking flatBooking){
	//	return flatBookingService.updateFlatBooking(flatBooking);
//	}
	
	
	@PutMapping("/updateFlat")
	public ResponseEntity updateFlat(@RequestBody FlatBooking flatbooking) throws FlatBookingNotFoundException
	{
		FlatBooking flat1= flatBookingService.updateFlatBooking(flatbooking);
		return new ResponseEntity(flat1, HttpStatus.OK);
	}
	
	
	
	
	
	
	//@DeleteMapping("/deleteFlat/{bookingNo}")public boolean deleteFlatBookingbyId(@PathVariable int bookingNo){
		
	//	return flatBookingService.deleteFlatBookingbyId(bookingNo);
	//}
	//public FlatBookingDTO deleteFlatBooking(@PathVariable int id){
		
	//	return flatBookingService.deleteFlatBooking(id);
	//}
	
	@DeleteMapping("/deleteFlat/{bookingNo}")
	public  ResponseEntity deleteFlatById(@PathVariable Integer bookingNo) throws FlatBookingNotFoundException
	{
		flatBookingService.deleteFlatBookingbyId(bookingNo);
		return new ResponseEntity("Flat deleted successfully", HttpStatus.OK);
	}
	
	
	
	
	
	
	//@GetMapping("/viewAllFlat/{bookingNo}")
	//public FlatBooking getFlatBookingById(@PathVariable int bookingNo){
	//	System.out.println("amit");
	//	return flatBookingService.viewFlatBooking(bookingNo);
	//}
	@GetMapping("/viewAllFlat/{bookingNo}")
	public ResponseEntity viewFlat(@PathVariable("bookingNo") int bookingNo) throws FlatBookingNotFoundException
	{
		FlatBooking flatbooking=flatBookingService.viewFlatBooking(bookingNo);
		return new ResponseEntity(flatbooking, HttpStatus.OK);
	}
	
	
	
	
	
	
	

	@GetMapping("/view-all-flatBookings")
	public List<FlatBooking> viewAllFlatBooking() {
		return (List<FlatBooking>) flatBookingService.viewAllFlatBooking();
	}
	

	    
}
