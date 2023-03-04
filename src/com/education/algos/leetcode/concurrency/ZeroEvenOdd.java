package com.education.algos.leetcode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private final Lock lock = new ReentrantLock();
    private final Condition zeroAndEvenPrinted = lock.newCondition(),
            zeroAndOddPrinted = lock.newCondition(),
            oddOrEvenPrinted = lock.newCondition();

    private boolean zero, even, odd = true;
    private final int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        final IntConsumer intConsumer = System.out::print;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(105);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (zero)
                    oddOrEvenPrinted.await();
                printNumber.accept(0);
                zero = true;
                even = !even;
                odd = !odd;
                if (even)
                    zeroAndEvenPrinted.signal();
                else
                    zeroAndOddPrinted.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            lock.lock();
            try {
                while (!zero || !even)
                    zeroAndEvenPrinted.await();
                printNumber.accept(i);
                zero = false;
                oddOrEvenPrinted.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            lock.lock();
            try {
                while (!zero || !odd)
                    zeroAndOddPrinted.await();
                printNumber.accept(i);
                zero = false;
                oddOrEvenPrinted.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
