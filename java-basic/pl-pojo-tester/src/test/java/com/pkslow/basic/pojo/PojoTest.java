package com.pkslow.basic.pojo;


import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class PojoTest {

    @Test
    public void studentCreationTest() {
        Student student = new Student("Eason", 1, 20210319L, Collections.singletonList("Music"));
        Assert.assertNotNull(student);
    }

}
