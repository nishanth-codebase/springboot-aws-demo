package com.pc.sss.milkprocurement.farmer_service.service;

import com.pc.sss.milkprocurement.farmer_service.modal.MilkBooth;
import com.pc.sss.milkprocurement.farmer_service.modal.Village;
import com.pc.sss.milkprocurement.farmer_service.repository.MilkBoothRepository;
import com.pc.sss.milkprocurement.farmer_service.repository.VillageRepository;
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
class BoothServiceTest {
    @Mock
    MilkBoothRepository milkBoothRepository;

    @Mock
    VillageRepository villageRepository;

    @InjectMocks
    BoothService boothService;

    private final static Long villageId=23L;

    @Test
    void addBooth() {
        Village village=new Village();
        village.setName("Velpuru");
        village.setId(32L);
        village.setPincode("522410");
        village.setMilkBooths(new ArrayList<>());

        MilkBooth milkBooth=new MilkBooth();
        milkBooth.setId(23L);
        milkBooth.setName("Velpuru_Booth1");
        milkBooth.setVillage(village);
        milkBooth.setFarmers(new ArrayList<>());

        when(villageRepository.findById(villageId)).thenReturn(Optional.of(village));

        when(milkBoothRepository.save(milkBooth)).thenReturn(milkBooth);

        MilkBooth responseMilkBooth=boothService.addBooth(villageId,milkBooth);
        assertEquals(23L,responseMilkBooth.getId());
    }

    @Test
    void addBooth_VillageNotFound(){
        when(villageRepository.findById(villageId)).thenReturn(Optional.empty());
        RuntimeException exception=assertThrows(RuntimeException.class,
                ()->boothService.addBooth(villageId,new MilkBooth()));
        assertEquals("Village not found",exception.getMessage());
    }


    @Test
    void getListOfBoothsByVillage() {
        MilkBooth milkBooth=new MilkBooth();
        milkBooth.setId(23L);
        milkBooth.setName("Velpuru_Booth1");
        milkBooth.setVillage(new Village());
        milkBooth.setFarmers(new ArrayList<>());

        when(milkBoothRepository.findByVillageId(villageId)).thenReturn(Arrays.asList(milkBooth));

        List<MilkBooth> milkBoothList=boothService.getListOfBoothsByVillage(villageId);

        assertEquals(23L,milkBoothList.get(0).getId());

    }
}