package com.example.airline.service;

import com.example.airline.Entity.BookedFlights;

import java.time.LocalDateTime;

public interface BookedFlightsService {

    BookedFlights registerFlight(String username, LocalDateTime departureTime,String flightNumber);


}