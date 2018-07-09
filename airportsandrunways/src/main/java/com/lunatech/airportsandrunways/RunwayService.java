package com.lunatech.airportsandrunways;

import java.util.List;
import java.util.Map;

public interface RunwayService {
	
	public List<Runway> getRunwayByAirportId(int id);
	public List<String> getDistinctSurfaces();
	public List<Map<Integer, Integer>> getCommonIdentifications();
}
