package com.pc.sss.milkprocurement.farmer_service.modal;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private Long phoneNumber;

    private String status="Active";

    @ManyToOne
    @JoinColumn(name = "milk_booth_id")
    private MilkBooth milkBooth;

    public void setMilkBooth(MilkBooth milkBooth){
        this.milkBooth=milkBooth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public MilkBooth getMilkBooth() {
        return milkBooth;
    }
}
