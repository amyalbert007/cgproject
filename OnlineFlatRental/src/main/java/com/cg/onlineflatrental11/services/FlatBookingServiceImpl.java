package com.cg.onlineflatrental11.services;


import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental11.dao.IFlatBookingJpaDao;
import com.cg.onlineflatrental11.entities.FlatBooking;
import com.cg.onlineflatrental11.exception.FlatBookingNotFoundException;
import com.cg.onlineflatrental11.exception.InvalidFlatInputException;


@Service
@Transactional
public class FlatBookingServiceImpl implements IFlatBookingService{
	
	private static final Logger logger = LoggerFactory.getLogger(FlatBookingServiceImpl.class);
	
	
	@Autowired
	private IFlatBookingJpaDao iflatjpadao;
	
	String flatIdNotAvailable="flat with given id was not found";
	
	
	
	@Override
	public FlatBooking addFlatBooking1(FlatBooking flatBooking) throws InvalidFlatInputException {
		FlatBooking flatEntity;
		logger.info("===In Get Service===");
		logger.info("addFlatBooking1() service is initiated");
		if(flatBooking==null)
		{
			logger.error("Flat details cannot be null");
			throw new InvalidFlatInputException("Flat details cannot be null");
		}
		else
		{
		validateFlatBooking(flatBooking);
		flatEntity=iflatjpadao.saveAndFlush(flatBooking);
		
		}
		logger.info("addFlatBooking1() service has executed");
		return flatEntity;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public FlatBooking updateFlatBooking(FlatBooking flat) throws FlatBookingNotFoundException {
		logger.info("===In Put Service===");
		logger.info("updateFlatBooking() service is initiated");
		
		Optional<FlatBooking> optional=iflatjpadao.findById(flat.getBookingNo());
		if(optional.isPresent())
		{
			FlatBooking flat1=optional.get();
			
			flat1.setFlat(flat.getFlat());
	        flat1.setTenant(flat.getTenant());
	        flat1.setBookingFromDate(flat.getBookingFromDate());
	        flat1.setBookingToDate(flat.getBookingToDate());
	        logger.info("updateFlatBooking() service has executed");
		return iflatjpadao.save(flat1);
		}
		else
		{
			logger.error("flat with given id was not found");
			 throw new FlatBookingNotFoundException(flatIdNotAvailable);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean deleteFlatBookingbyId(int bookingNo) throws FlatBookingNotFoundException {
		logger.info("===In Delete Service===");
		logger.info("deleteFlatBookingbyId() service is initiated");
		
		Optional<FlatBooking> flat=iflatjpadao.findById(bookingNo);
		if(flat.isPresent())
		{
			
			iflatjpadao.deleteById(bookingNo);
			logger.info("deleteFlatBookingbyId() service has executed");
			return true;
			
		}
		else {
			logger.error("flat with given id was not found");
			 throw new FlatBookingNotFoundException(flatIdNotAvailable);
		}
	
	}
	
	
	
	
	
	
	
	
	
	@Override
	public FlatBooking viewFlatBooking(int bookingNo) throws FlatBookingNotFoundException {
		logger.info("===In Get Service===");
		logger.info("viewFlatBooking() service is initiated");
		
		Optional<FlatBooking> optional=iflatjpadao.findById(bookingNo);  
		if(optional.isPresent())
		{
			FlatBooking flat=optional.get();
			logger.info("viewFlatBooking() service has executed");
			return flat;
		}
		else
		{
			logger.error("flat with given id was not found");
			throw new FlatBookingNotFoundException(flatIdNotAvailable);

		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<FlatBooking> viewAllFlatBooking() {
		//List<FlatBooking> flatbookingList = iflatjpadao.findAll();
		logger.info("===In Get Service===");
		logger.info("viewAllFlatBooking() service is initiated");
		logger.info("viewAllFlatBooking() service has executed");
		return iflatjpadao.findAll();
	}
	
	
	
	
	
	
public static boolean validateFlatBooking(FlatBooking flatBooking) throws InvalidFlatInputException {
	
	logger.info("validateFlatBooking() is initiated");
		
		boolean flag=false;
		if(flatBooking==null)
		{
			logger.error("Flat details cannot be null");
			throw new InvalidFlatInputException("Flat details cannot be null");
		}
		else
		{
			validateFlatCost(flatBooking.getFlat().getCost());
			validateFlatBookingHouseNo(flatBooking.getFlat().getFlatAddress().getHouseNo());
			validateFlatBookingStreet(flatBooking.getFlat().getFlatAddress().getStreet());
			validateFlatBookingCity(flatBooking.getFlat().getFlatAddress().getCity());
			validateFlatBookingState(flatBooking.getFlat().getFlatAddress().getState());
			validateFlatBookingPin(flatBooking.getFlat().getFlatAddress().getPin());
			validateFlatBookingCountry(flatBooking.getFlat().getFlatAddress().getCountry());
			validateFlatBookingAvailability(flatBooking.getFlat().getAvialibilty());
			
			
			
			validateFlatBookingHouseNo(flatBooking.getTenant().getTenantAddress().getHouseNo());
			validateFlatBookingStreet(flatBooking.getTenant().getTenantAddress().getStreet());
			validateFlatBookingCity(flatBooking.getTenant().getTenantAddress().getCity());
			validateFlatBookingState(flatBooking.getTenant().getTenantAddress().getState());
			validateFlatBookingPin(flatBooking.getTenant().getTenantAddress().getPin());
			validateFlatBookingCountry(flatBooking.getTenant().getTenantAddress().getCountry());
			
			
			
			
			
			
			flag=true;
			logger.info("Validation Successful");
		}
		logger.info("validateFlat() has executed");
		return flag;
	}
public static boolean validateFlatBookingPin(long pin) throws InvalidFlatInputException {
	logger.info("validateFlatBookingPin() is initiated");
	
	boolean flag=false;
	if(pin<=0)
	{
		logger.error("PinCode cannot be negative");
		throw new InvalidFlatInputException("PinCode cannot be negative");	
	}
	else if(Long.toString(pin).length() != 6)
	{
		logger.error("PinCode should be of length 6");
		throw new InvalidFlatInputException("PinCode should be of length 6");		
	}
	else if(!Long.toString(pin).matches("^[0-9]+$"))
	{
		logger.error("PinCode cannot contain Alphabets or Special Characters");
		throw new InvalidFlatInputException("PinCode cannot contain Alphabets or Special Characters");	
	}
	else
	{
		flag=true;
		logger.info("Validation Successful");
	}
	logger.info("validateFlatBookingPin() has executed");
	return flag;
}
public static boolean validateFlatCost(float cost) throws InvalidFlatInputException {
	logger.info("validateFlatCost() is initiated");
	
	boolean flag=false;
	if(cost > 0)
	{
		flag=true;	
		logger.info("Validation Successful");
	}
	else
	{
		logger.error("Cost cannot be empty or 0 or negative");
		throw new InvalidFlatInputException("Cost cannot be 0 or negative");
	}
	logger.info("validateFlatCost() has executed");
	return flag;
}
public static boolean validateFlatBookingHouseNo(int houseNo) throws InvalidFlatInputException {
	logger.info("validateFlatBookingHouseNo() is initiated");
	
	boolean flag=false;
	if(houseNo <= 0 || Integer.toString(houseNo).isEmpty() )
	{
		logger.error("House Number cannot be Empty or 0 or Negative");
		throw new InvalidFlatInputException("House Number cannot be Empty or 0 or Negative");
	}
	else
	{
		flag=true;
		logger.info("Validation Successful");
	}
	logger.info("validateFlatBookingHouseNo() has executed");
		return flag;
}
public static boolean validateFlatBookingStreet(String street) throws InvalidFlatInputException {
	logger.info("validateFlatBookingStreet() is initiated");
	
	boolean flag=false;
	if(street.isEmpty())
	{
		logger.error("Street cannot be Empty");
		throw new InvalidFlatInputException("Street cannot be Empty");
	}
	else if (!street.matches("^[A-Za-z]+$"))
	{
		logger.error("Street cannot contain Numbers or Special Characters");
		throw new InvalidFlatInputException("Street cannot contain Numbers or Special Characters");
	}
	else
	{
		flag=true;
		logger.info("Validation Successful");
	}
	logger.info("validateFlatBookingStreet() has executed");
	return flag;
}
public static boolean validateFlatBookingCity(String city) throws InvalidFlatInputException {
	logger.info("validateFlatBookingCity() is initiated");
	
	boolean flag=false;
	if(city.isEmpty())
	{
		logger.error("City cannot be Empty");
		throw new InvalidFlatInputException("City cannot be Empty");
	}
	else if (!city.matches("^[a-zA-Z ]+$"))
	{
		logger.error("City cannot contain Numbers or Special Characters");
		throw new InvalidFlatInputException("City cannot contain Numbers or Special Characters");
	}
	else
	{
		flag=true;
		logger.info("Validation Successful");
	}
	logger.info("validateFlatCity() has executed");
	return flag;	
}

public static boolean validateFlatBookingState(String state) throws InvalidFlatInputException {
	logger.info("validateFlatState() is initiated");
	
	boolean flag=false;
	if(state.isEmpty())
	{
		logger.error("State cannot be Empty");
		throw new InvalidFlatInputException("State cannot be Empty");
	}
	else if (!state.matches("^[a-zA-Z ]+$"))
	{
		logger.error("State cannot contain Numbers or Special Characters");
		throw new InvalidFlatInputException("State cannot contain Numbers or Special Characters");
	}
	else
	{
		flag=true;
		logger.info("Validation Successful");
	}
	logger.info("validateFlatState() has executed");
	return flag;	
}

public static boolean validateFlatBookingCountry(String country) throws InvalidFlatInputException {
	logger.info("validateFlatCountry() is initiated");
	
	boolean flag=false;
	if(country.isEmpty())
	{
		logger.error("Country cannot be Empty");
		throw new InvalidFlatInputException("Country cannot be Empty");
	}
	else if (!country.matches("^[a-zA-Z ]+$"))
	{
		logger.error("Country cannot contain Numbers or Special Characters");
		throw new InvalidFlatInputException("Country cannot contain Numbers or Special Characters");
	}
	else
	{
		flag=true;
		logger.info("Validation Successful");
	}
	logger.info("validateFlatCountry() has executed");
	return flag;
}


public static boolean validateFlatBookingAvailability(String availability) throws InvalidFlatInputException {
	logger.info("validateFlatAvailability() is initiated");

	boolean flag=false;
	if(availability.isEmpty())
	{
		logger.error("Availability cannot be Empty");
		throw new InvalidFlatInputException("Availability cannot be Empty");	
	}
	if(availability.equals("YES") || availability.equals("Yes") || availability.equals("yes") || availability.equals("Y") || availability.equals("y") || availability.equals("NO") ||availability.equals("No") || availability.equals("no") || availability.equals("N") || availability.equals("n") )
	{
		logger.info("Validation Successful");
		flag=true;
	}
	else
	{
		logger.error("Availability can be only [YES | NO | Yes | No | yes | no | Y | N | y | n]");
		
		throw new InvalidFlatInputException("Availability can be only [YES | NO | Yes | No | yes | no | Y | N | y | n]");
	}
	logger.info("validateFlatAvailability() has executed");
	return flag;
}
	


	

	
	

	

}

	

	
	


