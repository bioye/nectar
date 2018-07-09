package com.lunatech.airportsandrunways.service;

import java.util.List;

import com.lunatech.airportsandrunways.model.Airport;

public interface AirportService {
	
	public List<Airport> getAllAirports();
	public Airport  getAirportById(int id);
	public List<Airport> findByCountryCode(String code);
	//public List<String> getAllAirportTypes();
	//public List<String> getUniqueTypes();
}
