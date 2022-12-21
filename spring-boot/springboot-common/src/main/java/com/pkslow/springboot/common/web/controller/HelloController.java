package com.pkslow.springboot.common.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {


    @PostMapping("/pkslow")
    public String postHello(@RequestBody String body) {
        log.info("Request Body(Controller): " + body);
        return "Hello, pkslow!";
    }
}
