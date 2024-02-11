package com.jwt.example.JwtExample.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jwt.example.JwtExample.Service.CustomeUserDetailService;

@Configuration
public class AppConfig {


    @Bean
    public UserDetailsService userDetailsService(){
        // UserDetails user1 = User.builder().username("user1").password(passwordEncoder().encode("1234")).roles("ADMIN").build();
        // UserDetails user2 = User.builder().username("user2").password(passwordEncoder().encode("1234")).roles("ADMIN").build();
        // return new InMemoryUserDetailsManager(user1,user2);
        return new CustomeUserDetailService();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
