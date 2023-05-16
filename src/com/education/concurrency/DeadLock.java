package com.education.concurrency;

public class DeadLock {
    private static final Object L = new Object();
    private static final Object M = new Object();

    public static void main(String[] args) {
        var a = new Thread(() -> {
            System.out.println("Entering thread A");
            synchronized (L) {
                System.out.println("Acquired lock L by thread A");
                try {
                    System.out.println("Now trying to acquire lock M by thread A");
                    Thread.sleep(1000L);
                    synchronized (M) {
                        System.out.println("Thread A Gotcha!!");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        var b = new Thread(() -> {
            System.out.println("Entering thread B");
            synchronized (M) {
                System.out.println("Acquired lock M by thread B");
                try {
                    Thread.sleep(1000L);
                    System.out.println("Now trying to acquire lock L by thread B");
                    synchronized (L) {
                        System.out.println("Thread B Gotcha!!");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        a.start();
        b.start();

    }
}
