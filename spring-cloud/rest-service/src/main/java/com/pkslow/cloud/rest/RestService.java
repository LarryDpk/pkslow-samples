package com.pkslow.cloud.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestService {
    public static void main(String[] args) {
        SpringApplication.run(RestService.class, args);
    }
}