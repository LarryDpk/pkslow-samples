package com.pkslow.ssl;

import com.pkslow.ssl.config.security.EnableHttpWithHttpsConfig;
import com.pkslow.ssl.config.security.HttpToHttpsWebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({EnableHttpWithHttpsConfig.class, HttpToHttpsWebSecurityConfig.class})
//@Import(HttpToHttpsContainerFactoryConfig.class)
@ComponentScan(basePackages = "com.pkslow.ssl.controller")
public class SpringbootSslTomcatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSslTomcatApplication.class, args);
	}

}
