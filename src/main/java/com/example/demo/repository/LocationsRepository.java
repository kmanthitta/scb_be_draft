package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Locations;

public interface LocationsRepository extends JpaRepository<Locations, Integer> {

	@Query(value = "SELECT location_name FROM locations", nativeQuery = true)
	public List<String> getLocations();
}
