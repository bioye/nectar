package com.lunatech.airportsandrunways;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("airportRepository")
public interface AirportRepository extends JpaRepository<Airport, Integer> {
	List<Airport> findByCountryCode(String code);	
}
