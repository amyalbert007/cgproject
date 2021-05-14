package com.cg.onlineflatrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineflatrental.entities.FlatBooking;
import com.cg.onlineflatrental.services.TicketBookingService;

public class OnlineFlatRentalController {
	@RestController
	@RequestMapping("/booking")
	public class TicketBookingController {

	    @Autowired
	    private TicketBookingService ticketBookingService;

	    @GetMapping("/getAllTickets")
	    public List<Ticket> getAllTickets(){
	        return (List<Ticket>) ticketBookingService.getAllTickets();
	    }

	    @GetMapping("/getTicketById/{ticketId}")
	    public Ticket getTicketById(@PathVariable Integer ticketId){
	        return ticketBookingService.findTicketById(ticketId);
	    }

	    @GetMapping("/getTicketByEmail/{email:.+}")
	    public Ticket getTicketByEmail(@PathVariable String email){
	        return ticketBookingService.findTicketByEmail(email);
	    }

	    @PutMapping("/updateTicketbyId/{email:.+}/ticket/{ticketId}")
	    public Ticket updateTicketById(@PathVariable String email, @PathVariable Integer ticketId){
	        return ticketBookingService.updateEmailById(ticketId, email);
	    }
	/*
	 * 
	 { 
	     "ticketId":"101",
	   "passengerName":"Abc",
	   "fromStation":"Hyd",
	    "toStation":"Chennai",
	   "bookingDate":"2019-09-09",
	     "email":"abc@gmail.com"
		
		}
	 */
	    @PostMapping("/createTicket")
	    public Ticket createTicket(@RequestBody Ticket ticket){
	        return ticketBookingService.createTicket(ticket);
	    }

	    @DeleteMapping("/deleteTicketById/ticket/{ticketId}")
	    public boolean deleteTicketById(@PathVariable Integer ticketId){
	        return ticketBookingService.deleteTicketById(ticketId);
	    }

}
