package com.jwt.example.JwtExample.Utils;

public class JwtResponseBuilder {
    private String token;
    private String username;

    JwtResponseBuilder() {}

    public JwtResponseBuilder jwtToken(String token) {
        this.token = token;
        return this;
    }

    public JwtResponseBuilder username(String username) {
        this.username = username;
        return this;
    }

    public JwtResponse build() {
        JwtResponse response = new JwtResponse();
        response.setToken(this.token);
        response.setUsername(this.username);
        return response;
    }
}
