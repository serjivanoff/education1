package com.education.leetcode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private final Lock lock = new ReentrantLock();
    private final Condition fizz = lock.newCondition(), buzz = lock.newCondition(),
            fizzBuzz = lock.newCondition(), number = lock.newCondition();
    private boolean f, b, fb, nextTick = true;
    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        final FizzBuzz fb = new FizzBuzz(50);
        final IntConsumer intConsumer = System.out::println;
        final Runnable printFizz = () -> System.out.println("fizz"),
                printBuzz = () -> System.out.println("buzz"),
                printFizzBuzz = () -> System.out.println("fizzbuzz");
        new Thread(() -> {
            try {
                fb.fizz(printFizz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fb.fizzbuzz(printFizzBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fb.buzz(printBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fb.number(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            lock.lock();
            try {
                while (!f)
                    fizz.await();
                if ((i % 3 == 0) && (i % 5 != 0)) {
                    printFizz.run();
                }
                f = false;
                b = true;
                buzz.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            lock.lock();
            try {
                while (!b)
                    buzz.await();
                if ((i % 3 != 0) && (i % 5 == 0)) {
                    printBuzz.run();
                }
                b = false;
                fb = true;
                fizzBuzz.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            lock.lock();
            try {
                while (!fb)
                    fizzBuzz.await();
                if ((i % 3 == 0) && (i % 5 == 0))
                    printFizzBuzz.run();
                fb = false;
                nextTick = true;
                number.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            lock.lock();
            try {
                while (!nextTick)
                    number.await();
                if ((i % 3 != 0) && (i % 5 != 0))
                    printNumber.accept(i);
                f = true;
                nextTick = false;
                fizz.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
