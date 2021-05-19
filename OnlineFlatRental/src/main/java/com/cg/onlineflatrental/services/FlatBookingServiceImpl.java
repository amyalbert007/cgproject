package com.cg.onlineflatrental.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.dao.IFlatBookingJpaDao;
import com.cg.onlineflatrental.entities.FlatBooking;
import com.cg.onlineflatrental.exception.FlatBookingNotFoundException;

import com.cg.onlineflatrental.model.FlatBookingDTO;
import com.cg.onlineflatrental.util.FlatBookingUtils;

@Service
@Transactional
public class FlatBookingServiceImpl implements IFlatBookingService{
	
	
	@Autowired
	private IFlatBookingJpaDao iflatjpadao;
	
	String flatIdNotAvailable="flat with given id was not found";
	
	
	
	
	@Override
	public FlatBooking addFlatBooking1(FlatBooking flatBooking)
    {
        return iflatjpadao.saveAndFlush(flatBooking);
    }
	//@Override
	//public FlatBookingDTO addFlatBooking(FlatBooking flatBooking) {
		
		
		
		//return FlatBookingUtils.convertToFlatBookingDto(flatBooking);
	//}
	
	
	
	
	
	
	
	
	
	
	/*@Override
	public FlatBooking updateFlatBooking(FlatBooking flatBooking) {
		Integer bookingNo=flatBooking.getBookingNo();
		FlatBooking flat1=iflatjpadao.findById(bookingNo).get();
        flat1.setFlat(flatBooking.getFlat());
        flat1.setTenant(flatBooking.getTenant());
        flat1.setBookingFromDate(flatBooking.getBookingFromDate());
        flat1.setBookingToDate(flatBooking.getBookingToDate());
        return iflatjpadao.save(flat1);
		
		
		
		//return FlatBookingUtils.convertToFlatBookingDto(flatBooking);
	}*/
	
	@Override
	public FlatBooking updateFlatBooking(FlatBooking flat) throws FlatBookingNotFoundException {
		
		Optional<FlatBooking> optional=iflatjpadao.findById(flat.getBookingNo());
		if(optional.isPresent())
		{
			FlatBooking flat1=optional.get();
			
			flat1.setFlat(flat.getFlat());
	        flat1.setTenant(flat.getTenant());
	        flat1.setBookingFromDate(flat.getBookingFromDate());
	        flat1.setBookingToDate(flat.getBookingToDate());	
		return iflatjpadao.save(flat1);
		}
		else
		{
			 throw new FlatBookingNotFoundException(flatIdNotAvailable);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Override
	public boolean deleteFlatBookingbyId(int bookingNo) {
		
		FlatBooking existFlatBooking = iflatjpadao.findById(bookingNo).orElse(null);
		
		 iflatjpadao.deleteById(bookingNo);
		 if(null == existFlatBooking) {
			 return true;
			 
		 }
		 return false;
		 
	}*/
	
	
	@Override
	public boolean deleteFlatBookingbyId(int bookingNo) throws FlatBookingNotFoundException {
		
		Optional<FlatBooking> flat=iflatjpadao.findById(bookingNo);
		if(flat.isPresent())
		{
			
			iflatjpadao.deleteById(bookingNo);
			return true;
			
		}
		else {
			 throw new FlatBookingNotFoundException(flatIdNotAvailable);
		}
	
	}
	
	
	
	
	
	
	
	
	//@Override
	//public FlatBooking viewFlatBooking(int bookingNo) {
		
		//FlatBooking existFlatBooking = iflatjpadao.findById(bookingNo).orElse(null);
		
		
		//return iflatjpadao.findById(bookingNo).orElse(null);
	//}
	@Override
	public FlatBooking viewFlatBooking(int bookingNo) throws FlatBookingNotFoundException {
		
		Optional<FlatBooking> optional=iflatjpadao.findById(bookingNo);  
		if(optional.isPresent())
		{
			FlatBooking flat=optional.get();
			return flat;
		}
		else
		{
			throw new FlatBookingNotFoundException(flatIdNotAvailable);

		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<FlatBooking> viewAllFlatBooking() {
		//List<FlatBooking> flatbookingList = iflatjpadao.findAll();
		
		return iflatjpadao.findAll();
	}
	/*public static boolean validateFlatBooking(FlatBooking flatBooking) throws FlatBookingNotFoundException{
		
		boolean flag = false;
		if (flatBooking == null) {
			throw new FlatBookingNotFoundException("Flat Booking details cannot be blank");
		} else {
			validateBookingFromDate(flatBooking);
			validateBookingToDate(flatBooking);
			
			flag = true;
			
		}
		
		return flag;

	}
	public static boolean validateBookingFromDate(FlatBooking flatbooking) throws FlatBookingNotFoundException {
		
		boolean flag = false;
		if (flatbooking.getBookingFromDate() == null) {
			
			throw new FlatBookingNotFoundException("Booking_From_Date cannot be empty");
		} else if (flatbooking.getBookingFromDate().isAfter(LocalDate.now())) {
			
			throw new FlatBookingNotFoundException("Booking_From_Date cannot be after Current_System_Date");
		} else {
			flag = true;
			
		}
		
		return flag;
	}
	public static boolean validateBookingToDate(FlatBooking flatbooking) throws FlatBookingNotFoundException {
		
		boolean flag = false;
		if (flatbooking.getBookingToDate() == null) {
			
			throw new FlatBookingNotFoundException("Booking_To_Date cannot be empty");
		} else if (flatbooking.getBookingToDate().isBefore(flatbooking.getBookingFromDate())) {
			
			throw new FlatBookingNotFoundException("Booking_To_Date cannot be before Booking_From_Date");
		} else {
			flag = true;
			
		}
		
		return flag;
	}
	public boolean validateFlatBookingId(int id) throws FlatBookingNotFoundException {
		
		boolean flag = false;
		String flatbookingNotFound = "flatbooking id not found";
		if (!iflatjpadao.existsById(id)) {
			
			throw new FlatBookingNotFoundException(flatbookingNotFound);
		} 
		else
			flag = true;
		
		return flag;
	}*/

	

	
	

	

}

	

	
	


