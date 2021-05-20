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
import com.cg.onlineflatrental.exception.InvalidFlatInputException;
import com.cg.onlineflatrental.model.FlatBookingDTO;
import com.cg.onlineflatrental.util.FlatBookingUtils;

@Service
@Transactional
public class FlatBookingServiceImpl implements IFlatBookingService{
	
	
	@Autowired
	private IFlatBookingJpaDao iflatjpadao;
	
	String flatIdNotAvailable="flat with given id was not found";
	
	
	
	@Override
	public FlatBooking addFlatBooking1(FlatBooking flatBooking) throws InvalidFlatInputException {
		FlatBooking flatEntity;
		if(flatBooking==null)
		{
			throw new InvalidFlatInputException("Flat details cannot be null");
		}
		else
		{
		validateFlatBooking(flatBooking);
		flatEntity=iflatjpadao.saveAndFlush(flatBooking);
		
		}
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
	
	
	
	
	
	
public static boolean validateFlatBooking(FlatBooking flatBooking) throws InvalidFlatInputException {
		
		boolean flag=false;
		if(flatBooking==null)
		{
			throw new InvalidFlatInputException("Flat details cannot be null");
		}
		else
		{
			validateFlatCost(flatBooking.getFlat().getCost());
			validateFlatBookingHouseNo(flatBooking.getFlat().getFlatAddress().getHouseNo());
			validateFlatBookingStreet(flatBooking.getFlat().getFlatAddress().getStreet());
			validateFlatBookingCity(flatBooking.getFlat().getFlatAddress().getCity());
			validateFlatBookingState(flatBooking.getFlat().getFlatAddress().getState());
			//validateFlatBookingPin(flatBooking.getFlat().getFlatAddress().getPin());
			validateFlatBookingCountry(flatBooking.getFlat().getFlatAddress().getCountry());
			validateFlatBookingAvailability(flatBooking.getFlat().getAvialibilty());
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
public static boolean validateFlatBookingHouseNo(int houseNo) throws InvalidFlatInputException {
	
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
public static boolean validateFlatBookingStreet(String street) throws InvalidFlatInputException {
	
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
public static boolean validateFlatBookingCity(String city) throws InvalidFlatInputException {
	
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

public static boolean validateFlatBookingState(String state) throws InvalidFlatInputException {
	
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

public static boolean validateFlatBookingCountry(String country) throws InvalidFlatInputException {
	
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


public static boolean validateFlatBookingAvailability(String availability) throws InvalidFlatInputException {

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

	

	
	


