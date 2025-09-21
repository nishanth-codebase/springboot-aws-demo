package com.pc.sss.milkprocurement.farmer_service.service;

import com.pc.sss.milkprocurement.farmer_service.modal.MilkBooth;
import com.pc.sss.milkprocurement.farmer_service.modal.Village;
import com.pc.sss.milkprocurement.farmer_service.repository.MilkBoothRepository;
import com.pc.sss.milkprocurement.farmer_service.repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoothService {

    @Autowired
    MilkBoothRepository milkBoothRepository;
    @Autowired
    VillageRepository villageRepository;

    public MilkBooth addBooth(Long villageId,MilkBooth milkBooth){
       Village village=villageRepository.findById(villageId)
               .orElseThrow(()->new RuntimeException("Village not found"));
       milkBooth.setVillage(village);
        return milkBoothRepository.save(milkBooth);
    }

    public List<MilkBooth> getListOfBoothsByVillage(Long villageId){
        return milkBoothRepository.findByVillageId(villageId);
    }
}
