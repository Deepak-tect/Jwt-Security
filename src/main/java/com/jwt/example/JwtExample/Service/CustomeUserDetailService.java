package com.jwt.example.JwtExample.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.example.JwtExample.Model.User;
import com.jwt.example.JwtExample.Respository.UserRepository;

@Service
public class CustomeUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // load user from database
        User user = this.userRepository.findByEmail(username).orElseThrow(()->new RuntimeException("user not found"));
        return user;
    }
    
}
