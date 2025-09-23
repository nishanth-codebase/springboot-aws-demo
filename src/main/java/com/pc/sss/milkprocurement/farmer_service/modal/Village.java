package com.pc.sss.milkprocurement.farmer_service.modal;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Village {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String pincode;

    @OneToMany(mappedBy = "village",cascade = CascadeType.ALL)
    private List<MilkBooth> milkBooths=new ArrayList<>();

    public void addBooth(MilkBooth booth) {
        milkBooths.add(booth);
        booth.setVillage(this); // Link booth back to village
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public List<MilkBooth> getMilkBooths() {
        return milkBooths;
    }

    public void setMilkBooths(List<MilkBooth> milkBooths) {
        this.milkBooths = milkBooths;
    }
}
