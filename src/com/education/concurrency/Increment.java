package com.education.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Increment {
    private final static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Holder h = new Holder();
        ExecutorService service = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(2);

        Future<?> f1 = service.submit(() -> {
            for (int i = 0; i < 1_000_000_000; i++)
                h.increment();
            latch.countDown();
        });
        Future<?> f2 = service.submit(() -> {
            for (int i = 0; i < 1_000_000_000; i++)
                h.increment();
            latch.countDown();
        });
    //        f1.get();
    //        f2.get();
        latch.await();
        System.out.println(h.i);
        service.shutdown();
    }


    private static class Holder {
        int i;
        private synchronized void increment() {
            i++;
        }

    }
}
