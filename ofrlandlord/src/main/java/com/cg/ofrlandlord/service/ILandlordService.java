package com.cg.ofrlandlord.service;

import java.util.List;

import com.cg.ofrlandlord.model.Landlord;




public interface ILandlordService {
	public List<Landlord> viewAllLandlord();
	public Landlord viewLandlord(int landlordId);
	public boolean deleteLandlordbyId(int landlordId);
	public Landlord updateLandlord(Landlord landlord);
	public Landlord addLandlord(Landlord landlord);

}
