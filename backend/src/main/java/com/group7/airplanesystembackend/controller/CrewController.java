package com.group7.airplanesystembackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.group7.airplanesystembackend.entity.Crew;
import com.group7.airplanesystembackend.service.CrewService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/crew")
public class CrewController {

    @Autowired
    private CrewService crewService;

    @GetMapping
    public ResponseEntity<List<Crew>> getAllCrews() {
        try {
            List<Crew> crewList = crewService.getAllCrews();
            if (crewList.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(crewList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Crew> getCrewById(@PathVariable Long id) {
        try {
            return crewService.getCrewById(id)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Crew> createCrew(@RequestBody Crew crew) {
        try {
            Crew savedCrew = crewService.createCrew(crew);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCrew);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Crew> updateCrew(@PathVariable Long id, @RequestBody Crew updatedCrewData) {
        try {
            Optional<Crew> existingCrewOptional = crewService.getCrewById(id);
            
            if (existingCrewOptional.isPresent()) {
                Crew existingCrew = existingCrewOptional.get();
                existingCrew.setcrew_name(updatedCrewData.getcrew_name());
                
                Crew updatedCrew = crewService.updateCrew(existingCrew);
                
                if (updatedCrew == null) {
                    return ResponseEntity.notFound().build();
                }
                
                return ResponseEntity.ok(updatedCrew);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrew(@PathVariable Long id) {
        try {
            crewService.deleteCrew(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
