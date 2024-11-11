package com.example.airline.ImplementationService;

import com.example.airline.Entity.BookedFlights;
import com.example.airline.service.BookedFlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.airline.Repository.BookedFlight;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class BookedFlightImplementation implements BookedFlightsService {
    @Autowired
    private BookedFlight bookedFlights;
    @Override
    public BookedFlights registerFlight(String username, LocalDateTime departureTime,String flightNumber) {
        try{
            BookedFlights bookedflight=new BookedFlights(username,departureTime,flightNumber);
            return bookedFlights.save(bookedflight);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}