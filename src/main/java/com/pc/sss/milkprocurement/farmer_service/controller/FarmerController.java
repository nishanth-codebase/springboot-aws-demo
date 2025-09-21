package com.pc.sss.milkprocurement.farmer_service.controller;

import com.pc.sss.milkprocurement.farmer_service.modal.Farmer;
import com.pc.sss.milkprocurement.farmer_service.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class FarmerController {

    @Autowired
    FarmerService farmerService;

    @PostMapping("/booths/{boothId}/farmers")
    public ResponseEntity<?> addFarmer(@PathVariable Long boothId,
                                       @RequestBody Farmer farmer){
        Farmer response=farmerService.addFarmerToBooth(boothId,farmer);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/booths/{boothId}/farmers")
    public List<Farmer> getFarmers(@PathVariable Long boothId){
        return farmerService.getFarmersByBooth(boothId);
    }

    @PatchMapping("/farmers/{farmerId}/status")
    public ResponseEntity<?> activateOrInactivateFarmer(@PathVariable Long farmerId){
        Farmer farmer=farmerService.statusUpdate(farmerId);
        return ResponseEntity.ok(farmer);
    }
}
