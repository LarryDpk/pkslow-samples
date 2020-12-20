package com.pkslow.cloud.rest.config;

import com.pkslow.cloud.rest.model.AdminConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;

import java.util.Collections;

@Configuration
public class AdminConversionServiceConfig {
    @Bean
    public ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
        factoryBean.setConverters(Collections.singleton(new AdminConverter()));
        return factoryBean;
    }
}
