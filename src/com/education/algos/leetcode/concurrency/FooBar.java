package com.education.algos.leetcode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    private final Lock lock = new ReentrantLock();
    private final Condition fooPrinted = lock.newCondition(), barPrinted = lock.newCondition();
    private boolean fooFlag, barFlag = true;

    private int n;

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(100);
        Runnable printFoo = () -> System.out.print("foo"),
                printBar = () -> System.out.println("bar");

        new Thread(() -> {
            try {
                fooBar.foo(printFoo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.bar(printBar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!barFlag)
                    barPrinted.await();
                printFoo.run();
                barFlag = false;
                fooFlag = true;
                fooPrinted.signal();
            } finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!fooFlag)
                    fooPrinted.await();
                printBar.run();
                fooFlag = false;
                barFlag = true;
                barPrinted.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}