package com.example.flightapp.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @Column(name = "flight_id")
    private String flightId;

    @ManyToOne
    @JoinColumn(name = "departure_city_id")
    private City departureCity;

    @ManyToOne
    @JoinColumn(name = "arrival_city_id")
    private City arrivalCity;

    @Column(name = "departure_time")
    private OffsetDateTime departureTime;

    @Column(name = "arrival_time")
    private OffsetDateTime arrivalTime;

    @Column(name = "flight_number", nullable = false)
    private String flightNumber;

    @Column(name = "price")
    private String price;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    public String getFlightId() { return flightId; }
    public void setFlightId(String flightId) { this.flightId = flightId; }
    public City getDepartureCity() { return departureCity; }
    public void setDepartureCity(City departureCity) { this.departureCity = departureCity; }
    public City getArrivalCity() { return arrivalCity; }
    public void setArrivalCity(City arrivalCity) { this.arrivalCity = arrivalCity; }
    public OffsetDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(OffsetDateTime departureTime) { this.departureTime = departureTime; }
    public OffsetDateTime getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(OffsetDateTime arrivalTime) { this.arrivalTime = arrivalTime; }
    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
}
