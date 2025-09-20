package com.milkproject.milkmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.milkproject.milkmanagement.DTOs.CreateFarmerDTO;
import com.milkproject.milkmanagement.exception.FarmerNotFoundException;
import com.milkproject.milkmanagement.modal.Farmer;
import com.milkproject.milkmanagement.service.FarmerService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/sgm/farmers")
@Slf4j
public class FarmerController {
	
	private static final Logger logger=LoggerFactory.getLogger(FarmerController.class);

	@Autowired
	private FarmerService farmerService;

	@PostMapping("/add/{boothId}")
	public ResponseEntity<?> createFarmer(@Valid @RequestBody CreateFarmerDTO request,@PathVariable("boothId") Long boothId) {
		try {
			Farmer createdFarmer = farmerService.createFarmer(request,boothId);	
			return ResponseEntity.status(HttpStatus.CREATED).body(createdFarmer);
		} catch (Exception e) {
			logger.error("Failed to create farmer:{}",request,e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Error occured while creating farmer:" + e.getMessage());
		}
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllFarmers() {
		try {
			List<Farmer> farmers = farmerService.getAllFarmers();
			return ResponseEntity.ok(farmers);
		} catch (Exception e) {
			logger.error("Failed to fetch all farmers:{}",e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Error Occured while fetching farmers:" + e.getMessage());
		}
	}

	@GetMapping("/by-booth/{boothId}")
	public ResponseEntity<?> getFarmersByBooth(@PathVariable("boothId") Long boothId) {
		try {
			List<Farmer> farmers = farmerService.getFarmersByBoothId(boothId);
			return ResponseEntity.status(HttpStatus.OK).body(farmers);
		} catch (Exception e) {
			logger.error("Failed to fetch farmers by booth "+ boothId +" :{}",e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Error Occured While fetching farmers by booth- " + boothId + " : " + e.getMessage());
		}
	}

	@GetMapping("/by-village")
	public ResponseEntity<?> getFarmersByVillage(@RequestParam String village) {
		try {
			List<Farmer> farmers = farmerService.getFarmersByVillage(village);
			return ResponseEntity.status(HttpStatus.OK).body(farmers);
		} catch (Exception e) {
			logger.error("Failed to fetch farmers by village "+ village +" :{}",e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Error Occured While fetching farmers by village-" + village + ":" + e.getMessage());
		}
	}

	@GetMapping("/by-village-and-booth")
	public ResponseEntity<?> getFarmersByVillage(@RequestParam String village, @RequestParam Long boothId) {
		try {
			List<Farmer> farmers = farmerService.getFarmersByVillageAndBooth(village, boothId);
			return ResponseEntity.status(HttpStatus.OK).body(farmers);
		} catch (Exception e) {
			logger.error("Failed to fetch farmers by village-"+ village+"and booth-" + boothId +" :{}",e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error Occured While fetching farmers by village-"
					+ village + " and booth-" + boothId + ":" + e.getMessage());
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateFarmer(@PathVariable("id") Long id, @RequestBody CreateFarmerDTO request) {
		try {
			Farmer updatedFarmer = farmerService.updateFarmerDetails(id, request);
			return ResponseEntity.status(HttpStatus.OK).body(updatedFarmer);
		} catch (FarmerNotFoundException e) {
			logger.error("unable to found the farmer having id-"+ id +" :{}",e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			logger.error("Failed to update farmer details having id- "+id +" farmer:" +request.toString() +" :{}",e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Error Occured While updating farmer details:" + e.getMessage());
		}
	}
	@PatchMapping("/inactivate/{id}")
	public ResponseEntity<?> updateToInactive(@PathVariable("id") Long id){
		try {
			logger.debug("farmer id|{}",id);
			System.out.println("checkid:"+id);
			Farmer farmer=farmerService.inActivateFarmer(id);
			return ResponseEntity.status(HttpStatus.OK).body(farmer); 
		}catch (FarmerNotFoundException e) {
			logger.error("unable to found the farmer having id-"+ id +" :{}",e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Farmer not found");
		} catch(Exception e) {
			logger.error("Failed to update farmer status having id- "+id+" :{}",e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Error Occured While updating farmer staus to inactive:" + e.getMessage());
		}
	}
	
	@PatchMapping("/activate/{id}")
	public ResponseEntity<?> updateToActive(@PathVariable("id") Long id){
		try {
			logger.debug("farmer id|{}",id);
			System.out.println("checkid:"+id);
			Farmer farmer=farmerService.activateFarmer(id);
			return ResponseEntity.status(HttpStatus.OK).body(farmer); 
		}catch (FarmerNotFoundException e) {
			logger.error("unable to found the farmer having id-"+ id +" :{}",e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch(Exception e) {
			logger.error("Failed to update farmer status having id- "+id+" :{}",e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Error Occured While updating farmer staus to inactive:" + e.getMessage());
		}
	}

}
