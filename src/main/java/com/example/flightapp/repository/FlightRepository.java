package com.example.flightapp.repository;

import com.example.flightapp.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
    List<Flight> findByFlightNumber(String flightNumber);
}
