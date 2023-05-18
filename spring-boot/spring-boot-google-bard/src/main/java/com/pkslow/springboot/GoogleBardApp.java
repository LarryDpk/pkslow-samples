package com.pkslow.springboot;

import com.pkslow.ai.util.NetworkUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoogleBardApp {
    public static void main(String[] args) {
        NetworkUtils.setUpProxy("localhost", "7890");
        SpringApplication.run(GoogleBardApp.class, args);
    }
}