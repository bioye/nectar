package com.lunatech.airportsandrunways;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("airportService")
public class AirportServiceImpl implements AirportService {
	
	@Autowired
	private AirportRepository airportRepository;

	@Override
	public List<Airport> getAllAirports() {
		return airportRepository.findAll();
	}

	@Override
	public Airport getAirportById(int id) {
		return airportRepository.getOne(id);
	}

	@Override
	public List<Airport> findByCountryCode(String code) {
		return airportRepository.findByCountryCode(code);
	}

}
