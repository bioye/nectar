package com.lunatech.airportsandrunways.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lunatech.airportsandrunways.model.Country;

public interface CountryService {
	
	public List<Country> getAllCountries();
	public List<Map<String, Integer>> getCountriesWithMostAirports();
	public List<Map<String, Integer>> getCountriesWithLeastAirports();
	public Country getCountryByCode(String code);
	public Country getCountryByName(String name);
	public Country getCountryById(int id);
 
}
