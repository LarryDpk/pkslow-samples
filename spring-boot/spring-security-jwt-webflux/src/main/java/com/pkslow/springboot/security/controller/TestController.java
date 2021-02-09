package com.pkslow.springboot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {
    @GetMapping("/admin")
    public Mono<String> admin() {
        return Mono.just("you are admin");
    }

    @GetMapping("/user")
    public Mono<String> user() {
        return Mono.just("you are user");
    }
}
