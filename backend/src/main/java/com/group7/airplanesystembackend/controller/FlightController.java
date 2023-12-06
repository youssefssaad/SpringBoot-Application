package com.group7.airplanesystembackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.group7.airplanesystembackend.entity.Flight;
import com.group7.airplanesystembackend.service.FlightService;

import jakarta.persistence.EntityNotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    // Get all flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        if (flights.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(flights);
    }

    // Find flights based on criteria
    @GetMapping("/find")
    public ResponseEntity<List<Flight>> findFlights(@RequestParam String departureLocation,
                                                    @RequestParam String destination,
                                                    @RequestParam Date startDate,
                                                    @RequestParam Date endDate) {
        List<Flight> flights = flightService.findFlights(departureLocation, destination, startDate, endDate);
        if (flights.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(flights);
    }
    
    // Get a single flight by ID
    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        Optional<Flight> flight = flightService.getFlightById(id);
        if (!flight.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(flight.get());
    }

    // Create a new flight
    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight savedFlight = flightService.createFlight(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFlight);
    }

    // Update an existing flight
    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flightDetails) {
        try {
            Flight updatedFlight = flightService.updateFlight(id, flightDetails);
            return ResponseEntity.ok(updatedFlight);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a flight
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        try {
            flightService.deleteFlight(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
