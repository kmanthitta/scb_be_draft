package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DomainManagerInformationRepository;

@Service
public class DomainManagerInformationService {
	
	@Autowired
	DomainManagerInformationRepository repo;
	
	public List<String> getDomains(){
		return repo.getDomains();
	}
}
