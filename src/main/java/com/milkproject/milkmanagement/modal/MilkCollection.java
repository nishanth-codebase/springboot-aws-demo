package com.milkproject.milkmanagement.modal;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="milk_collection")
public class MilkCollection {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private double milkQuantity;
	
	private double fatContent;
	
	private double ratePerLitre;
	
    private double totalAmount;

    private LocalDate collectionDate;
	

    @ManyToOne
    @JoinColumn(name = "farmer_id", nullable = false)
    private Farmer farmer;
    
    @PrePersist
    public void prePersist() {
        this.collectionDate = LocalDate.now(); // Auto-set date before saving
    }
	
	
}
