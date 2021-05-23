package com.cg.onlineflatrental11.services;
import java.util.List;

import com.cg.onlineflatrental11.entities.FlatBooking;
import com.cg.onlineflatrental11.exception.FlatBookingNotFoundException;
import com.cg.onlineflatrental11.exception.InvalidFlatInputException;




public interface IFlatBookingService {
	
	public FlatBooking updateFlatBooking(FlatBooking flatBooking) throws FlatBookingNotFoundException;
	public boolean deleteFlatBookingbyId(int bookingNo)throws FlatBookingNotFoundException;
	public FlatBooking viewFlatBooking(int bookingNo) throws FlatBookingNotFoundException;
	public List<FlatBooking> viewAllFlatBooking();
	public FlatBooking addFlatBooking1(FlatBooking flatBooking) throws InvalidFlatInputException;
	
	

}
