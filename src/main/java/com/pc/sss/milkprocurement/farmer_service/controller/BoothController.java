package com.pc.sss.milkprocurement.farmer_service.controller;

import com.pc.sss.milkprocurement.farmer_service.modal.MilkBooth;
import com.pc.sss.milkprocurement.farmer_service.service.BoothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villages/{villageId}/booths")
public class BoothController {

    @Autowired
    BoothService boothService;

    @PostMapping
    public ResponseEntity<?> addBooth(@PathVariable Long villageId,
                                      @RequestBody MilkBooth milkBooth) {
        MilkBooth response = boothService.addBooth(villageId, milkBooth);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<?> getBooths(@PathVariable Long villageId) {

        List<MilkBooth> milkBoothList = boothService.getListOfBoothsByVillage(villageId);
        return ResponseEntity.ok(milkBoothList);
    }

}
