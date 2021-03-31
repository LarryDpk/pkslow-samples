package com.pkslow.springboot.common.springbootcondition;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

public class PkslowConfigTest {
    @Test
    public void test() {
        ApplicationContextRunner context = new ApplicationContextRunner()
                .withPropertyValues("pkslow.condition.max=100")
                .withPropertyValues("pkslow.condition.min=10")
                .withUserConfiguration(PkslowConfig.class);

        context.run(it -> {
            Assert.assertTrue(it.containsBean("pkslowConfig"));
        });
    }
}
