package com.example.airline.ImplementationService;

import com.example.airline.Entity.Flights;
import com.example.airline.Repository.FlightsRepo;
import com.example.airline.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FlightsImpel implements FlightService {
    @Autowired
    private FlightsRepo flightrepo;
    public Flights addFlights(String flightNumber, LocalDateTime departureTime, String status){
        try{
            Flights flight= new Flights(flightNumber,departureTime,status);
            return flightrepo.save(flight);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}