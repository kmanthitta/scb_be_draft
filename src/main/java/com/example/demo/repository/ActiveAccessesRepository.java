package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.UserActiveAccesses;

public interface ActiveAccessesRepository extends JpaRepository<UserActiveAccesses, Integer> {
	@Query(value="SELECT * FROM users_active_accesses where bank_id=:bankId", nativeQuery = true)
	public List<UserActiveAccesses> findActiveAccesses(String bankId);
}
