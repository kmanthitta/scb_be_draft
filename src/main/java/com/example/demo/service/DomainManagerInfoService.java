package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DomainManagerInfoRepository;

@Service
public class DomainManagerInfoService {
	
	@Autowired
	DomainManagerInfoRepository repo;
	
	public List<String> getDomains(){
		return repo.getDomains();
	}
}
