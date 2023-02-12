package com.example.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RequestsService;

@RestController
public class RequestsController {
	
	@Autowired
	RequestsService reqService;
	
	@PostMapping("/test")
	public void submitRequest(@RequestBody Map<String, Object> payload) {
		reqService.test(payload);
	}
}
