package com.pc.sss.milkprocurement.farmer_service.controller;

import com.pc.sss.milkprocurement.farmer_service.modal.Farmer;
import com.pc.sss.milkprocurement.farmer_service.modal.MilkBooth;
import com.pc.sss.milkprocurement.farmer_service.modal.Village;
import com.pc.sss.milkprocurement.farmer_service.service.BoothService;
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
class BoothControllerTest {
    @Mock
    BoothService boothService;
    @InjectMocks
    BoothController boothController;

    private static final Long  villageId=21L;

    @Test
    void addBooth() {

        MilkBooth milkBooth=new MilkBooth();
        milkBooth.setId(23L);
        milkBooth.setName("Velpuru_Booth1");
        milkBooth.setVillage(new Village());
        milkBooth.setFarmers(List.of(new Farmer()));

        when(boothService.addBooth(villageId,milkBooth)).thenReturn(milkBooth);

        ResponseEntity<?> response= boothController.addBooth(villageId,milkBooth);

        assertEquals(HttpStatus.CREATED,response.getStatusCode());

        MilkBooth responseBooth= (MilkBooth) response.getBody();

        assertNotNull(responseBooth);

        assertEquals("Velpuru_Booth1",responseBooth.getName());
    }

    @Test
    void getBooths() {
        MilkBooth milkBooth=new MilkBooth();
        milkBooth.setId(23L);
        milkBooth.setName("Velpuru_Booth1");
        milkBooth.setVillage(new Village());
        milkBooth.setFarmers(List.of(new Farmer()));

        when(boothService.getListOfBoothsByVillage(villageId)).thenReturn(List.of(milkBooth));

        ResponseEntity<?> response=boothController.getBooths(villageId);

        assertEquals(HttpStatus.OK,response.getStatusCode());

        List<MilkBooth> milkBoothList= (List<MilkBooth>) response.getBody();

        assertEquals("Velpuru_Booth1",milkBoothList.get(0).getName());
    }
}