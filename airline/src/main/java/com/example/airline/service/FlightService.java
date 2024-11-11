package com.example.airline.service;

import com.example.airline.Entity.Flights;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public interface FlightService {
    Flights addFlights(String flightNumber, LocalDateTime departureTime, String status);

}
