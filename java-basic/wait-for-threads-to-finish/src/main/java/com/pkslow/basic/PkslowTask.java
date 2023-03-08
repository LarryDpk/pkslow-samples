package com.pkslow.basic;

import java.util.concurrent.Callable;

public class PkslowTask implements Runnable, Callable<Void> {
    private final String name;

    public PkslowTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " is running");
        try {
            Thread.sleep(1000);
            System.out.println(name + " is completed");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Void call() throws Exception {
        run();
        return null;
    }
}
