package com.group7.airplanesystembackend.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.group7.airplanesystembackend.entity.Flight;
import com.group7.airplanesystembackend.repository.FlightRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    // Create
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }
    

    // Update
    public Flight updateFlight(Long id, Flight updatedFlight) throws EntityNotFoundException {
        Flight existingFlight = flightRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Flight not found"));

        existingFlight.setDepartureLocation(updatedFlight.getDepartureLocation());
        existingFlight.setDestination(updatedFlight.getDestination());
        existingFlight.setDepartureTime(updatedFlight.getDepartureTime());
        existingFlight.setArrivalTime(updatedFlight.getArrivalTime());
        existingFlight.setPrice(updatedFlight.getPrice());
            return flightRepository.save(existingFlight);
    }


    // Delete
    public void deleteFlight(Long flightId) throws EntityNotFoundException {
        Flight flight = flightRepository.findById(flightId)
            .orElseThrow(() -> new EntityNotFoundException("Flight not found"));
        flightRepository.delete(flight);
    }


    // Read
    public Optional<Flight> getFlightById(Long flightId) {
        return flightRepository.findById(flightId);
    }

    // Find all flights
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Find specific flights
    public List<Flight> findFlights(String departureLocation, String destination, Date startDate, Date endDate) {
        return flightRepository.findFlight(departureLocation, destination, startDate, endDate);
    }

}
