package com.pkslow.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class WaitThreadsFinish {
    private static final int NUM = 10;
    private static final int THREADS = 5;

    public static void main(String[] args) {
        threadJoin();
        countDownLatch();
        cyclicBarrier();
        executeServiceIsTerminated();
        executeServiceAwaitTermination();
        executeServiceInvokeAll();
        executorCompletionService();
    }

    private static void threadJoin() {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < NUM; i++) {
            Thread t = new Thread(new PkslowTask("Task " + i));
            t.start();
            threads.add(t);
        }
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("threadJoin Finished All Tasks...");

    }

    private static void countDownLatch() {
        CountDownLatch latch = new CountDownLatch(NUM);
        for (int i = 0; i < NUM; i++) {
            Thread t = new Thread(() -> {
                System.out.println("countDownLatch running...");
                try {
                    Thread.sleep(1000);
                    System.out.println("countDownLatch Finished...");
                    latch.countDown();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("countDownLatch Finished All Tasks...");
    }


    private static void cyclicBarrier() {
        CyclicBarrier barrier = new CyclicBarrier(NUM + 1);

        for (int i = 0; i < NUM; i++) {
            Thread t = new Thread(() -> {
                System.out.println("cyclicBarrier running...");
                try {
                    Thread.sleep(1000);
                    System.out.println("cyclicBarrier Finished...");
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
        }

        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println("cyclicBarrier Finished All Tasks...");
    }


    private static void executeServiceIsTerminated() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        IntStream.range(0, NUM)
                .forEach(i -> executorService.execute(new PkslowTask("Task " + i)));
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            //waiting...
        }
        System.out.println("executeServiceIsTerminated Finished All Tasks...");

    }

    private static void executeServiceAwaitTermination() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        IntStream.range(0, NUM)
                .forEach(i -> executorService.execute(new PkslowTask("Task " + i)));
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("executeServiceAwaitTermination Finished All Tasks...");
    }

    private static void executeServiceInvokeAll() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        List<Callable<Void>> tasks = new ArrayList<>();

        IntStream.range(0, NUM)
                .forEach(i -> tasks.add(new PkslowTask("Task " + i)));

        try {
            executorService.invokeAll(tasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
        System.out.println("executeServiceInvokeAll Finished All Tasks...");
    }

    private static void executorCompletionService() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletionService<String> service = new ExecutorCompletionService<>(executorService);

        List<Callable<String>> callables = new ArrayList<>();
        callables.add(new DelayedCallable(2000, "2000ms"));
        callables.add(new DelayedCallable(1500, "1500ms"));
        callables.add(new DelayedCallable(6000, "6000ms"));
        callables.add(new DelayedCallable(2500, "2500ms"));
        callables.add(new DelayedCallable(300, "300ms"));
        callables.add(new DelayedCallable(3000, "3000ms"));
        callables.add(new DelayedCallable(1100, "1100ms"));
        callables.add(new DelayedCallable(100, "100ms"));
        callables.add(new DelayedCallable(100, "100ms"));
        callables.add(new DelayedCallable(100, "100ms"));

        callables.forEach(service::submit);

        for (int i = 0; i < NUM; i++) {
            try {
                Future<String> future = service.take();
                System.out.println(future.get() + " task is completed");
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("executorCompletionService Finished All Tasks...");

        executorService.shutdown();
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