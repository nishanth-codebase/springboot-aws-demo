package com.milkproject.milkmanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milkproject.milkmanagement.modal.Booth;

@Repository
public interface BoothRepo extends JpaRepository<Booth,Long>{
	
	Booth findByBoothName(String boothName);
}
