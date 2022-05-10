package com.pkslow.ssl.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class HttpToHttpsWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${server.port}")
    private int httpsPort;

    @Value("${http.port}")
    private int httpPort;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //redirect to https - 用spring security实现
        http.portMapper().http(httpPort).mapsTo(httpsPort);
        http.requiresChannel(
                channel -> channel.anyRequest().requiresSecure()
        );

        //访问路径/hello不用登陆获得权限
        http.authorizeRequests()
                .antMatchers("/hello").permitAll()
                .anyRequest().authenticated().and();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //过滤了actuator后，不会重定向，也不用权限校验，这个功能非常有用
        web.ignoring()
                .antMatchers("/actuator")
                .antMatchers("/actuator/**");
    }
}
