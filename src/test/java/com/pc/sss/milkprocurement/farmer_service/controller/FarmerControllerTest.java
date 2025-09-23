package com.pc.sss.milkprocurement.farmer_service.controller;

import com.pc.sss.milkprocurement.farmer_service.modal.Farmer;
import com.pc.sss.milkprocurement.farmer_service.modal.MilkBooth;
import com.pc.sss.milkprocurement.farmer_service.service.FarmerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FarmerControllerTest {
    @Mock
    FarmerService farmerService;

    @InjectMocks
    FarmerController farmerController;

    @Test
    void addFarmer() {
        Long boothId=32L;
        Farmer farmer=new Farmer();
        farmer.setId(21L);
        farmer.setFirstName("Nishanth");
        farmer.setLastName("Juvva");
        farmer.setStatus("Active");
        farmer.setMilkBooth(new MilkBooth());

        when(farmerService.addFarmerToBooth(boothId,farmer)).thenReturn(farmer);

        ResponseEntity<?> response=farmerController.addFarmer(boothId,farmer);

        assertEquals(HttpStatus.CREATED,response.getStatusCode());
        Farmer responseFarmer= (Farmer) response.getBody();
        assertEquals("Nishanth",responseFarmer.getFirstName());
    }

    @Test
    void getFarmers() {
        Long boothId=32L;
        Farmer farmer=new Farmer();
        farmer.setId(21L);
        farmer.setFirstName("Nishanth");
        farmer.setLastName("Juvva");
        farmer.setStatus("Active");
        farmer.setMilkBooth(new MilkBooth());

        when(farmerService.getFarmersByBooth(boothId)).thenReturn(List.of(farmer));

        List<Farmer> responseEntity= farmerController.getFarmers(boothId);

        assertEquals("Nishanth",responseEntity.get(0).getFirstName());

    }

    @Test
    void activateOrInactivateFarmer() {
        Long farmerId=23L;
        Farmer farmer=new Farmer();
        farmer.setId(farmerId);
        farmer.setFirstName("Nishanth");
        farmer.setLastName("Juvva");
        farmer.setStatus("Active");
        farmer.setMilkBooth(new MilkBooth());

        when(farmerService.statusUpdate(farmerId)).thenReturn(farmer);

        ResponseEntity<?> responseEntity=farmerController.activateOrInactivateFarmer(farmerId);
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }
}