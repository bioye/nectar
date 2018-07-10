package com.lunatech.airportsandrunways.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lunatech.airportsandrunways.model.Airport;

public interface AirportService {
	
	//public Iterable<Airport> getAllAirports();
	public Optional<Airport>  getAirportById(int id);
	//public List<Airport> findByCountryCode(String code);
	Page<Airport> findByCountryCode(String code, Pageable pageable);
}
