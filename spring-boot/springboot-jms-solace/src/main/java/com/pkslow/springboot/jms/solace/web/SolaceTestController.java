package com.pkslow.springboot.jms.solace.web;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/solace")
public class SolaceTestController {
    private final JmsTemplate pubJmsTemplate;

    public SolaceTestController(JmsTemplate pubJmsTemplate) {
        this.pubJmsTemplate = pubJmsTemplate;
    }

    @PostConstruct
    public void init() {
        pubJmsTemplate.setDeliveryPersistent(true);
        pubJmsTemplate.setDefaultDestinationName("mytopic");
    }

    @GetMapping
    public String send() {
        pubJmsTemplate.send("mytopic", session -> session.createTextMessage("www.pkslow.com"));
        pubJmsTemplate.send(session -> session.createTextMessage("Larry Deng"));
        return "OK";
    }
}
