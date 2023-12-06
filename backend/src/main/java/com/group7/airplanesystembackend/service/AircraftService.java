package com.group7.airplanesystembackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group7.airplanesystembackend.entity.Aircraft;
import com.group7.airplanesystembackend.repository.AircraftRepository;

@Service
public class AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

    public Aircraft createAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    public List<Aircraft> getAllAircraft() {
        return aircraftRepository.findAll();
    }

    public Optional<Aircraft> getAircraftId(Long id) {
        return aircraftRepository.findById(id);
    }

    public Aircraft updateAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    public void deleteAircraft(Long id) {
        aircraftRepository.deleteById(id);
    }
}
