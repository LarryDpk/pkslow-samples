package com.pkslow.basic;

import com.pkslow.basic.jdk.Bird;
import com.pkslow.basic.jdk.Flyable;
import com.pkslow.basic.jdk.FlyableInvocation;

import java.lang.reflect.Proxy;

public class JDKDynamicProxy {
    public static void main(String[] args) {
        ClassLoader classLoader = JDKDynamicProxy.class.getClassLoader();
        Class<?>[] interfaces = Bird.class.getInterfaces();
        Bird bird = new Bird();
        Flyable flyable = (Flyable) Proxy.newProxyInstance(classLoader, interfaces, new FlyableInvocation(bird));
        flyable.fly("Go to pkslow.com");
    }
}
