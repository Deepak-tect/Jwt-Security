package com.jwt.example.JwtExample.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.*;

import com.jwt.example.JwtExample.Model.User;
import com.jwt.example.JwtExample.Service.UserService;




@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/user")
    public List<User> getUser(){
        System.out.println("geting user");
        return this.userService.getUsers();
    }

    @GetMapping("/current-user")
    public String getMethodName(Principal principal) {
        return principal.getName();
    }
    
}
