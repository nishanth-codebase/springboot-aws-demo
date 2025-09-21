package com.pc.sss.milkprocurement.farmer_service.repository;

import com.pc.sss.milkprocurement.farmer_service.modal.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer,Long> {
    List<Farmer> findByMilkBoothId(Long boothId);
}
