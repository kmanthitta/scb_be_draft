package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ActiveAccesses;
import com.example.demo.service.ActiveAccessesService;
import com.example.demo.service.RequestsService;

@RestController
public class RequestsController {

	@Autowired
	RequestsService reqService;
	
	@Autowired
	ActiveAccessesService accService;

	@PostMapping("/submitNewRequest")
	public void submitNewRequest(@RequestBody Map<String, Object> payload) {
		reqService.submitNewRequest(payload);
	}
	
	@PostMapping("/modifyUser")
	public void modifyUser(@RequestBody Map<String, Object> payload) {
		reqService.modifyUser(payload);
	}
	
	@GetMapping("/getActiveAccesses")
	public List<ActiveAccesses> getActiveAccesses(@RequestParam String bankId){
		return accService.findActiveAccesses(bankId);
	}
	
	@PostMapping("/deleteUser")
	public void deleteUser(@RequestParam String bankId) {
		reqService.deleteUser(bankId);
	}

}
