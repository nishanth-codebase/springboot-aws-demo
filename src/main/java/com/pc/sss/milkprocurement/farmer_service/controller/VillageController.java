package com.pc.sss.milkprocurement.farmer_service.controller;

import com.pc.sss.milkprocurement.farmer_service.modal.Village;
import com.pc.sss.milkprocurement.farmer_service.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villages")
public class VillageController {

    @Autowired
    VillageService villageService;

    @PostMapping
    public ResponseEntity<?> addVillage(@RequestBody Village village){
        Village response=villageService.addVillage(village);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<?> getAllVillages(){
        List<Village> villages=villageService.getVillages();
        return ResponseEntity.ok(villages);
    }
}

