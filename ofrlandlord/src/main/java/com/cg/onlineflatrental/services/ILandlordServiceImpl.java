package com.cg.onlineflatrental.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.dao.ILandlordJpaDao;
import com.cg.onlineflatrental.exception.InvalidLandlordInputException;
import com.cg.onlineflatrental.exception.LandlordNotFoundException;
import com.cg.onlineflatrental.model.Landlord;

@Service
@Transactional
public class ILandlordServiceImpl implements ILandlordService {

	@Autowired
	private ILandlordJpaDao ilandlordjpadao;
	
	String landlordIdNotAvailable="landlord with given id was not found";

	@Override
	public Landlord addLandlord(Landlord landlord) throws InvalidLandlordInputException{
		Landlord landlordEntity;
		//logger.info("===In Get Service===");
		//logger.info("addLandlord() service is initiated");
		if(landlord==null)
		{
			//logger.error("landlord details cannot be null");
			throw new InvalidLandlordInputException("landlord details cannot be null");
		}
		else
		{
		//validateFlatBooking(flatBooking);
			landlordEntity=ilandlordjpadao.saveAndFlush(landlord);
		
		}
		//logger.info("addFlatBooking1() service has executed");
		return landlordEntity;
	}


	@Override
	public Landlord updateLandlord(Landlord landlord) throws LandlordNotFoundException {
		//logger.info("===In Put Service===");
		//logger.info("updateFlatBooking() service is initiated");
		
		Optional<Landlord> optional=ilandlordjpadao.findById(landlord.getLandlordId());
		if(optional.isPresent())
		{
			Landlord landlord1=optional.get();
			
			
		landlord1.setLandlordName(landlord.getLandlordName());
		landlord1.setLandlordAge(landlord.getLandlordAge());
		landlord1.setFlat(landlord.getFlat());
		
		return ilandlordjpadao.save(landlord1);
		}
		else
		{
			//logger.error("flat with given id was not found");
			 throw new LandlordNotFoundException(landlordIdNotAvailable);
		}


	}

	@Override
	public  boolean deleteLandlordById(int landlordId) throws LandlordNotFoundException {
		//logger.info("===In Delete Service===");
		//logger.info("deleteFlatBookingbyId() service is initiated");
		
		Optional<Landlord> flat=ilandlordjpadao.findById(landlordId);
		if(flat.isPresent())
		{
			
			ilandlordjpadao.deleteById(landlordId);
			//logger.info("deleteFlatBookingbyId() service has executed");
			return true;
			
		}
		else {
			//logger.error("flat with given id was not found");
			 throw new LandlordNotFoundException(landlordIdNotAvailable);
		}
	}

	@Override
	public Landlord  viewLandlordById(int landlordId) throws LandlordNotFoundException {
		//logger.info("===In Get Service===");
		//logger.info("viewFlatBooking() service is initiated");
		
		Optional<Landlord> optional=ilandlordjpadao.findById(landlordId);  
		if(optional.isPresent())
		{
			Landlord flat=optional.get();
			//logger.info("viewFlatBooking() service has executed");
			return flat;
		}
		else
		{
			//logger.error("flat with given id was not found");
			throw new LandlordNotFoundException(landlordIdNotAvailable);
		}

	}

		

	@Override
	public List<Landlord>viewAllLandlord() {
		return ilandlordjpadao.findAll();
	}

}