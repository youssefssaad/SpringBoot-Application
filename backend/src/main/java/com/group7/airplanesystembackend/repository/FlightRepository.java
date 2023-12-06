package com.group7.airplanesystembackend.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group7.airplanesystembackend.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM Flight f WHERE f.departureLocation = :departureLocation AND f.destination = :destination AND f.departureTime >= :startDate AND f.departureTime <= :endDate")
    List<Flight> findFlight(@Param("departureLocation") String departureLocation,
                            @Param("destination") String destination,
                            @Param("startDate") Date startDate,
                            @Param("endDate") Date endDate);
}
