package com.cg.onlineflatrental.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.dao.IFlatBookingJpaDao;
import com.cg.onlineflatrental.entities.FlatBooking;
import com.cg.onlineflatrental.exception.FlatBookingNotFoundException;
import com.cg.onlineflatrental.exception.InvalidFlatInputException;
import com.cg.onlineflatrental.model.FlatBookingDTO;
import com.cg.onlineflatrental.util.FlatBookingUtils;

@Service
public class FlatBookingServiceImpl implements IFlatBookingService{
	String noFlat = "No FlatBooking found in given ID";
	
	@Autowired
	private IFlatBookingJpaDao iflatjpadao;

	
	@Override
	public FlatBookingDTO addFlatBooking(FlatBooking flatBooking) {
		
		FlatBooking flatbookingEntity;
		if (flatBooking == null)
			flatbookingEntity = null;
		else
		{
			//validateFlatBooking(flatBooking);
			flatbookingEntity = iflatjpadao.save(flatBooking);
		}
		
		return FlatBookingUtils.convertToFlatBookingDto(flatbookingEntity);
	}
	@Override
	public FlatBookingDTO updateFlatBooking(FlatBooking flatBooking) {
		
		//FlatBooking flatbookingEntity;
		//FlatBooking existFlatBooking = iflatjpadao.findById(flatBooking.getBookingNo()).orElse(null);
		/*if (existFlatBooking == null)
			throw new FlatBookingNotFoundException(noFlat);
		else
		{
			//validateFlatBooking(flatBooking);
			flatbookingEntity = iflatjpadao.save(flatBooking);
		}*/
		
		return FlatBookingUtils.convertToFlatBookingDto(flatBooking);
	}
	@Override
	public FlatBookingDTO deleteFlatBooking(int id) {
		//LOGGER.info("deleteFlatBooking() service is initiated");
		FlatBooking existFlatBooking = iflatjpadao.findById(id).orElse(null);
		//if (existFlatBooking == null)
			//throw new FlatBookingNotFoundException(noFlat);
	//	else
			//flatbookingRepo.delete(existFlatBooking);
		//LOGGER.info("deleteFlatBooking() service has executed");
		return FlatBookingUtils.convertToFlatBookingDto(existFlatBooking);
	}
	@Override
	public FlatBookingDTO viewFlatBooking(int id) {
		
		FlatBooking existFlatBooking = iflatjpadao.findById(id).orElse(null);
		//if (existFlatBooking == null)
		//	throw new FlatBookingNotFoundException(noFlat);
		
		return FlatBookingUtils.convertToFlatBookingDto(existFlatBooking);
	}
	@Override
	public List<FlatBookingDTO> viewAllFlatBooking() {
		List<FlatBooking> flatbookingList = iflatjpadao.findAll();
		
		return FlatBookingUtils.convertToFlatBookingDtoList(flatbookingList);
	}
	public static boolean validateFlatBooking(FlatBooking flatBooking) throws FlatBookingNotFoundException{
		
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
	}

	

	
	

	

}

	

	
	


