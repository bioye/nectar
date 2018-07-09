package com.lunatech.airportsandrunways.service;

import java.util.List;
import java.util.Map;

import com.lunatech.airportsandrunways.model.Runway;

public interface RunwayService {
	
	public List<Runway> getRunwayByAirportId(int id);
	public List<String> getDistinctSurfaces();
	public List<Map<Integer, Integer>> getCommonIdentifications();
}
