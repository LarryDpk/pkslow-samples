package com.pkslow.springboot.jms.solace.web;

import com.pkslow.springboot.jms.solace.config.SolaceProperties;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/solace")
public class SolaceTestController {
    private final JmsTemplate pubJmsTemplate;
    private final SolaceProperties solaceProperties;

    public SolaceTestController(JmsTemplate pubJmsTemplate, SolaceProperties solaceProperties) {
        this.pubJmsTemplate = pubJmsTemplate;
        this.solaceProperties = solaceProperties;
    }

    @GetMapping
    public String send() {
        pubJmsTemplate.send(solaceProperties.getDefaultPubDestinationName(), session -> session.createTextMessage("www.pkslow.com"));
        pubJmsTemplate.send(session -> session.createTextMessage("Larry Deng"));
        return "OK";
    }
}
