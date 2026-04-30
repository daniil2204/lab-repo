package com.example.flightapp.controller;

import com.example.flightapp.entity.Flight;
import com.example.flightapp.service.FlightService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping(params = "flight_number")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<Flight> getFlightsByFlightNumber(@RequestParam("flight_number") String flightNumber) {
        return flightService.getFlightsByFlightNumber(flightNumber);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.createFlight(flight);
    }
}
