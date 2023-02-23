package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserActiveAccesses;
import com.example.demo.repository.ActiveAccessesRepository;

@Service
public class ActiveAccessesService {
	@Autowired
	ActiveAccessesRepository repo;

	public List<UserActiveAccesses> findActiveAccesses(String bankId) {
		return repo.findActiveAccesses(bankId);
	}
}
