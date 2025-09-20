package com.milkproject.milkmanagement.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milkproject.milkmanagement.DTOs.CreateFarmerDTO;
import com.milkproject.milkmanagement.exception.FarmerNotFoundException;
import com.milkproject.milkmanagement.modal.Booth;
import com.milkproject.milkmanagement.modal.Farmer;
import com.milkproject.milkmanagement.repos.BoothRepo;
import com.milkproject.milkmanagement.repos.FarmerRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FarmerService {

	@Autowired
	private FarmerRepo milkRepo;
	@Autowired
	private BoothRepo boothRepo;

	public Farmer createFarmer(CreateFarmerDTO request,Long boothId) {
		
		Booth booth=boothRepo.findById(request.getBoothId()).orElse(null);
		Farmer farmer=new Farmer();
		farmer.setBooth(booth);
//		farmer.setBoothId(boothId);
		farmer.setName(request.getName());
		farmer.setPincode(request.getPincode());
		farmer.setVillage(request.getVillage());
		farmer.setMobileNumber(request.getMobileNumber());
		return milkRepo.save(farmer);
	}

	public List<Farmer> getAllFarmers() {
		return milkRepo.findAll();
	}

	public List<Farmer> getFarmersByBoothId(Long boothId) {
		return milkRepo.findByBoothId(boothId);
	}

	public List<Farmer> getFarmersByVillage(String village) {
		return milkRepo.findByVillage(village);
	}

	public List<Farmer> getFarmersByVillageAndBooth(String village, Long boothId) {
		return milkRepo.findByVillageAndBooth(village, boothId);
	}

	public Farmer updateFarmerDetails(Long id, CreateFarmerDTO request) {
		Farmer update = milkRepo.findById(id)
				.orElseThrow(() -> new FarmerNotFoundException("Farmer not found with this id:" + id));
		
		if (Objects.nonNull(request.getName())) {
			update.setName(request.getName());
		}
		if (Objects.nonNull(request.getVillage())) {
			update.setVillage(request.getVillage());
		}
		if (Objects.nonNull(request.getPincode())) {
			update.setPincode(request.getPincode());
		}
		if (Objects.nonNull(request.getMobileNumber())) {
			update.setMobileNumber(request.getMobileNumber());
		}
		Booth booth=boothRepo.findById(request.getBoothId()).orElse(null);
		if(Objects.nonNull(booth)) {
			update.setBooth(booth);
		}
		return milkRepo.save(update);
	}
	
	public Farmer inActivateFarmer(Long id) {
		Optional<Farmer> optional = milkRepo.findById(id);
	    System.out.println("Farmer found? " + optional.isPresent()); 
	    Farmer farmer = optional.orElseThrow(() -> new FarmerNotFoundException("Farmer not found with this id:" + id));
	    farmer.setStatus("InActive");
		return milkRepo.save(farmer);
	}
	
	public Farmer activateFarmer(Long id) {
		Optional<Farmer> optional = milkRepo.findById(id);
	    Farmer farmer = optional.orElseThrow(() -> new FarmerNotFoundException("Farmer not found with this id:" + id));
	    farmer.setStatus("Active");
	    return milkRepo.save(farmer);
	}

}
