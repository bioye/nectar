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
			value = "select airports.name, count(*) as "
			+ "frequency from runways inner join "
			+ "airports on runways.airport_id=airports.id "
			+ "group by airport_id order by count(*) desc limit 10")
	List<Map<String, Integer>> getCountriesWithMostAirports();
	
	@Query(name="airportFreq",
			nativeQuery=true,
			value = "select airports.name, count(*) as "
			+ "frequency from runways inner join "
			+ "airports on runways.airport_id=airports.id "
			+ "group by airport_id order by count(*) asc limit 10")
	List<Map<String, Integer>> getCountriesWithLeastAirports();
}