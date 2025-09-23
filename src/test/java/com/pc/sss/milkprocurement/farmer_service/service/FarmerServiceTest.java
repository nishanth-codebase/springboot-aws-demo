package com.pc.sss.milkprocurement.farmer_service.service;

import com.pc.sss.milkprocurement.farmer_service.modal.Farmer;
import com.pc.sss.milkprocurement.farmer_service.modal.MilkBooth;
import com.pc.sss.milkprocurement.farmer_service.modal.Village;
import com.pc.sss.milkprocurement.farmer_service.repository.FarmerRepository;
import com.pc.sss.milkprocurement.farmer_service.repository.MilkBoothRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FarmerServiceTest {

    @Mock
    MilkBoothRepository milkBoothRepository;
    @Mock
    FarmerRepository farmerRepository;
    @InjectMocks
    FarmerService farmerService;

    private static final Long boothId=23L;

    @Test
    void addFarmerToBooth() {
        MilkBooth milkBooth=new MilkBooth();
        milkBooth.setId(23L);
        milkBooth.setName("Velpuru_Booth1");
        milkBooth.setVillage(new Village());
        milkBooth.setFarmers(new ArrayList<>());

        when(milkBoothRepository.findById(boothId)).thenReturn(Optional.of(milkBooth));

        Farmer farmer=new Farmer();
        farmer.setId(21L);
        farmer.setFirstName("Nishanth");
        farmer.setLastName("Juvva");

        when(farmerRepository.save(farmer)).thenReturn(farmer);
        Farmer farmerResponse=farmerService.addFarmerToBooth(boothId,farmer);

        assertEquals("Nishanth",farmerResponse.getFirstName());

    }
    @Test
    void addFarmerToBooth_BoothNotFound(){
        when(milkBoothRepository.findById(boothId)).thenReturn(Optional.empty());

        RuntimeException exception=assertThrows(RuntimeException.class,()->
                farmerService.addFarmerToBooth(boothId,new Farmer()));

        assertEquals("Booth not found",exception.getMessage());
    }

    @Test
    void getFarmersByBooth() {
        Farmer farmer=new Farmer();
        farmer.setId(21L);
        farmer.setFirstName("Nishanth");
        farmer.setLastName("Juvva");

        when(farmerRepository.findByMilkBoothId(boothId)).thenReturn(List.of(farmer));

        List<Farmer> farmerList=farmerService.getFarmersByBooth(boothId);
        assertEquals("Nishanth",farmerList.get(0).getFirstName());

    }

    @Test
    void statusUpdate() {
        Farmer farmer=new Farmer();
        farmer.setId(21L);
        farmer.setFirstName("Nishanth");
        farmer.setLastName("Juvva");
        farmer.setStatus("Active");

        when(farmerRepository.findById(32L)).thenReturn(Optional.of(farmer));

        when(farmerRepository.save(farmer)).thenReturn(farmer);

        Farmer farmerResponse=farmerService.statusUpdate(32L);
        assertEquals("InActive",farmerResponse.getStatus());
    }

    @Test
    void statusUpdate_FarmerNotFound(){
        when(farmerRepository.findById(32L)).thenReturn(Optional.empty());
        RuntimeException exception=assertThrows(RuntimeException.class,
                ()->farmerService.statusUpdate(32L));
        assertEquals("Farmer not found",exception.getMessage());
    }
}