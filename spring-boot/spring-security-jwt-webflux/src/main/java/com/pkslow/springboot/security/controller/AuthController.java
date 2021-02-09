package com.pkslow.springboot.security.controller;

import com.pkslow.springboot.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    ReactiveAuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public Mono<String> login(@RequestBody AuthRequest request) {
        String username = request.getUsername();
        Mono<Authentication> authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, request.getPassword()));

        return authentication.map(auth -> jwtTokenProvider.createToken(auth));
    }
}
