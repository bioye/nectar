package com.lunatech.airportsandrunways.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lunatech.airportsandrunways.model.Runway;
import com.lunatech.airportsandrunways.repository.RunwayRepository;

@Service("runwayService")
public class RunwayServiceImpl implements RunwayService {
	
	@Autowired
	private RunwayRepository runwayRepository;

	@Override
	public Page<Runway> getRunwayByAirportId(int id, Pageable pageable) {
		return runwayRepository.findByAirportId(id, pageable);
	}

	@Override
	public Page<String> getDistinctSurfaces(Pageable pageable) {
		return runwayRepository.findDistinctSurfaces(pageable);
	}

	@Override
	public List<Map<Integer, Integer>> getCommonIdentifications() {
		return runwayRepository.findCommonIdentifications();
	}

}
