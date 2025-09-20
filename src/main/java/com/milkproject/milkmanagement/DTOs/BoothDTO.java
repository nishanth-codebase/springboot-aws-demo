package com.milkproject.milkmanagement.DTOs;

public class BoothDTO {
	
	private String boothName;
	
	private String village;
    
    private String boothOwnerName;

    public String getBoothName() {
		return boothName;
	}

	public String getVillage() {
		return village;
	}

	public String getBoothOwnerName() {
		return boothOwnerName;
	}

	public void setBoothName(String boothName) {
		this.boothName = boothName;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public void setBoothOwnerName(String boothOwnerName) {
		this.boothOwnerName = boothOwnerName;
	}
	
	@Override
	public String toString() {
		return "BoothDTO [boothName=" + boothName + ", village=" + village + ", boothOwnerName=" + boothOwnerName + "]";
	}


}
