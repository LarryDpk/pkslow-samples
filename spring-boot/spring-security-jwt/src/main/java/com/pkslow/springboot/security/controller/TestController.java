package com.pkslow.springboot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/admin")
    public String admin() {
        return "you are admin";
    }

    @GetMapping("/user")
    public String user() {
        return "you are user";
    }
}
