package com.milkproject.milkmanagement.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.milkproject.milkmanagement.modal.Farmer;

@Repository
public interface FarmerRepo extends JpaRepository<Farmer,Long>{
	
	List<Farmer> findByBoothId(Long boothId);
	
	List<Farmer> findByVillage(String village);
	
	@Query("Select f FROM Farmer f WHERE f.booth.id= :boothId AND f.booth.village= :village")
	List<Farmer> findByVillageAndBooth(@Param("village") String village,@Param("boothId") Long boothId);
	
}
