package com.education.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadLocalExample {
    private static final ThreadLocal<String> STRING = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println(Thread.currentThread().getName());
        FutureTask<String> ft = new FutureTask<>(() -> Thread.currentThread().getName());
        System.out.println(ft.get());
        new Thread(ft).start();

//        STRING.set("Main Thread");
//        ExecutorService executor = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 25; i++) {
//            executor.submit(() -> {
//                STRING.set(Thread.currentThread().getName());
//                System.out.println(STRING.get());
//                System.out.println("----------------------------------------------");
//            });
//        }
//        executor.shutdown();
//        System.out.println(STRING.get());
//        System.out.println("-----------------------------------------");

    }
}
