package com.lunatech.airportsandrunways.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lunatech.airportsandrunways.model.Airport;
import com.lunatech.airportsandrunways.repository.AirportRepository;

@Service("airportService")
public class AirportServiceImpl implements AirportService {
	
	@Autowired
	private AirportRepository airportRepository;

	@Override
	public Optional<Airport> getAirportById(int id) {
		return airportRepository.findById(id);
	}

	/*@Override
	public List<Airport> findByCountryCode(String code) {
		return airportRepository.findByCountryCode(code);
	}*/

	@Override
	public Page<Airport> findByCountryCode(String code, Pageable pageable) {
		return airportRepository.findByCountryCodeOrderByNameAsc(code, pageable);
	}

}
