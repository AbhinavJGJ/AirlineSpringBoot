package com.example.airline.Controllers;


import com.example.airline.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class AdminController {
    @Autowired
    private FlightService flightserivce;

    @GetMapping("/adminPage")
    public String adminPage(){
        try{

            return "adminPage";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    @GetMapping("/flightPage")
    public String flightPage(){
        return "Flight";
    }
    @PostMapping("/addFlight")
    public String addFlights(@RequestParam("flightNumber") String flightNumber, @RequestParam("departureTime") LocalDateTime departureTime, @RequestParam("status") String status, Model model){
        try{
            flightserivce.addFlights(flightNumber,departureTime,status);
            model.addAttribute("message","flight added successfully");
            model.addAttribute("message",flightNumber);
            model.addAttribute("message",departureTime);
            model.addAttribute("message",status);

            return "Flight";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
    /*@PostMapping("/delayFlight")
    public String delayFlight(@RequestParam("flight") String flight){
        flightserivce.findFlightsByUsernameAndBookedFlight();


    }*/



}