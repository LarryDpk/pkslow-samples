package com.pkslow.influxdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InfluxDBApp {
    public static void main(String[] args) {
        SpringApplication.run(InfluxDBApp.class, args);
    }
}
