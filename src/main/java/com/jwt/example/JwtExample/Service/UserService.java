package com.jwt.example.JwtExample.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.example.JwtExample.Model.User;
import com.jwt.example.JwtExample.Respository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        return this.userRepository.findAll();
    }

    public User createUsers(User user){
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }


}
