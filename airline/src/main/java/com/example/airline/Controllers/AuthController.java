package com.example.airline.Controllers;
import java.util.*;
import com.example.airline.Repository.FlightsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.airline.service.UserService;
import com.example.airline.Entity.Users;
import com.example.airline.Entity.Flights;

@Controller
public class AuthController {
    @Autowired
    private UserService userservice;
    @Autowired
    private FlightsRepo flightsRepo;
    @GetMapping("/signIn")
    public String signIn(){
        try{
            return "signIn";

        } catch (Exception e) {
            throw new RuntimeException("Error while loading"+e.getMessage());
        }
    }
    @PostMapping ("/userPage")
    public String userPage(@RequestParam("username") String username, @RequestParam("password") String password,Model model){
        try{
            Users user= userservice.findByUsernameAndPasswordNative(username,password);
            if(user!=null && user.getRole().equals("User")){
                List<Flights> flightsList=new ArrayList<>(flightsRepo.findAll());
                model.addAttribute("User",user.getUsername());
                model.addAttribute("flights",flightsList);


                return "User";
            }
            else if(user!=null && user.getRole().equals("Admin")){
                model.addAttribute("username",username);
                List<Flights> flightsList=new ArrayList<>(flightsRepo.findAll());
                model.addAttribute("User",user.getUsername());
                model.addAttribute("flights",flightsList);
                return "adminPage";
            }
            else{
                model.addAttribute("wrongCred","Wrong Credentials");
                return "signIn";
            }

        } catch (Exception e) {
            throw new RuntimeException("Unable to find user"+e.getMessage());
        }




    }



    @GetMapping("/signUp")
    public String signUp(){
        try{
            return "SignUp";

        } catch (Exception e) {
            throw new RuntimeException("Error while loading"+e.getMessage());
        }
    }

    @PostMapping("/userSignIn")
    public String signUp(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("role") String role,Model model){


        try{
            userservice.registerUser(username,password,role);
            return "signIn";

        } catch (Exception e) {
            throw new RuntimeException("Error during sign-ip:" +e.getMessage());
        }







    }

}