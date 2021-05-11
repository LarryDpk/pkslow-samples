package com.pkslow.cloud.stream.binder.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Supplier;

@SpringBootApplication
public class StreamBinderPubsub {
    private static final Logger log = LoggerFactory.getLogger(StreamBinderPubsub.class);
    public static void main(String[] args) {
        SpringApplication.run(StreamBinderPubsub.class, args);
    }

    @Bean
    public Supplier<String> pkslowSource() {
        return () -> {
            String message = "www.pkslow.com";
            log.info("Sending value: " + message);
            return message;
        };
    }

    @Bean
    public Consumer<String> pkslowSink() {
        return message -> {
            log.info("Received message " + message);
        };
    }

}
