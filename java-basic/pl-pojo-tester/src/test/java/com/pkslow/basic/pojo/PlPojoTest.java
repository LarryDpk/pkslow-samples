package com.pkslow.basic.pojo;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsForAll;

public class PlPojoTest {

    @Test
    public void pojoTest() {
        assertPojoMethodsForAll(Student.class, Teacher.class)
                .quickly()
                .areWellImplemented();
    }

    @Test
    public void pojoMethodTest() {
        assertPojoMethodsForAll(Student.class, Teacher.class)
                .quickly()
                .testing(Method.CONSTRUCTOR)
                .testing(Method.GETTER)
                .testing(Method.SETTER)
                .areWellImplemented();
    }

    @Test
    public void lombokClassTest() {
        assertPojoMethodsForAll(Classroom.class)
                .areWellImplemented();
    }

}
