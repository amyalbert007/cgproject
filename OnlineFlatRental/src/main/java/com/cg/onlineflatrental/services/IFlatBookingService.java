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
	
	

}
