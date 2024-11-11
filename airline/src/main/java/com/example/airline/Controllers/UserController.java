package com.example.airline.Controllers;

import com.example.airline.service.BookedFlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.airline.Repository.BookedFlight;

import java.time.LocalDateTime;

@Controller
public class UserController {


    @Autowired
    private BookedFlight bookedFlight;
    @Autowired
    private BookedFlightsService bookedFlightsService;
    @PostMapping("/bookFlight")
    public String bookFlight( @RequestParam("username") String username, @RequestParam("flightNumber") String flightNumber, @RequestParam("departureTime")LocalDateTime departureTime, Model model){
        try{
            bookedFlightsService.registerFlight(username,departureTime,flightNumber);



            return "Flight added successfully";


        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}