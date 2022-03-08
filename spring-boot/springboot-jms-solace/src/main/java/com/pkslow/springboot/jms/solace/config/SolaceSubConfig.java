package com.pkslow.springboot.jms.solace.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

import javax.jms.*;

@Configuration
@Slf4j
public class SolaceSubConfig {
    private final SolaceProperties solaceProperties;

    public SolaceSubConfig(SolaceProperties solaceProperties) {
        this.solaceProperties = solaceProperties;
    }

    @Bean
    public SingleConnectionFactory singleConnectionFactory(@Qualifier("connectionFactory") ConnectionFactory targetConnectionFactory) {
        return new SingleConnectionFactory(targetConnectionFactory);
    }

    @Bean
    public MessageListener messageListener() {
        return message -> {
            try {
                log.info("Received message " + ((TextMessage) message).getText() + " on destination: " +
                        message.getJMSDestination().toString());
            } catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        };
    }


    @Bean
    public MessageListenerContainer messageListenerContainer(SingleConnectionFactory singleConnectionFactory, MessageListener messageListener) {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(singleConnectionFactory);
        container.setDestinationName(solaceProperties.getDefaultSubDestinationName());
        container.setMessageListener(messageListener);

        return container;
    }
}
