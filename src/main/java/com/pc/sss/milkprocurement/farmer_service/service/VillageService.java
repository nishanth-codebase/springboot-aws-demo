package com.pc.sss.milkprocurement.farmer_service.service;

import com.pc.sss.milkprocurement.farmer_service.modal.Village;
import com.pc.sss.milkprocurement.farmer_service.repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VillageService {

    @Autowired
    VillageRepository villageRepository;

    public Village addVillage(Village village){
        return villageRepository.save(village);
    }

    public List<Village> getVillages(){
        return villageRepository.findAll();
    }
}
