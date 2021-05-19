package com.cg.ofrlandlord.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofrlandlord.model.Landlord;
@Repository
public interface ILandlordJpaDao extends JpaRepository<Landlord,Integer>{
	

}
