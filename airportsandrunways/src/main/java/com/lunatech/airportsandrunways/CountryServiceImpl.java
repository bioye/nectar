package com.lunatech.airportsandrunways;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("countryService")
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Override
	public Country getCountryByCode(String code) {
		return countryRepository.findByCode(code);
	}

	@Override
	public Country getCountryById(int id) {
		return countryRepository.getOne(id);
	}

	@Override
	public Country getCountryByName(String name) {
		return countryRepository.findByName(name);
	}
	
	@Override
	public List<Map<String, Integer>> getCountriesWithMostAirports() {
		return countryRepository.getCountriesWithMostAirports();
	}
	
	@Override
	public List<Map<String, Integer>> getCountriesWithLeastAirports() {
		return countryRepository.getCountriesWithLeastAirports();
	}

}