package com.pc.sss.milkprocurement.farmer_service.controller;

import com.pc.sss.milkprocurement.farmer_service.modal.MilkBooth;
import com.pc.sss.milkprocurement.farmer_service.modal.Village;
import com.pc.sss.milkprocurement.farmer_service.service.VillageService;
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
class VillageControllerTest {
    @Mock
    VillageService villageService;
    @InjectMocks
    VillageController villageController;

    @Test
    void addVillage() {
        Village village=new Village();
        village.setName("Velpuru");
        village.setId(32L);
        village.setPincode("522410");
        village.setMilkBooths(List.of(new MilkBooth()));

        when(villageService.addVillage(village)).thenReturn(village);

        ResponseEntity<?> response=villageController.addVillage(village);

        assertEquals(HttpStatus.CREATED,response.getStatusCode());
        Village responseVillage= (Village) response.getBody();
        assertEquals("Velpuru",responseVillage.getName());
    }

    @Test
    void getAllVillages() {
        Village village=new Village();
        village.setName("Velpuru");
        village.setId(32L);
        village.setPincode("522410");
        village.setMilkBooths(List.of(new MilkBooth()));

        when(villageService.getVillages()).thenReturn(List.of(village));

        ResponseEntity<?> response=villageController.getAllVillages();

        assertEquals(HttpStatus.OK,response.getStatusCode());
        List<Village> responseVillages= (List<Village>) response.getBody();
        assertEquals("Velpuru",responseVillages.get(0).getName());
    }
}