package com.lunatech.airportsandrunways;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportsRestController {
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping(path="/countries")
	public List<Country> getAlleCountries(){
		return countryService.getAllCountries();
	}
	@GetMapping(value = "/country/{id}")
	public Country getCountryById(@PathVariable("id") int id){
		return countryService.getCountryById(id);
	}

}
