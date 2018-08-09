package com.lunatech.airportsandrunways.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.lunatech.airportsandrunways.model.Runway;
@Repository("runwayRepository")
public interface RunwayRepository extends PagingAndSortingRepository<Runway, Integer> {
	Page<Runway> findByAirportId(int id, Pageable pageable);
	@Query(	nativeQuery=true,
			value = "select distinct surface from runways order by surface asc")
	Page<String> findDistinctSurfaces(Pageable pageable);
	@Query(nativeQuery=true,
			value = "select le_ident, count(*) as frequency from runways group "
			+ "by le_ident order by count(*) desc limit 10")
	List<Map<Integer, Integer>> findCommonIdentifications();
}