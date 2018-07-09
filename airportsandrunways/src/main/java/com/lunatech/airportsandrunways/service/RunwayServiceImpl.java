package com.lunatech.airportsandrunways.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunatech.airportsandrunways.model.Runway;
import com.lunatech.airportsandrunways.repository.RunwayRepository;

@Service("runwayService")
public class RunwayServiceImpl implements RunwayService {
	
	@Autowired
	private RunwayRepository runwayRepository;

	@Override
	public List<Runway> getRunwayByAirportId(int id) {
		return runwayRepository.findByAirportId(id);
	}

	@Override
	public List<String> getDistinctSurfaces() {
		return runwayRepository.findDistinctSurfaces();
	}

	@Override
	public List<Map<Integer, Integer>> getCommonIdentifications() {
		return runwayRepository.findCommonIdentifications();
	}

}
