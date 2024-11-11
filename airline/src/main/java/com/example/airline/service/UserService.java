package com.example.airline.service;
import com.example.airline.Entity.Users;


public interface  UserService {
    Users registerUser( String username, String password, String role);

    Users findByUsernameAndPasswordNative(String username, String password);


}