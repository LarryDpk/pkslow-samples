package com.pkslow.liquibase;

import org.junit.Assert;
import org.junit.Test;

public class PkslowLiquibasePropertiesTest {
    @Test
    public void test() {
        PkslowLiquibaseProperties properties = new PkslowLiquibaseProperties();
        properties.put("password", "5dVujc6pTIACGagUJFED+A==");
        Assert.assertEquals("pkslow", properties.get("password"));
    }
}
