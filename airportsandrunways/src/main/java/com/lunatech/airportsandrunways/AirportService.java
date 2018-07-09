package com.lunatech.airportsandrunways;

import java.util.List;

public interface AirportService {
	
	public List<Airport> getAllAirports();
	public Airport  getAirportById(int id);
	public List<Airport> findByCountryCode(String code);
	//public List<String> getAllAirportTypes();
	//public List<String> getUniqueTypes();
}
