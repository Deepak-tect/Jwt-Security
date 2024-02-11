package com.jwt.example.JwtExample.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.example.JwtExample.Model.User;
import com.jwt.example.JwtExample.Respository.UserRepository;
import com.jwt.example.JwtExample.Security.JwtHelper;
import com.jwt.example.JwtExample.Service.CustomeUserDetailService;
import com.jwt.example.JwtExample.Service.UserService;
import com.jwt.example.JwtExample.Utils.JwtRequest;
import com.jwt.example.JwtExample.Utils.JwtResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {
    // @Autowired
    // private UserDetailsService userDetailsService;

    @Autowired
    private CustomeUserDetailService customeUserDetailService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserService userService;



    @Autowired
    private JwtHelper helper;

    @Autowired
    private UserRepository userRepository;

    // private Logger logger = LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
        System.out.println("controller " + request.getEmail());
        System.out.println("controller " + userRepository.findByEmail(request.getEmail()).get().getPassword());
        this.doAuthenticate(request.getEmail(), request.getPassword());

        UserDetails userDetails = customeUserDetailService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            System.out.println("--------------inside---------------");
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

    @PostMapping("/create-user")
    public User createUser(@RequestBody User user){
        return this.userService.createUsers(user);
    }
}
