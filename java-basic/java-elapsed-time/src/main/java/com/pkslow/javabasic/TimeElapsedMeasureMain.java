package com.pkslow.javabasic;

import org.apache.commons.lang3.time.StopWatch;

import java.time.Duration;
import java.time.Instant;

public class TimeElapsedMeasureMain {
    public static void main(String[] args) {
        currentTimeMillis();
        nanoTime();
        java8TimeInstant();
        stopWatch();
    }

    private static void currentTimeMillis() {
        long start = System.currentTimeMillis();
        call();
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.println("currentTimeMillis: " + elapsed);
    }

    private static void nanoTime() {
        long start = System.nanoTime();
        call();
        long end = System.nanoTime();
        long elapsed = end - start;
        elapsed = elapsed / 1000000;
        System.out.println("nanoTime: " + elapsed);
    }

    private static void java8TimeInstant() {
        Instant start = Instant.now();
        call();
        Instant end = Instant.now();
        long elapsed = Duration.between(start, end).toMillis();
        System.out.println("java8TimeInstant: " + elapsed);
    }

    private static void stopWatch() {
        StopWatch w = new StopWatch();
        w.start();
        call();
        w.stop();
        System.out.println("stopWatch: " + w.getTime());
    }

    private static void call() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}