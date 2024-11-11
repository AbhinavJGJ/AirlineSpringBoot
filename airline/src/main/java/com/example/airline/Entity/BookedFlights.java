package com.example.airline.Entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
public class BookedFlights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private LocalDateTime departureTime;
    @Column(nullable = false)
    private String flightNumber;


    public BookedFlights() {};


    public BookedFlights(String username,LocalDateTime departureTime,String flightNumber ) {

        this.username=username;
        this.departureTime=departureTime;
        this.flightNumber=flightNumber;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}