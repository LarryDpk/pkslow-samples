package com.pkslow.ssl.config;

import org.eclipse.jetty.server.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.jetty.ConfigurableJettyWebServerFactory;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class WebServerFactoryCustomizerConfig implements WebServerFactoryCustomizer<ConfigurableJettyWebServerFactory> {
    @Value("${server.port}")
    private int httpsPort;

    @Value("${http.port}")
    private int httpPort;


    @Override
    public void customize(ConfigurableJettyWebServerFactory factory) {
        ((JettyServletWebServerFactory)factory).setConfigurations(
                Collections.singleton(new HttpToHttpsJettyConfig())
        );

        factory.addServerCustomizers(
                server -> {
                    HttpConfiguration httpConfiguration = new HttpConfiguration();
                    httpConfiguration.setSecurePort(httpsPort);
                    httpConfiguration.setSecureScheme("https");

                    ServerConnector connector = new ServerConnector(server);
                    connector.addConnectionFactory(new HttpConnectionFactory(httpConfiguration));
                    connector.setPort(httpPort);

                    ServerConnector connector2 = new ServerConnector(server);
                    connector2.addConnectionFactory(new HttpConnectionFactory(httpConfiguration));
                    connector2.setPort(httpPort + 1);

                    server.addConnector(connector);
                    server.addConnector(connector2);
                }
        );
    }
}
