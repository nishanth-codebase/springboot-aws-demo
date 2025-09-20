package com.milkproject.milkmanagement.modal;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "booth")
public class Booth {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(unique = true, nullable = false)
    private String boothName;

    private String village;
    
    private String boothOwnerName;
    
    @OneToMany(mappedBy="booth")
    private List<Farmer> farmers;

	public Long getId() {
		return id;
	}

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
		return "Booth [id=" + id + ", boothName=" + boothName + ", village=" + village + ", boothOwnerName="
				+ boothOwnerName + "]";
	}

}
