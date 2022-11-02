package com.pkslow.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class SpringbootGraalVMNativeMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootGraalVMNativeMain.class, args);
    }

    @GetMapping("/hi-graalvm")
    public String hi() {
        return "This message is from Spring Boot built/run by GraalVM/Spring Native";
    }
}