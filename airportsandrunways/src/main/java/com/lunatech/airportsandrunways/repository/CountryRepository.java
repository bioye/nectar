package com.lunatech.airportsandrunways.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lunatech.airportsandrunways.model.Country;

@Repository("countryRepository")
public interface CountryRepository extends JpaRepository<Country, Integer> {
	Country findByName(String name);
	Country findByCode(String code);
	Country findById(String id);
	
	@Query(name="airportFreq",
			nativeQuery=true,
			value = "select name, count(code)-1 as frequency from " + 
					"((select name, code from countries) union all " + 
					"(select null as name, iso_country as code from airports)) countries_airports " + 
					"group by code order by count(code)-1 desc limit 10")
	List<Map<String, Integer>> getCountriesWithMostAirports();
	
	@Query(name="airportFreq",
			nativeQuery=true,
			value = "select name, count(code)-1 as frequency from " + 
					"((select name, code from countries) union all " + 
					"(select null as name, iso_country as code from airports)) countries_airports " + 
					"group by code order by count(code)-1 asc limit 10")
	List<Map<String, Integer>> getCountriesWithLeastAirports();	
}