package com.jwt.example.JwtExample.Service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.jwt.example.JwtExample.Model.*;

@Service
public class UserService {
    List<User> store = new ArrayList<>();


    public UserService(){
        store.add(new User(1,"User1", "user1@gmail.com"));
        store.add(new User(2,"User2", "user2@gmail.com"));
        store.add(new User(3,"User3", "user3@gmail.com"));
        store.add(new User(4,"User4", "user4@gmail.com"));
        store.add(new User(5,"User5", "user5@gmail.com"));
        store.add(new User(6,"User6", "user6@gmail.com"));
    }

    public List<User> getUser(){
        return this.store;
    }
}
