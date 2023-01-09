package com.education;

public class MainThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("Main thread");

        Thread t = new Thread(() -> System.out.println("From new Thread " + threadLocal.get()));
        t.start();

        System.out.println("From main Thread " + threadLocal.get());
    }
}