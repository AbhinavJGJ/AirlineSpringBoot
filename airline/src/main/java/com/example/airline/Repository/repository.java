package com.example.airline.Repository;
import com.example.airline.Entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface repository extends JpaRepository<Users, BigInteger>{
    @Query(value= "SELECT * FROM Users WHERE username= :username AND password= :password", nativeQuery = true)
    Users findByUsernameAndPasswordNative(@Param("username")String username,@Param("password") String password);


}