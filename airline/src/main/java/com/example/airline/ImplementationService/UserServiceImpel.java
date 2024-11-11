package com.example.airline.ImplementationService;
import com.example.airline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.airline.Repository.repository;
import com.example.airline.Entity.Users;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpel implements UserService {
    @Autowired
    private repository repo;
    public Users registerUser( String username,String password, String role){
        try{
            Users newuser =new Users(username,password,role);
            return repo.save(newuser);

        } catch (Exception e) {
            throw new RuntimeException("Unable to save user"+e.getMessage());
        }


    }
    public Users findByUsernameAndPasswordNative(String username, String password){
        try{
            return repo.findByUsernameAndPasswordNative(username,password);

        } catch (Exception e) {
            throw new RuntimeException("User not found"+e.getMessage());
        }



    }

}