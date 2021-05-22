package com.cg.onlineflatrental.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.dao.IFlatBookingJpaDao;
import com.cg.onlineflatrental.entities.FlatBooking;
import com.cg.onlineflatrental.exception.FlatBookingNotFoundException;
import com.cg.onlineflatrental.exception.InvalidFlatInputException;


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
	//@Override
	//public FlatBooking addFlatBooking1(FlatBooking flatBooking)
   // {
   //     return iflatjpadao.saveAndFlush(flatBooking);
   // }
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
	
	
	
	
	
	
	
	
	//@Override
	//public FlatBooking viewFlatBooking(int bookingNo) {
		
		//FlatBooking existFlatBooking = iflatjpadao.findById(bookingNo).orElse(null);
		
		
		//return iflatjpadao.findById(bookingNo).orElse(null);
	//}
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*public static boolean validateFlatBooking(FlatBooking flatBooking) throws InvalidFlatInputException {
		
		boolean flatBooking=false;
		if(flatBooking==null)
		{
			throw new InvalidFlatInputException("Flat details cannot be null");
		}
		else
		{
			
			validateFlatBookingHouseNo(flat.getFlatAddress().getHouseNo());
			validateFlatBookingStreet(flat.getFlatAddress().getStreet());
			validateFlatBookingCity(flat.getFlatAddress().getCity());
			validateFlatBookingState(flat.getFlatAddress().getState());
			validateFlatBookingPin(flat.getFlatAddress().getPin());
			validateFlatBookingCountry(flat.getFlatAddress().getCountry());
			validateFlatBookingAvailability(flat.getAvailability());
			flag=true;
		}
		return flag;
	}

	public static boolean validateFlatCost(float cost) throws InvalidFlatInputException {
		
		boolean flag=false;
		if(cost > 0)
		{
			flag=true;			
		}
		else
		{
			throw new InvalidFlatInputException("Cost cannot be 0 or negative");
		}
		return flag;
	}

	public static boolean validateFlatAvailability(String availability) throws InvalidFlatInputException {

		boolean flag=false;
		if(availability.isEmpty())
		{
			throw new InvalidFlatInputException("Availability cannot be Empty");	
		}
		if(availability.equals("YES") || availability.equals("Yes") || availability.equals("yes") || availability.equals("Y") || availability.equals("y") || availability.equals("NO") ||availability.equals("No") || availability.equals("no") || availability.equals("N") || availability.equals("n") )
		{
			flag=true;
		}
		else
		{
			throw new InvalidFlatInputException("Availability can be only [YES | NO | Yes | No | yes | no | Y | N | y | n]");
		}
		return flag;
	}

	public static boolean validateFlatHouseNo(int houseNo) throws InvalidFlatInputException {
	
		boolean flag=false;
		if(houseNo <= 0 || Integer.toString(houseNo).isEmpty() )
		{
			throw new InvalidFlatInputException("House Number cannot be Empty or 0 or Negative");
		}
		else
		{
			flag=true;
		}
			return flag;
	}

	public static boolean validateFlatStreet(String street) throws InvalidFlatInputException {
		
		boolean flag=false;
		if(street.isEmpty())
		{
			throw new InvalidFlatInputException("Street cannot be Empty");
		}
		else if (!street.matches("^[A-Za-z]+$"))
		{
			throw new InvalidFlatInputException("Street cannot contain Numbers or Special Characters");
		}
		else
		{
			flag=true;
		}
		return flag;
	}
	
	public static boolean validateFlatCity(String city) throws InvalidFlatInputException {
		
		boolean flag=false;
		if(city.isEmpty())
		{
			throw new InvalidFlatInputException("City cannot be Empty");
		}
		else if (!city.matches("^[a-zA-Z ]+$"))
		{
			throw new InvalidFlatInputException("City cannot contain Numbers or Special Characters");
		}
		else
		{
			flag=true;
		}
		return flag;	
	}

	public static boolean validateFlatState(String state) throws InvalidFlatInputException {
		
		boolean flag=false;
		if(state.isEmpty())
		{
			throw new InvalidFlatInputException("State cannot be Empty");
		}
		else if (!state.matches("^[a-zA-Z ]+$"))
		{
			throw new InvalidFlatInputException("State cannot contain Numbers or Special Characters");
		}
		else
		{
			flag=true;
		}
		return flag;	
	}

	public static boolean validateFlatCountry(String country) throws InvalidFlatInputException {
		
		boolean flag=false;
		if(country.isEmpty())
		{
			throw new InvalidFlatInputException("Country cannot be Empty");
		}
		else if (!country.matches("^[a-zA-Z ]+$"))
		{
			throw new InvalidFlatInputException("Country cannot contain Numbers or Special Characters");
		}
		else
		{
			flag=true;
		}
		return flag;
	}

	public static boolean validateFlatPin(int pin) throws InvalidFlatInputException {
		
		boolean flag=false;
		if(pin<=0)
		{
			throw new InvalidFlatInputException("PinCode cannot be negative");	
		}
		else if(Integer.toString(pin).length() != 6)
		{
			throw new InvalidFlatInputException("PinCode should be of length 6");		
		}
		else if(!Integer.toString(pin).matches("^[0-9]+$"))
		{
			throw new InvalidFlatInputException("PinCode cannot contain Alphabets or Special Characters");	
		}
		else
		{
			flag=true;
		}
		return flag;
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

	

	
	


