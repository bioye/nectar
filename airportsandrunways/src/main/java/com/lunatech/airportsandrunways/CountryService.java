package com.lunatech.airportsandrunways;

import java.util.List;
import java.util.Map;

public interface CountryService {
	
	public List<Country> getAllCountries();
	public List<Map<String, Integer>> getCountriesWithMostAirports();
	public List<Map<String, Integer>> getCountriesWithLeastAirports();
	public Country getCountryByCode(String code);
	public Country getCountryByName(String name);
	public Country getCountryById(int id);
 
}
