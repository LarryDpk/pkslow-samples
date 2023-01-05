package com.pkslow.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @GetMapping("/hello")
    public String hello() {
        log.info("------hello() start---");
        test();
        staticTest();
        log.info("------hello() end---");
        return "Hello, pkslow.";
    }

    private void test() {
        log.info("------test() start---");
        log.info("test");
        log.info("------test() end---");
    }

    private static void staticTest() {
        log.info("------staticTest() start---");
        log.info("staticTest");
        log.info("------staticTest() end---");
    }
}
