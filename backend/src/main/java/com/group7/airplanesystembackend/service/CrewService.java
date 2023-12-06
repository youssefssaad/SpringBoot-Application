package com.group7.airplanesystembackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group7.airplanesystembackend.entity.Crew;
import com.group7.airplanesystembackend.repository.CrewRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CrewService {

    @Autowired
    private CrewRepository crewRepository;


    //Create
    public Crew createCrew(Crew crew) {
        return crewRepository.save(crew);
    }

     // Read 
    public Optional<Crew> getCrewById(Long crew_id) {
        return crewRepository.findById(crew_id);
    }

    // Read all crews
    public List<Crew> getAllCrews() {
        return crewRepository.findAll();
    }


    //Update
    public Crew updateCrew(Long crew_id, Crew updatedCrew) {        
        Optional<Crew> optionalCrew = crewRepository.findById(crew_id);
        
        if (optionalCrew.isPresent()) {
            Crew existingCrew = optionalCrew.get();
            existingCrew.setcrew_name(updatedCrew.getcrew_name());
            return crewRepository.save(existingCrew);
        } else {
            throw new EntityNotFoundException("Crew not found");
        }
    }

    
    // Delete
    public void deleteCrew(Long crew_id) {
        crewRepository.deleteById(crew_id);
    }

    public Crew updateCrew(Crew crew) {
        return null;
    }
}
