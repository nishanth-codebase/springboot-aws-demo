package com.milkproject.milkmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milkproject.milkmanagement.DTOs.BoothDTO;
import com.milkproject.milkmanagement.modal.Booth;
import com.milkproject.milkmanagement.repos.BoothRepo;

@Service
public class BoothService {
	
	@Autowired
	BoothRepo boothRepo;
	
	public Booth createBooth(BoothDTO booth) {
		Booth createBooth=new Booth();
		createBooth.setBoothName(booth.getBoothName());	
		createBooth.setBoothOwnerName(booth.getBoothOwnerName());
		createBooth.setVillage(booth.getVillage());
		return boothRepo.save(createBooth);
	}
}
