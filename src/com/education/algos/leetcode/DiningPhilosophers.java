package com.education.algos.leetcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
    private final static StringBuffer sb = new StringBuffer(1024);

    private static class Philosopher implements Runnable {
        private final int id;
        private final int n;
        private final StringBuffer sb;
        private final DiningPhilosophers dp;
        private final Runnable pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork;

        public Philosopher(final int id, int n, StringBuffer sb, final DiningPhilosophers dp) {
            this.id = id;
            this.n = n;
            this.sb = sb;
            this.dp = dp;
            pickLeftFork = () -> sb.append("[").append(id).append(", 1, 1], ");
            pickRightFork = () -> sb.append("[").append(id).append(", 2, 1], ");
            eat = () -> sb.append("[").append(id).append(", 0, 3], ");
            putLeftFork = () -> sb.append("[").append(id).append(", 1, 2], ");
            putRightFork = () -> sb.append("[").append(id).append(", 1, 2], ");
        }

        @Override
        public void run() {
            sb.append("[");
            try {
                for (int i = 0; i < n; i++) {
                    dp.wantsToEat(id, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private final ReentrantLock[] locks = new ReentrantLock[]{new ReentrantLock(), new ReentrantLock(), new ReentrantLock(), new ReentrantLock(), new ReentrantLock()};
    private final Condition[] conditions;
    public DiningPhilosophers() {
        conditions = new Condition[locks.length];
        for (int i = 0; i < locks.length; i++) {
            conditions[i] = locks[i].newCondition();
        }
    }

    public static void main(String[] args) {
        final DiningPhilosophers dp = new DiningPhilosophers();
        final ExecutorService exec = Executors.newFixedThreadPool(5);

        for (int i = 0; i <= 5; i++) {
            exec.submit(new Philosopher(i, 1, sb, dp));
        }
        exec.shutdown();
        System.out.println(sb);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork,
                           Runnable eat, Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
        int li = philosopher == 0 ? 4 : philosopher - 1;
        final ReentrantLock left = locks[li];
        final ReentrantLock right = locks[philosopher];
        left.lock();
        right.lock();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        right.unlock();
        putRightFork.run();
        left.unlock();
        putLeftFork.run();
    }
}