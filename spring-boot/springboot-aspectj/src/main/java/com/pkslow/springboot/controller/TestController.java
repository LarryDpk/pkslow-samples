package com.pkslow.springboot.controller;

import com.pkslow.springboot.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/hello")
    public String hello() {
        log.info("------hello() start---");
        test();
        staticTest();
        testService.fetchData();
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
