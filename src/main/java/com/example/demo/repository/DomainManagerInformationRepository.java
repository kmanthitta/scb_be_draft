package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.DomainManagerInformation;

public interface DomainManagerInformationRepository extends JpaRepository<DomainManagerInformation, String>{
	@Query(value="SELECT domain_name from domain_manager_information", nativeQuery = true)
	public List<String> getDomains();
}
