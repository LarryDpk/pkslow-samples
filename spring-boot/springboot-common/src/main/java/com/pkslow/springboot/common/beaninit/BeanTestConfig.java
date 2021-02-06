package com.pkslow.springboot.common.beaninit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanTestConfig {
    @Bean(initMethod = "initMethod")
    public BeanLifeCheck beanLifeCheck() {
        return new BeanLifeCheck();
    }
}
