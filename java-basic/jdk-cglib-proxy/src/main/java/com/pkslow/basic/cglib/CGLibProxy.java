package com.pkslow.basic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibProxy<T> implements MethodInterceptor {
    private T target;

    public T getInstance(T target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        long start = System.nanoTime();
        System.out.println(target + ": ===CGLib proxy===");
        Object result = methodProxy.invoke(this.target, args);
        System.out.println(target + ": ===CGLib proxy===");
        long end = System.nanoTime();
        System.out.println("Executing time: " + (end - start) + " ns");

        return result;
    }
}
