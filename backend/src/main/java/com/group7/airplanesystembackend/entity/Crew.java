package com.group7.airplanesystembackend.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "crew")
public class Crew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "crew_id")
    private Long crew_id;

    @Column(name = "crew_name")
    private String crew_name;

    // Getters and Setters
    public Long getcrew_id() {
        return crew_id;
    }

    public void setcrew_id(Long crew_id) {
        this.crew_id = crew_id;
    }
    
    public String getcrew_name() {
        return crew_name;
    }

    public void setcrew_name(String crew_name) {
        this.crew_name = crew_name;
    }

    public Crew createCrew(Crew crew) {
        return null;
    }

    public void deleteCrew(Long id) {
    }

}

