package com.cg.onlineflatrental11.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.onlineflatrental11.entities.FlatBooking;

@Repository
public interface IFlatBookingJpaDao extends JpaRepository<FlatBooking,Integer>{
	

}
