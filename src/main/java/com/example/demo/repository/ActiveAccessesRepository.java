package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.ActiveAccesses;

public interface ActiveAccessesRepository extends JpaRepository<ActiveAccesses, Integer> {
	@Query(value="SELECT * FROM users_active_accesses where bank_id=:bankId", nativeQuery = true)
	public ActiveAccesses findActiveAccesses(@Param("bankId") String bankId);
}
