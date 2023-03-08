package com.pkslow.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class RunnableVsCallable {
    public static void main(String[] args) {

        runnable();
        callable();

    }

    private static void runnable() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(new PkslowRunnable("pkslow.r1"));
        executorService.submit(new PkslowRunnable("pkslow.r2"));
        executorService.submit(new PkslowRunnable("pkslow.r3"));
        executorService.submit(new PkslowRunnable("pkslow.r4"));
        executorService.submit(new PkslowRunnable("pkslow.r5"));
        executorService.submit(new PkslowRunnable("pkslow.r6"));
        executorService.submit(new PkslowRunnable("pkslow.r7"));
        executorService.submit(new PkslowRunnable("pkslow.r8"));
        executorService.submit(new PkslowRunnable("pkslow.r9"));
        executorService.submit(new PkslowRunnable("pkslow.r10"));

        awaitTerminationAfterShutdown(executorService);
    }

    private static void callable() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futures = new ArrayList<>();
        futures.add(executorService.submit(new PkslowCallable("pkslow.c1")));
        futures.add(executorService.submit(new PkslowCallable("pkslow.c2")));
        futures.add(executorService.submit(new PkslowCallable("pkslow.c3")));
        futures.add(executorService.submit(new PkslowCallable("pkslow.c4")));
        futures.add(executorService.submit(new PkslowCallable("pkslow.c5")));
        futures.add(executorService.submit(new PkslowCallable("pkslow.c6")));
        futures.add(executorService.submit(new PkslowCallable("pkslow.c7")));
        futures.add(executorService.submit(new PkslowCallable("pkslow.c8")));
        futures.add(executorService.submit(new PkslowCallable("pkslow.c9")));
        futures.add(executorService.submit(new PkslowCallable("pkslow.c10")));

        futures.forEach(ft -> {
            try {
                System.out.println("Result from Future: " + ft.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        awaitTerminationAfterShutdown(executorService);
    }


    private static void awaitTerminationAfterShutdown(ExecutorService threadPool) {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

class PkslowRunnable implements Runnable {
    private final String name;

    PkslowRunnable(String name) {
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
}

class PkslowCallable implements Callable<Integer> {
    private final String name;

    PkslowCallable(String name) {
        this.name = name;
    }


    @Override
    public Integer call() throws Exception {
        System.out.println(name + " is running");
        try {
            Thread.sleep(1000);
            System.out.println(name + " is completed");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return (new Random().nextInt()) % 100;
    }
}