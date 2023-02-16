package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Requests;

public interface RequestsRepository extends JpaRepository<Requests, Integer> {
	@Query(value = "SELECT nextval('request_master_id_seq')", nativeQuery = true)
	public Integer getCount();
}
