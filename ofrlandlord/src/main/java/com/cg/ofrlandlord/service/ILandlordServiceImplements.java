package com.cg.ofrlandlord.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofrlandlord.dao.ILandlordJpaDao;
import com.cg.ofrlandlord.model.Landlord;





@Service
@Transactional
public class ILandlordServiceImplements implements ILandlordService{
	@Autowired
	private ILandlordJpaDao ilandlordjpadao;
	@Override
	public Landlord addLandlord(Landlord landlord)
    {
        return ilandlordjpadao.saveAndFlush(landlord);
    }
	
	@Override
	public Landlord updateLandlord(Landlord landlord) {
		Integer landlordId=landlord.getLandlordId();
		Landlord flat1=ilandlordjpadao.findById(landlordId).get();
        flat1.setLandlordName(landlord.getLandlordName());
        flat1.setLandlordAge(landlord.getLandlordAge());
        
        
        return ilandlordjpadao.save(flat1);
	}
	@Override
	public boolean deleteLandlordbyId(int landlordId) {
		
		Landlord existLandlord = ilandlordjpadao.findById(landlordId).orElse(null);
		
		ilandlordjpadao.deleteById(landlordId);
		 if(null == existLandlord) {
			 return true;
			 
		 }
		 return false;
		 
	}
	@Override
	public Landlord viewLandlord(int landlordId) {
		
		//FlatBooking existFlatBooking = iflatjpadao.findById(bookingNo).orElse(null);
		
		
		return ilandlordjpadao.findById(landlordId).orElse(null);
	}
	@Override
	public List<Landlord> viewAllLandlord() {
		//List<FlatBooking> flatbookingList = iflatjpadao.findAll();
		
		return ilandlordjpadao.findAll();
	}

}
