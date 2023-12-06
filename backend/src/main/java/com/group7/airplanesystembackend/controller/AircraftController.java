package com.group7.airplanesystembackend.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.group7.airplanesystembackend.entity.Aircraft;
import com.group7.airplanesystembackend.service.AircraftService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @GetMapping
    public ResponseEntity<List<Aircraft>> getAircraft() {
        List<Aircraft> aircraftList = aircraftService.getAllAircraft();
        
        if (aircraftList == null || aircraftList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(aircraftList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable Long id) {
        Optional<Aircraft> aircraft = aircraftService.getAircraftId(id);
        return aircraft.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aircraft> createAircraft(@RequestBody Aircraft aircraft) {
        Aircraft savedAircraft = aircraftService.createAircraft(aircraft);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAircraft);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aircraft> updateAircraft(@PathVariable Long id, @RequestBody Aircraft aircraft) {
        Optional<Aircraft> existingAircraft = aircraftService.getAircraftId(id);
        if (!existingAircraft.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        aircraft.setAircraftId(id);
        Aircraft updatedAircraft = aircraftService.updateAircraft(aircraft);
        return ResponseEntity.ok(updatedAircraft);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable Long id) {
        Optional<Aircraft> aircraft = aircraftService.getAircraftId(id);
        if (!aircraft.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        aircraftService.deleteAircraft(id);
        return ResponseEntity.ok().build();
    }
}
