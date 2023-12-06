package com.group7.airplanesystembackend.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    private String adminName;

    // Getters
    public Long getAdminId() {
        return adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    // Setters
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

}

