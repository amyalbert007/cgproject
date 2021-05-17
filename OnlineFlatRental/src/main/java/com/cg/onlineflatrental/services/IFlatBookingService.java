package com.cg.onlineflatrental.services;
import java.util.List;

import com.cg.onlineflatrental.entities.FlatBooking;
import com.cg.onlineflatrental.model.FlatBookingDTO;



public interface IFlatBookingService {
	//public FlatBookingDTO addFlatBooking(FlatBooking flatBooking);
	public FlatBooking updateFlatBooking(FlatBooking flatBooking);
	public boolean deleteFlatBookingbyId(int bookingNo);
	public FlatBooking viewFlatBooking(int bookingNo);
	public List<FlatBooking> viewAllFlatBooking();
	public FlatBooking addFlatBooking1(FlatBooking flatBooking);
	
	

}
