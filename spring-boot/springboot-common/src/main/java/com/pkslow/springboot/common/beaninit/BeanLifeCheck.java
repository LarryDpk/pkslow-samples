package com.pkslow.springboot.common.beaninit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class BeanLifeCheck implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(BeanLifeCheck.class);

    @Value("${spring.application.name}")
    private String applicationName;

    public BeanLifeCheck() {
        logger.info("BeanLifeCheck: Construct " + applicationName);
    }

    public void initMethod() {
        logger.info("BeanLifeCheck: initMethod " + applicationName);
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("BeanLifeCheck: postConstruct " + applicationName);
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("BeanLifeCheck: preDestroy " + applicationName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("BeanLifeCheck: afterPropertiesSet " + applicationName);
    }
}
