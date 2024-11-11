package com.example.airline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.airline.Entity.Flights;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface FlightsRepo extends JpaRepository<Flights, BigInteger> {
}