package com.group7.airplanesystembackend.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Aircraft")
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aircraftId;
    
    private String model;
    private Integer capacity;

    // Getters
    public Long getAircraftId() {
        return aircraftId;
    }
    public String getModel() {
        return model;
    }
    public Integer getCapacity() {
        return capacity;
    }

    // Setters
    public void setAircraftId(Long aircraftId) {
        this.aircraftId = aircraftId;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
