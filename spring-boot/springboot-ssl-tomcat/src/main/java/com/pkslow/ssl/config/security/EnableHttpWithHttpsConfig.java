package com.pkslow.ssl.config.security;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class EnableHttpWithHttpsConfig {
    @Value("${http.port}")
    private int httpPort;

    @Component
    public class CustomContainer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

        @Override
        public void customize(TomcatServletWebServerFactory factory) {
            Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
            connector.setPort(httpPort);
            connector.setScheme("http");
            connector.setSecure(false);
            factory.addAdditionalTomcatConnectors(connector);
        }
    }
}
