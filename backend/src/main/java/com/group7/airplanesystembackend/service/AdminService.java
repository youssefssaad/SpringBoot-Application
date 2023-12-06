package com.group7.airplanesystembackend.service;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group7.airplanesystembackend.entity.Admin;
import com.group7.airplanesystembackend.repository.AdminRepository;


@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;


    //Create
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
    
    // Delete
    public void deleteAdmin(Long adminId) {
        adminRepository.deleteById(adminId);
    }

    
    // Read a single admin
    public Optional<Admin> getAdminById(Long adminId) {
        return adminRepository.findById(adminId);
    }

    // Read all admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Update an admin
    public Admin updateAdmin(Long adminId, Admin adminDetails) {
        Admin admin = adminRepository.findById(adminId)
            .orElseThrow(() -> new EntityNotFoundException("Admin not found with id: " + adminId));
        admin.setAdminName(adminDetails.getAdminName());
        return adminRepository.save(admin);
    }

    public Object getAdminId(Long id) {
        return null;
    }

    public List<Admin> getAdmin() {
        return null;
    }
}
