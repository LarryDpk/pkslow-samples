package com.pkslow.basic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class FlyableInvocation  implements InvocationHandler {
    private final Flyable target;

    public FlyableInvocation(Flyable target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.nanoTime();
        System.out.println(target + ": ===JDK proxy===");
        Object result = method.invoke(this.target, args);
        System.out.println(target + ": ===JDK proxy===");
        long end = System.nanoTime();
        System.out.println("Executing time: " + (end - start) + " ns");
        return result;
    }
}
