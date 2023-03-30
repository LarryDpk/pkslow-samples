package com.pkslow.springboot;

import com.pkslow.ai.GoogleBardClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GoogleBardConfig {

    @Bean
    public GoogleBardClient googleBardClient(@Value("${ai.google-bard.token}") String token) {
        return new GoogleBardClient(token);
    }
}
