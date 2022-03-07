package com.pkslow.springboot.jms.solace.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "pkslow.solace")
@Setter
@Getter
public class SolaceProperties {
    private String brokerUrl;
    private String vpn;
    private String username;
    private String password;
    private String defaultPubDestinationName;
}
