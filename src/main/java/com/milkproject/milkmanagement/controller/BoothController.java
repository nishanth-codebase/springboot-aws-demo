package com.milkproject.milkmanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milkproject.milkmanagement.DTOs.BoothDTO;
import com.milkproject.milkmanagement.service.BoothService;

@RestController
@RequestMapping("/v1/sgm/booth")
public class BoothController {
	
	private static final Logger logger=LoggerFactory.getLogger(BoothController.class);
	
	@Autowired
	BoothService boothService;
	
	@PostMapping("/add")
	public ResponseEntity<?> createBooth(@RequestBody BoothDTO booth) {
		return  ResponseEntity.status(HttpStatus.CREATED).body(boothService.createBooth(booth));
	}
}
