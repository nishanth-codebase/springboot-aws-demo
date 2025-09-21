package com.pc.sss.milkprocurement.farmer_service.repository;

import com.pc.sss.milkprocurement.farmer_service.modal.MilkBooth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MilkBoothRepository extends JpaRepository<MilkBooth,Long> {
        List<MilkBooth> findByVillageId(Long villageId);
}
