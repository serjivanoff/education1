package com.education.algos.leetcode;

public class KokoEatingBananas {
    public static void main(String[] args) {
//        System.out.println(2 % 7);
        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184}, 823855818));
        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{2, 2}, 4));
        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{1, 1, 1, 999999999}, 10));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int length = piles.length;
        if (length == 1) {
            return divide(piles[0], h);
        }
        long sum = 0;
        for (int p : piles) sum += p;
        int l = (int) (sum / h), r = (int) ((sum - length) / (h - length + 1)) + 1, m = (l + r) / 2, time = probe(piles, m);
        while (l < r) {
            if (time < h) r = m;
            else l = m + 1;
            m = l + (r - l) / 2;
            time = probe(piles, m);
        }
        return l;
    }

    private int probe(int[] piles, int speed) {
        int time = 0;
        for (int p : piles) {
            time += (p - 1) / speed + 1;
        }
        return time;
    }

    private int divide(int a, int b) {
        if (b == 0 || a <= b) return 1;
        int c = a / b;
        return a % b == 0 ? c : c + 1;
    }

    public int minSpeed(int[] piles, int h) {
        int n = piles.length;
        long total = 0;
        for (int p : piles) {
            total += p;
        }
        int left = (int) ((total - 1) / h) + 1;
        int right = (int) ((total - n) / (h - n + 1)) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int time = 0;
            for (int p : piles) {
                time += (p - 1) / mid + 1;
            }
            if (time > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
