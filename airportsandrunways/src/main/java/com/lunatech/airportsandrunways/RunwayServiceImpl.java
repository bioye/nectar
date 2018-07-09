package com.lunatech.airportsandrunways;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
