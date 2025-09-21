package com.pc.sss.milkprocurement.farmer_service.service;

import com.pc.sss.milkprocurement.farmer_service.modal.Farmer;
import com.pc.sss.milkprocurement.farmer_service.modal.MilkBooth;
import com.pc.sss.milkprocurement.farmer_service.repository.FarmerRepository;
import com.pc.sss.milkprocurement.farmer_service.repository.MilkBoothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerService {
    @Autowired
    FarmerRepository farmerRepository;
    @Autowired
    MilkBoothRepository boothRepository;

    public Farmer addFarmerToBooth(Long boothId,Farmer farmer){
        MilkBooth booth=boothRepository.findById(boothId)
                .orElseThrow(()->new RuntimeException("Booth not found"));
        farmer.setMilkBooth(booth);
        return farmerRepository.save(farmer);
    }

    public List<Farmer> getFarmersByBooth(Long boothId) {
        return farmerRepository.findByMilkBoothId(boothId);
    }

    public Farmer statusUpdate(Long farmerId){
        Farmer farmer=farmerRepository.findById(farmerId)
                .orElseThrow(()->new RuntimeException("Farmer not found"));
        if(farmer.getStatus().equalsIgnoreCase("Active")){
            farmer.setStatus("InActive");
            return farmerRepository.save(farmer);
        }else {
            farmer.setStatus("Active");
            return farmerRepository.save(farmer);
        }
    }
}
