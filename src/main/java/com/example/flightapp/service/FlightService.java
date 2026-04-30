package com.example.flightapp.service;

import com.example.flightapp.entity.Flight;
import com.example.flightapp.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> getFlightsByFlightNumber(String flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber);
    }

    public Flight createFlight(Flight flight) {
        flight.setFlightId(UUID.randomUUID().toString());
        flight.setCreatedAt(OffsetDateTime.now());
        return flightRepository.save(flight);
    }
}
