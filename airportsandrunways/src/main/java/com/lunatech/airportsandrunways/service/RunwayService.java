package com.lunatech.airportsandrunways.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lunatech.airportsandrunways.model.Runway;

public interface RunwayService {
	
	public Page<Runway> getRunwayByAirportId(int id, Pageable pageable);
	public Page<String> getDistinctSurfaces(Pageable pageable);
	public List<Map<Integer, Integer>> getCommonIdentifications();
}
