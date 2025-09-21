package com.pc.sss.milkprocurement.farmer_service.repository;

import com.pc.sss.milkprocurement.farmer_service.modal.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageRepository extends JpaRepository<Village,Long> {
}
