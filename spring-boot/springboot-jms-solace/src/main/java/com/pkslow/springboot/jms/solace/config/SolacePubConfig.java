package com.pkslow.springboot.jms.solace.config;

import com.solacesystems.jms.SolJmsUtility;
import com.solacesystems.jms.SupportedProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.*;
import javax.naming.InitialContext;
import java.util.Properties;

@Configuration
public class SolacePubConfig {

    private final SolaceProperties solaceProperties;

    public SolacePubConfig(SolaceProperties solaceProperties) {
        this.solaceProperties = solaceProperties;
    }

    @Bean("connectionFactory")
    public ConnectionFactory connectionFactory() throws Exception {
        Properties env = new Properties();
        env.put(InitialContext.INITIAL_CONTEXT_FACTORY, "com.solacesystems.jndi.SolJNDIInitialContextFactory");
        env.put(InitialContext.PROVIDER_URL, solaceProperties.getBrokerUrl());
        env.put(SupportedProperty.SOLACE_JMS_VPN, solaceProperties.getVpn());
        env.put(InitialContext.SECURITY_PRINCIPAL, solaceProperties.getUsername());
        env.put(InitialContext.SECURITY_CREDENTIALS, solaceProperties.getPassword());
        return SolJmsUtility.createConnectionFactory(env);
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory(ConnectionFactory connectionFactory) {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(connectionFactory);
        cachingConnectionFactory.setSessionCacheSize(10);
        return cachingConnectionFactory;
    }

    @Bean
    public JmsTemplate pubJmsTemplate(CachingConnectionFactory cachingConnectionFactory) {
        JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory);
        jmsTemplate.setPubSubDomain(true);
        jmsTemplate.setExplicitQosEnabled(true);
        jmsTemplate.setDeliveryPersistent(true);
        jmsTemplate.setDefaultDestinationName(solaceProperties.getDefaultPubDestinationName());
        return jmsTemplate;
    }

}
