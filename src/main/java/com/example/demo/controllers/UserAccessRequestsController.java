package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserActiveAccesses;
import com.example.demo.repository.LocationsRepository;
import com.example.demo.entity.UserAccessRequests;
import com.example.demo.service.UserActiveAccessesService;
import com.example.demo.service.UserAccessRequestsService;

@RestController
public class UserAccessRequestsController {

	@Autowired
	UserAccessRequestsService reqService;

	@Autowired
	UserActiveAccessesService accService;

	@Autowired
	LocationsRepository locRepo;

	@PostMapping("/submitNewRequest")
	public void submitNewRequest(@RequestBody Map<String, Object> payload) {
		reqService.submitNewRequest(payload);
	}

	@PostMapping("/modifyUser")
	public void modifyUser(@RequestBody Map<String, Object> payload) {
		reqService.modifyUser(payload);
	}

	@GetMapping("/getActiveAccesses")
	public List<UserActiveAccesses> getActiveAccesses(@RequestParam String bankId) {
		return accService.findActiveAccesses(bankId);
	}

	@PostMapping("/deleteUser")
	public void deleteUser(@RequestParam String bankId) {
		reqService.deleteUser(bankId);
	}

	@GetMapping("/getRequests")
	public List<Map<String, Object>> getRequests(@RequestParam String email, @RequestParam String category) {
		return reqService.getRequests(email, category);
	}

	@GetMapping("/getOpenRequests")
	public List<Map<String, Object>> getOpenRequests(@RequestParam String bankId) {
		return reqService.getOpenRequests(bankId);
	}

	@GetMapping("/getClosedRequests")
	public List<UserAccessRequests> getClosedRequests(@RequestParam String bankId) {
		return reqService.getClosedRequests(bankId);
	}

	@PostMapping("/approveRequest")
	public void approveRequest(@RequestBody Map<String, Object> payload) {
		reqService.approveRequest(payload);
	}

	@GetMapping("/getDomains")
	public List<String> getDomains() {
		return reqService.getDomains();
	}

	@GetMapping("/getLocations")
	public List<String> getLocations() {
		return locRepo.getLocations();
	}
}
