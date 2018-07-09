package com.lunatech.airportsandrunways.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lunatech.airportsandrunways.model.Airport;

@Repository("airportRepository")
public interface AirportRepository extends JpaRepository<Airport, Integer> {
	List<Airport> findByCountryCode(String code);	
}
