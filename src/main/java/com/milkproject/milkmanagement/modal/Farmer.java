package com.milkproject.milkmanagement.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "farmer")
public class Farmer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name cannot be blank")
	private String name;

	@NotBlank(message = "village cannot be blank")
	private String village;

	@Min(value = 100000, message = "Pincode must be at least 6 digits")
	private int pincode;

	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
	private String mobileNumber;

	@Column(name = "status")
	private String status = "Active";
	
//	@NotNull(message="BoothId must not be null")
//	private Long boothId;
	
	@ManyToOne
	@JoinColumn(name="booth_id")
	private Booth booth;
	
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getVillage() {
		return village;
	}

	public int getPincode() {
		return pincode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getStatus() {
		return status;
	}
	
	public Booth getBooth() {
		return booth;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public void setBooth(Booth booth) {
		this.booth=booth;
	}

//	public void setBoothId(Long boothId) {
//		this.boothId = boothId;
//	}

	@Override
	public String toString() {
		return "Farmer [id=" + id + ", name=" + name + ", village=" + village + ", pincode=" + pincode
				+ ", mobileNumber=" + mobileNumber + ", status=" + status + ", booth=" + booth +"]";
	}

	
}
