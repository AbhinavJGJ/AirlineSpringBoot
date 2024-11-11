package com.example.airline.Repository;

import com.example.airline.Entity.BookedFlights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface BookedFlight extends JpaRepository<BookedFlights, BigInteger> {


}
