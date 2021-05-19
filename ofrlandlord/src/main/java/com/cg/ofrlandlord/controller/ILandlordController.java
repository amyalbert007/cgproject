package com.cg.ofrlandlord.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofrlandlord.model.Landlord;
import com.cg.ofrlandlord.service.ILandlordService;


@RestController
@RequestMapping("/landlord")
public class ILandlordController {
	@Autowired
	private ILandlordService ilandlordservice;
	
	@GetMapping("/viewAllLandlord")
	public List<Landlord> viewAllLandlord()
	{
		return (List<Landlord>) ilandlordservice.viewAllLandlord();
	}
	
	
	@GetMapping("/viewAllLandlord/{landlordId}")
	public Landlord getLandlordById(@PathVariable int landlordId){
		System.out.println("amit");
		return ilandlordservice.viewLandlord(landlordId);
	}
	@DeleteMapping("/deleteLandlord/{landlordId}")
	public boolean deleteLandlordbyId(@PathVariable int landlordId){
		return ilandlordservice.deleteLandlordbyId(landlordId);
	}
	@PutMapping("/updateLandlord")
	public Landlord updateFlatBooking(@RequestBody Landlord landlord){
			return ilandlordservice.updateLandlord(landlord);
		}
	@PostMapping("/addLandlord")
    public Landlord addLandlord(@RequestBody Landlord landlord)
    {
        return ilandlordservice.addLandlord(landlord);
    }
	

}
