package com.milkproject.milkmanagement.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreateFarmerDTO {
		@NotBlank
	    private String name;

	    @NotBlank
	    private String village;

	    @NotBlank
	    private String mobileNumber;
	    
	    @NotNull
	    private int pincode;
	    
	    @NotNull
	    private Long boothId;

		public Long getBoothId() {
			return boothId;
		}

		public void setBoothId(Long boothId) {
			this.boothId = boothId;
		}

		public String getName() {
			return name;
		}

		public String getVillage() {
			return village;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public int getPincode() {
			return pincode;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setVillage(String village) {
			this.village = village;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public void setPincode(int pincode) {
			this.pincode = pincode;
		}

		@Override
		public String toString() {
			return "CreateFarmerDTO [name=" + name + ", village=" + village + ", mobileNumber=" + mobileNumber
					+ ", pincode=" + pincode + ", boothId=" + boothId + "]";
		}

	    
}
