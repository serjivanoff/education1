package com.education.leetcode.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrder {
    static CyclicBarrier barrier = new CyclicBarrier(2, System.out::println);

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        Foo foo = new Foo();
        for (int i = 0; i < 100; i++) {
            Runnable r1 = () -> System.out.print("first"),
                    r2 = () -> System.out.print("second"),
                    r3 = () -> System.out.print("third");

            Thread t1 = new Thread(() -> {
                try {
                    foo.first(r1);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }),
                    t2 = new Thread(() -> {
                        try {
                            foo.second(r2);
                        } catch (InterruptedException | BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    }),
                    t3 = new Thread(() -> {
                        try {
                            foo.third(r3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
            t3.start();
            t2.start();
            t1.start();
            barrier.await();
        }
    }
}

class Foo {
    private static final Lock lock = new ReentrantLock();
    private final Condition first = lock.newCondition(), second = lock.newCondition();
    private boolean firstDone, secondDone = false;

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException, BrokenBarrierException {
        lock.lock();
        try {
            printFirst.run();
            firstDone = true;
            first.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException, BrokenBarrierException {
        lock.lock();
        try {
            while (!firstDone)
                first.await();
            printSecond.run();
            secondDone = true;
            second.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (!secondDone)
                second.await();

            printThird.run();
            firstDone = false;
            secondDone = false;
            PrintInOrder.barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}