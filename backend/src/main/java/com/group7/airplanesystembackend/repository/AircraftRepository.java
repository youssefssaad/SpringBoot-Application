package com.group7.airplanesystembackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group7.airplanesystembackend.entity.Aircraft;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
}
