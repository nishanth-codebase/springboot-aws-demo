package com.pc.sss.milkprocurement.farmer_service.service;

import com.pc.sss.milkprocurement.farmer_service.modal.Village;
import com.pc.sss.milkprocurement.farmer_service.repository.VillageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VillageServiceTest {
    @Mock
    VillageRepository villageRepository;
    @InjectMocks
    VillageService villageService;

    @Test
    void addVillage() {
        Village village=new Village();
        village.setName("Velpuru");
        village.setId(32L);
        village.setPincode("522410");
        village.setMilkBooths(new ArrayList<>());

        when(villageRepository.save(village)).thenReturn(village);

        Village response=villageService.addVillage(village);
        assertEquals("522410",response.getPincode());
    }

    @Test
    void getVillages() {
        Village village=new Village();
        village.setName("Velpuru");
        village.setId(32L);
        village.setPincode("522410");
        village.setMilkBooths(new ArrayList<>());

        when(villageRepository.findAll()).thenReturn(List.of(village));

        List<Village> response=villageService.getVillages();

        assertEquals("Velpuru",response.get(0).getName());
    }
}