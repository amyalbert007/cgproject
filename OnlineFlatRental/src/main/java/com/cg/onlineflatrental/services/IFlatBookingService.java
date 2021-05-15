package com.cg.onlineflatrental.services;
import java.util.List;

import com.cg.onlineflatrental.entities.FlatBooking;
import com.cg.onlineflatrental.model.FlatBookingDTO;



public interface IFlatBookingService {
	public FlatBookingDTO addFlatBooking(FlatBooking flat);
	public FlatBookingDTO updateFlatBooking(FlatBooking flat);
	public FlatBookingDTO deleteFlatBooking(int id);
	public FlatBookingDTO viewFlatBooking(int id);
	public List<FlatBookingDTO> viewAllFlatBooking();
	
	//Iterable<FlatBooking> getAllBookings();
	//FlatBooking findBookingByNo(Integer bookingNo);
	//FlatBooking findBookingByEmail(String email);
	//FlatBooking updateEmailByNo(Integer bookingNo, String email);
	//FlatBooking  createFlatBooking(FlatBooking booking);
	//boolean deleteBookingByNo(Integer FlatBooking);

}
