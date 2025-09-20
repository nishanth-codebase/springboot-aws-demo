package com.milkproject.milkmanagement.DTOs;

import com.milkproject.milkmanagement.modal.Farmer;


public class FarmerDTO {
	private Long id;
    private String name;
    private String village;
    private String status;
    private String mobileNumber;

    public FarmerDTO(Farmer farmer) {
        this.id = farmer.getId();
        this.name = farmer.getName();
        this.village = farmer.getVillage();
        this.status = farmer.getStatus();
        this.mobileNumber = farmer.getMobileNumber();
    }
}
