package com.pkslow.basic;

import java.util.concurrent.Callable;

public class DelayedCallable implements Callable<String> {
    private final long delayMill;
    private final String name;

    public DelayedCallable(long delayMill, String name) {
        this.delayMill = delayMill;
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println(name + " is running");
        try {
            Thread.sleep(delayMill);
            System.out.println(name + " is completed");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return name;
    }
}
