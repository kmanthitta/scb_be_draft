package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Requests;

public interface RequestsRepository extends JpaRepository<Requests, Integer> {
	@Query(value = "SELECT max(request_id) FROM requests WHERE bank_id=:bankId", nativeQuery = true)
	public Integer getUserReqCount(String bankId);

	@Query(value = "SELECT * FROM requests WHERE line_manager_email=:email AND line_manager_approval_status='PENDING'", nativeQuery = true)
	public List<Requests> findOpenRequestsForLM(String email);

	@Query(value = "SELECT * FROM requests WHERE domain_manager_email=:email AND domain_manager_approval_status='PENDING' AND line_manager_approval_status='APPROVED'", nativeQuery = true)
	public List<Requests> findOpenRequestsForDM(String email);

	@Query(value = "SELECT * FROM requests WHERE (nas_admin_email=:email AND nas_admin_approval_status='PENDING') OR (bitbucket_admin_email=:email AND bitbucket_admin_approval_status='PENDING') OR (sas_admin_email=:email AND sas_admin_approval_status='PENDING') AND domain_manager_approval_status='APPROVED'", nativeQuery = true)
	public List<Requests> findOpenRequestsForAdmin(String email);

	@Query(value = "SELECT * FROM requests WHERE bank_id=:bankId AND status='UNDER APPROVAL'", nativeQuery = true)
	public List<Requests> findOpenRequests(String bankId);

	@Query(value = "SELECT * FROM requests WHERE bank_id=:bankId AND status!='UNDER APPROVAL'", nativeQuery = true)
	public List<Requests> findClosedRequests(String bankId);
}
