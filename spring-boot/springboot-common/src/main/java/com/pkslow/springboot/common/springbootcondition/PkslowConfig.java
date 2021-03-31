package com.pkslow.springboot.common.springbootcondition;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Conditional(PkslowCondition.class)
@Configuration
public class PkslowConfig {
    @PostConstruct
    public void postConstruct() {
        System.out.println("PkslowConfig called");
    }
}
