package com.education.concurrency;

public class MainThreadLocal {
    public static final ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {

        threadLocal.set("Main thread");

        Thread t = new Thread(() -> {
            threadLocal.set("Second thread");
            System.out.println("From new Thread " + threadLocal.get());
        });
        t.start();

        System.out.println("From main Thread " + threadLocal.get());
    }
}