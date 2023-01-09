package com.education.leetcode.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class H2O {
//    private final Lock lock = new ReentrantLock();
//    private final Condition oArrived = lock.newCondition(), h2Arrived = lock.newCondition();
//    private boolean oxygen = true, hydrogen1, hydrogen2;

    private final Semaphore oxygen = new Semaphore(1), hydrogen = new Semaphore(2);

    public static void main(String[] args) {
        H2O h2O = new H2O();
        Runnable releaseHydrogen = () -> System.out.println("H"), releaseOxygen = () -> System.out.println("O");
        new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++)
                    h2O.hydrogen(releaseHydrogen);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++)
                    h2O.oxygen(releaseOxygen);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogen.acquire();
        releaseHydrogen.run();
        if (hydrogen.availablePermits() == 0)
            oxygen.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygen.acquire();
        releaseOxygen.run();
        hydrogen.release(2);
    }

//    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
//        lock.lock();
//        try {
//            while (!oxygen)
//                oArrived.await();
//            releaseHydrogen.run();
//            if (hydrogen1) {
//                hydrogen2 = true;
//                oxygen = false;
//                h2Arrived.signal();
//            } else {
//                hydrogen1 = true;
//            }
//        } finally {
//            lock.unlock();
//        }
//    }

//    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
//        lock.lock();
//        try {
//            while (!hydrogen1 || !hydrogen2)
//                h2Arrived.await();
//            releaseOxygen.run();
//            oxygen = true;
//            hydrogen2 = hydrogen1 = false;
//            oArrived.signal();
//        } finally {
//            lock.unlock();
//        }
//    }
}
