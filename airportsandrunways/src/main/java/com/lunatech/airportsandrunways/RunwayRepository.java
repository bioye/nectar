package com.lunatech.airportsandrunways;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository("runwayRepository")
public interface RunwayRepository extends JpaRepository<Runway, Integer> {
	List<Runway> findByAirportId(int id);
	@Query(	nativeQuery=true,
			value = "select distinct surface from runways order by surface asc")
	List<String> findDistinctSurfaces();
	@Query(nativeQuery=true,
			value = "select le_ident, count(*) as frequency from runways group "
			+ "by le_ident order by count(*) desc limit 10")
	List<Map<Integer, Integer>> findCommonIdentifications();
}