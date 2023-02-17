package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Requests;

public interface RequestsRepository extends JpaRepository<Requests, Integer> {
	@Query(value = "SELECT nextval('request_master_id_seq')", nativeQuery = true)
	public Integer getCount();

	@Query(value = "SELECT * FROM usermgm.requests WHERE :approverEmailFieldName=:email AND :approverStatusFieldName='PENDING'", nativeQuery = true)
	public Requests findOpenRequestsForApprover(String email, String approverEmailFieldName,
			String approverStatusFieldName);

	@Query(value = "SELECT * FROM usermgm.requests WHERE bank_id=:bankId AND status='UNDER APPROVAL'", nativeQuery = true)
	public Requests findOpenRequests(String bankId);

	@Query(value = "SELECT * FROM usermgm.requests WHERE bank_id=:bankId AND status!='UNDER APPROVAL'", nativeQuery = true)
	public Requests findClosedRequests(String bankId);
}
