package com.education.algos.leetcode;

import java.util.*;

public class Leetcode75 {
    public static void main(String[] args) {
        Leetcode75 inst = new Leetcode75();
//        System.out.println(inst.gcd(640, 360));
//        System.out.println(inst.gcd(13, 8));
//        System.out.println(inst.mergeAlternately("abc123456", "pqr123"));
//        System.out.println(inst.gcdOfStrings("ABCABC", "ABC"));
//        System.out.println(inst.gcdOfStrings("ABABABAB", "ABAB"));
//        System.out.println(inst.gcdOfStrings("ABABAB", "ABAB"));
//        System.out.println(inst.gcdOfStrings("LEET", "CODE"));
//        System.out.println(inst.gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
//        System.out.println(inst.gcdOfStrings("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
//        System.out.println(inst.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
//        System.out.println(inst.reverseVowels("leetcode"));
//        System.out.println(Arrays.toString(inst.productExceptSelf(new int[]{0, 4, 0})));
//        System.out.println(inst.increasingTriplet(new int[]{6, 5, 5, 0, 4, 6}));
//        System.out.println(inst.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
//        System.out.println(inst.increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}));
//        System.out.println(inst.increasingTriplet(new int[]{0, 4, 2, 1, 0, -1, -3}));
//        System.out.println(inst.increasingTriplet(new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2}));
//        System.out.println(inst.increasingTriplet(new int[]{9, 10, 5, 11, 10, 9, 8}));
//        System.out.println(inst.increasingTriplet(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, 3}));
//        System.out.println(inst.increasingTriplet(new int[]{1, 0, 0, 1}));
//        inst.moveZeroes(new int[]{1, 0, 0, 3, 12});
//        inst.moveZeroes(new int[]{0, 1, 0, 3, 12});
//        inst.moveZeroes(new int[]{0, 0});
//        System.out.println(inst.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
//        System.out.println(inst.findMaxAverage(new int[]{1, 0, 1, 4, 2}, 4));
//        System.out.println(inst.compress(new char[]{'a', 'a','a','a', 'b', 'b', 'c', 'c', 'c'}));
//        System.out.println(inst.compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
//        System.out.println(inst.compress(new char[]{'a', 'a', 'a', 'a', 'a', 'b'}));
//        System.out.println(inst.compress(new char[]{'a'}));
//        System.out.println(inst.maxOperations(new int[]{1, 2, 3, 4}, 5));
//        System.out.println(inst.maxOperations(new int[]{3, 1, 3, 4, 3}, 8));
//        System.out.println(inst.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
//        System.out.println(inst.pivotIndex(new int[]{2, 1, -1}));
//        System.out.println(inst.pivotIndex(new int[]{-1, -1, -1, 1, 1, 1}));
//        System.out.println(inst.findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
//        System.out.println(inst.maxVowels("abciiidef", 3));
//        System.out.println(inst.maxVowels("leetcode", 3));
//        System.out.println(inst.maxVowels("rhythms", 4));
//        System.out.println(inst.maxVowels("weallloveyou", 7));
//        System.out.println(inst.maxVowels("ibpbhixfiouhdljnjfflpapptrxgcomvnb", 33));
//        System.out.println(inst.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
//        System.out.println(inst.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
//        System.out.println(inst.longestOnes(new int[]{1,1,1,0,0,1,0,1,0,1,0,1,1,0,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,1,0,1,1,1,1,1,1,0,1,0,0,0,0,1,0,1,1,0,1,0,1,0,0,1,1,0,1,0,1,0,1,1,1,0,0,1,0,1,1,1,1,1,1,1,1,1,0,0,0,1,1,0,0,1,0,0,1,1,1,1,1,1,1,1,0,0,0,1,1,1,0,0,0,1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1,0,0,1,1,1,1,0,1,0,0,0,1,1,0,0,1,0,1,0,1,1,1,0,0,0,0,0,0,1,0,0,0,1,1,1,0,0,0,1,0,1,0,1,1,0,1,1,0,1,0,1,1,0,1,0,1,1,1,0,1,0,0,1,0,0,0,0,1,1,0,1,1,1,0,0,1,1,0,0,1,0,0,1,0,0,0,0,1,0,0,1,1,0,0,1,1,1,1,0,0,1,0,0,0,0,1,1,1,1,0,0,1,0,0,1,0,0,0,0,0,1,1,0,1,1,0,1,0,0,1,1,1,0,1,0,0,0,0,1,0,0,1,1,0,0,1,0,1,0,1,0,1,1,1,0,0,0,0,1,0,0,1,0,1,1,1,1,1,0,0,1,1,0,1,1,1,0,1,0,0,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,0,0,0,1,1,0,1,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,0,0,1,0,1,1,1,0,1,1,0,1,0,0,1,0,1,1,0,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,0,1,1,1,0,1,0,1,0,1,1,1,0,0,1,0,1,0,1,1,0,0,1,0,0,1,0,1,1,1,1,1,0,1,0,0,0,0,1,1,0,1,1,0,1,1,0,1,0,1,1,1,0,0,1,0,1,1,0,0,0,0,1,1,0,1,1,1,0,1,1,1,1,0,0,1,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,1,1,0,0,0,1,0,1,1,1,0,0,0,0,0,1,1,0,1,0,0,0,0,1,1,0,0,1,0,1,0,0,1,1,1,0,1,0,1,1,0,0,1,1,0,1,1,0,0,0,0,0,0,0,1,0,1,1,0,1,1,0,0,0,0,0,0,1,0,1,1,0,1,1,0,1,0,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,0,0,1,0,1,1,1,1,0,0,0,0,0,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,0,1,0,0,1,1,1,0,0,0,0,1,0,1,0,0,0,1,0,0,1,1,1,1,1,0,1,0,1,0,0,0,0,0,1,0,0,1,0,0,1,1,0,0,1,1}, 144));
//        System.out.println(inst.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
//        System.out.println(inst.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
//        System.out.println(inst.longestSubarray(new int[]{1, 1, 1}));
//        System.out.println(inst.longestSubarray(new int[]{1, 1, 0, 1}));
//        System.out.println(inst.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
//        System.out.println(inst.reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
//        System.out.println(inst.closeStrings("abcde", "aecdb"));
//        System.out.println(inst.closeStrings("abc", "bca"));
//        System.out.println(inst.closeStrings("cabbba", "abbccc"));
//        System.out.println(inst.closeStrings("uau", "ssx"));
//        System.out.println(inst.equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));
//        System.out.println(inst.equalPairs(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}));
//        System.out.println(inst.removeStars("leet**cod*e"));
//        System.out.println(Arrays.toString(inst.asteroidCollision(new int[]{5, 10, -5})));
//        System.out.println(Arrays.toString(inst.asteroidCollision(new int[]{8, -8})));
//        System.out.println(Arrays.toString(inst.asteroidCollision(new int[]{10, 2, -5})));
//        System.out.println(Arrays.toString(inst.asteroidCollision(new int[]{-2, -1, 1, 2})));
//        System.out.println(Arrays.toString(inst.asteroidCollision(new int[]{1, -1, -2, -2})));
//        System.out.println(inst.decodeString("3[a]2[bc]"));
//        System.out.println(inst.decodeString("2[abc]3[cd]ef"));
//        System.out.println(inst.decodeString("3[a2[c]]"));
//        System.out.println(inst.decodeString("abc3[cd]xyz"));
//        System.out.println(inst.deleteMiddle(new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7))))));
//        System.out.println(inst.maxDepth(new TreeNode(0, new TreeNode(2, new TreeNode(1, new TreeNode(5), new TreeNode(1)), null), new TreeNode(4, new TreeNode(3, null, new TreeNode(6)), new TreeNode(-1, null, new TreeNode(8))))));
//        System.out.println(inst.leafSimilar(new TreeNode(1, new TreeNode(3, new TreeNode(4, new TreeNode(7), new TreeNode(8)), new TreeNode(9)), new TreeNode(10)),
//                new TreeNode(1, new TreeNode(3, new TreeNode(4, new TreeNode(7), new TreeNode(8)), new TreeNode(9)), new TreeNode(10))));
//        System.out.println(inst.oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))))));
//        System.out.println(inst.oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3)))));
//        System.out.println(inst.rightSideView(new TreeNode(0, new TreeNode(2, new TreeNode(1, new TreeNode(5), new TreeNode(1)), null), new TreeNode(4, new TreeNode(3, null, new TreeNode(6)), new TreeNode(-1, null, new TreeNode(8))))));
//        System.out.println(inst.maxLevelSum(new TreeNode(0, new TreeNode(17, new TreeNode(1, new TreeNode(5), new TreeNode(1)), null), new TreeNode(4, new TreeNode(3, null, new TreeNode(6)), new TreeNode(-1, null, new TreeNode(8))))));
//        var ans = inst.deleteNode(new TreeNode(2, new TreeNode(1), new TreeNode(3)), 2);
//        System.out.println(inst.canVisitAllRooms(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 0, 1), Arrays.asList(2), Collections.emptyList())));
//        System.out.println(inst.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
//        System.out.println(inst.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
//        System.out.println(inst.findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
//        System.out.println(inst.findCircleNum(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}));
//        System.out.println(inst.findCircleNum(new int[][]{
//                {1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
//                {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
//                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
//                {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
//                {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
//                {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
//                {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
//                {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
//                {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
//                {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
//                {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
//                {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
//                {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
//                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}}));
//        System.out.println(inst.minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));
//        System.out.println(inst.minReorder(5, new int[][]{{4, 3}, {2, 3}, {1, 2}, {1, 0}}));
//        System.out.println(Arrays.toString(inst.calcEquation(asList(
//                asList("a", "b"),
//                asList("b", "c")
//        ), new double[]{2, 3}, asList(asList("a", "c"), asList("b", "a"), asList("a", "e"), asList("a", "a"), asList("x", "x"))
//        )));
//        System.out.println(inst.totalCost(new int[]{18, 64, 12, 21, 21, 78, 36, 58, 88, 58, 99, 26, 92, 91, 53, 10, 24, 25, 20, 92, 73, 63, 51, 65, 87, 6, 17, 32, 14, 42, 46, 65, 43, 9, 75}, 13, 23));
//        System.out.println(inst.totalCost(new int[]{55, 93}, 1, 1));
//        System.out.println(inst.binarySearch(new int[]{1, 2, 3, 3, 3, 6, 7, 8, 9, 10, 11}, 4));
//        System.out.println(Arrays.toString(inst.successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
//        System.out.println(Arrays.toString(inst.successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16)));
//        System.out.println(Arrays.toString(inst.successfulPairs(new int[]{15, 8, 19}, new int[]{38, 35, 23}, 328)));
        System.out.println(Arrays.toString(inst.successfulPairs(
                new int[]{15, 39, 38, 35, 33, 25, 31, 12, 40, 27, 29, 16, 22, 24, 7, 36, 29, 34, 24, 9, 11, 35, 21, 3, 33, 10, 9, 27, 35, 17, 14, 3, 35, 35, 39, 23, 35, 14, 31, 7},
                new int[]{25, 19, 30, 37, 14, 30, 38, 22, 38, 38, 26, 33, 34, 23, 40, 28, 15, 29, 36, 39, 39, 37, 32, 38, 8, 17, 39, 20, 4, 39, 39, 7, 30, 35, 29, 23}, 317)));
    }

    //2300. Successful Pairs of Spells and Potions
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            long factorL = success / spell;
            if (factorL > Integer.MAX_VALUE) {
                ans[i] = 0;
                continue;
            }
            int factor = (int) (factorL * spell < success ? factorL + 1 : factorL);
            int index = binarySearch(potions, factor);
            ans[i] = index == -1 ? ans[i] = 0 : potions.length - index;
        }
        return ans;
    }

    private int binarySearch(int[] array, int target) {
        if (target > array[array.length - 1]) return -1;
        if (target <= array[0]) return 0;
        int i = array.length / 2, res = array[i], l = 0, r = array.length - 1;
        while (res != target) {
            if (target < res) {
                r = i;
            } else {
                l = i;
            }
            i = (l + r) / 2;
            if (i == l) return r;
            res = array[i];
        }
        while (array[i - 1] == target) i--;
        return i;
    }

//2462. Total Cost to Hire K Workers

    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> l = new PriorityQueue<>();
        long ans = 0;
        if (candidates * 2 >= costs.length) {
            for (int c : costs) l.add(c);
            for (int i = 0; i < k; i++) {
                ans += l.poll();
            }
            return ans;
        }
        PriorityQueue<Integer> r = new PriorityQueue<>();
        int i = 0, last = costs.length - 1, center = last / 2;
        while (i < candidates && i < center) {
            l.add(costs[i]);
            int right = last - i;
            if (right < i) break;
            r.add(costs[right]);
            i++;
        }
        int lMark = i, rMark = last - i;
        for (int j = 0; j < k; j++) {
            int left = l.isEmpty() ? Integer.MAX_VALUE : l.peek(), right = r.isEmpty() ? Integer.MAX_VALUE : r.peek();
            if (left <= right) {
                ans += l.poll();
                if (lMark <= rMark) l.add(costs[lMark++]);
            } else {
                ans += r.poll();
                if (rMark >= lMark) r.add(costs[rMark--]);
            }
        }
        return ans;
    }

    //215. Kth Largest Element in an Array
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] heap = new int[k];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (max < nums[i]) max = nums[i];
        }
        heap[0] = max;
        int ptr = 1;
        for (int i = 0; i < n; i++) {

        }
        return heap[k - 1];
    }

    //994. Rotting Oranges
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        int qty = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int next = grid[i][j];
                if (next == 2) queue.add(new int[]{i, j});
                if (next == 1) qty++;
            }
        }
        if (qty == 0) return 0;
        int time = 0;
        int[] incX = new int[]{1, -1, 0, 0};
        int[] incY = new int[]{0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int k = queue.size();
            boolean f = false;
            for (int i = 0; i < k; i++) {
                int[] next = queue.poll();
                int x = next[0], y = next[1];
                for (int j = 0; j < 4; j++) {
                    int xj = x + incX[j], yj = y + incY[j];
                    if (xj >= 0 && yj >= 0 && xj < n && yj < m && grid[xj][yj] == 1) {
                        qty--;
                        f = true;
                        grid[xj][yj] = 2;
                        queue.add(new int[]{xj, yj});
                    }
                }
                if (f) time++;
            }
        }
        return qty == 0 ? time : -1;
    }

    //1926. Nearest Exit from Entrance in Maze
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length, m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] distances = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(entrance);
        distances[entrance[0]][entrance[1]] = 0;
        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            visited[next[0]][next[1]] = true;
            int distance = distances[next[0]][next[1]] + 1;
            int[][] positions = getAvailablePositions(maze, visited, next);
            for (int[] pos : positions) {
                if (pos[0] < 0) continue;
                int x = pos[0], y = pos[1];
                distances[x][y] = distance;
                visited[x][y] = true;
                if (x == 0 || x == n - 1 || y == 0 || y == m - 1) return distance;
                queue.add(pos);
            }
        }
        return -1;
    }

    private int[][] getAvailablePositions(char[][] maze, boolean[][] visited, int[] pos) {
//        up, down, left, right
        int[][] directions = new int[][]{{pos[0] - 1, pos[1]}, {pos[0] + 1, pos[1]}, {pos[0], pos[1] - 1}, {pos[0], pos[1] + 1}};
        int[][] ans = new int[4][4];
        for (int i = 0; i < 4; i++) {
            int x = directions[i][0], y = directions[i][1];
            if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && !visited[x][y] && maze[x][y] == '.') {
                ans[i] = (directions[i]);
            } else {
                ans[i][0] = -1;
            }
        }
        return ans;
    }

    //===========================================================================================
    //399. Evaluate Division
    class Path {
        private Node start, end;
        private boolean visited = false;
        double cost;

        public Path(Node start, Node end, double cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    class Node {
        private final String val;
        private double dist = 1;
        List<Path> paths = new ArrayList<>();

        public Node(String val) {
            this.val = val;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Node> cache = new HashMap<>(values.length);
        for (int i = 0; i < values.length; i++) {
            String from = equations.get(i).get(0), to = equations.get(i).get(1);
            Node start = cache.get(from), end = cache.get(to);
            if (start == null) {
                start = new Node(from);
                cache.put(from, start);
            }
            if (end == null) {
                end = new Node(to);
                cache.put(to, end);
            }
            double cost = values[i];
            start.paths.add(new Path(start, end, cost));
            end.paths.add(new Path(end, start, 1 / cost));
        }
        var ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            String from = q.get(0), to = q.get(1);
            Node start = cache.get(from), end = cache.get(to);
            ans[i] = -1;
            if (start == null || end == null) continue;
            Deque<Node> stack = new ArrayDeque<>();
            stack.push(start);
            start.dist = 1;
            List<Path> paths = new ArrayList<>();
            while (!stack.isEmpty()) {
                Node next = stack.pop();
                if (next == end) {
                    ans[i] = end.dist;
                    break;
                }
                for (Path p : next.paths) {
                    if (p.visited) continue;
                    p.visited = true;
                    paths.add(p);
                    p.end.dist = next.dist * p.cost;
                    stack.push(p.end);
                }
            }
            for (Path p : paths) p.visited = false;
        }
        return ans;
    }
//===================================================================================

    //1466. Reorder Routes to Make All Paths Lead to the City Zero
    public int minReorder(int n, int[][] connections) {
        class Node {
            private int val;
            private boolean visited;
            private List<Node> fNext = new ArrayList<>(), bNext = new ArrayList<>();

            public Node(int val) {
                this.val = val;
            }
        }
        Node[] nodes = new Node[n + 1];
        for (int i = 0; i < connections.length; i++) {
            int start = connections[i][0], end = connections[i][1];
            if (nodes[start] == null) nodes[start] = new Node(start);
            if (nodes[end] == null) nodes[end] = new Node(end);
            nodes[start].fNext.add(nodes[end]);
            nodes[end].bNext.add(nodes[start]);
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(nodes[0]);
        int ans = 0;
        while (!stack.isEmpty()) {
            Node next = stack.pop();
            if (next.visited) continue;
            next.visited = true;
            if (!next.fNext.isEmpty()) {
                for (Node node : next.fNext) {
                    if (!node.visited) {
                        ans++;
                        stack.push(node);
                    }
                }
            }
            if (!next.bNext.isEmpty())
                for (Node node : next.bNext) if (!node.visited) stack.push(node);
        }
        return ans;
    }

    //    547. Number of Provinces
//    private static class Node {
//        int val;
//        Node[] neighbours;
//
//        public Node(int val, int n) {
//            this.val = val;
//            this.neighbours = new Node[n];
//        }
//    }

//    public int findCircleNum(int[][] isConnected) {
//        int n = isConnected.length;
//        Node[] provinces = new Node[n];
//        for (int i = 0; i < n; i++) provinces[i] = new Node(i, n);
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (isConnected[i][j] == 0) continue;
//                if (provinces[i].neighbours[j] == null) {
//                    provinces[i].neighbours[j] = provinces[j];
//                    provinces[j].neighbours[i] = provinces[i];
//                }
//            }
//        }
//        boolean[] visited = new boolean[n];
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            if (visited[i]) continue;
//            Deque<Node> stack = new ArrayDeque<>();
//            stack.push(provinces[i]);
//            while (!stack.isEmpty()) {
//                Node next = stack.pop();
//                visited[next.val] = true;
//                for (Node node : next.neighbours) if (node != null && !visited[node.val]) stack.push(node);
//            }
//            ans++;
//        }
//        return ans;
//    }

    //841. Keys and Rooms
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        if (size == 2) {
            return rooms.get(0).get(0) == 1;
        }
        boolean[] visited = new boolean[size + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        visited[0] = true;
        int n = 1;
        List<Integer> keys = rooms.get(0);
        for (int k : keys) stack.push(k);
        while (!stack.isEmpty()) {
            int next = stack.pop();
            if (!visited[next]) {
                visited[next] = true;
                n++;
                keys = rooms.get(next);
                for (int k : keys) if (!visited[k]) stack.push(k);
            }
        }
        return n == size;
    }

    //450. Delete Node in a BST
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode next = root, parent = null;
        if (root == null) return null;
        if (root.val == key) {
            if (root.left != null) {
                TreeNode right = root.right;
                if (right == null) return root.left;
                root = root.left;
                if (root.right == null) {
                    root.right = right;
                    return root;
                }
                TreeNode r = root.right;
                while (r.right != null) r = r.right;
                r.right = right;
                return root;
            }
            if (root.right != null) {
                return root.right;
            }
            return null;
        }
        boolean isLeftChild = false;
        do {
            if (next == null) return root;
            if (next.val == key) {
                if (next.left != null) {
                    deleteWithRightRotation(parent, next, isLeftChild);
                } else {
                    if (isLeftChild) {
                        parent.left = next.right;
                    } else parent.right = next.right;
                }
                return root;
            }
            parent = next;
            if (key > next.val) {
                next = next.right;
                isLeftChild = false;
            } else {
                next = next.left;
                isLeftChild = true;
            }
        } while (true);
    }


    private void deleteWithRightRotation(TreeNode parent, TreeNode node, boolean isLeftChild) {
        if (isLeftChild) parent.left = node.left;
        else parent.right = node.left;
        if (node.right != null) {
            TreeNode r = node.left.right;
            if (r == null) {
                node.left.right = node.right;
                return;
            }
            while (r.right != null) r = r.right;
            r.right = node.right;
        }
    }

    //700. Search in a Binary Search Tree
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode next = root;
        do {
            if (next == null || next.val == val) return next;
            next = val > next.val ? next.right : next.left;
        } while (true);
    }

    //    1161. Maximum Level Sum of a Binary Tree
    public int maxLevelSum(TreeNode root) {
        if (root.right == null && root.left == null) {
            return 1;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int ans = 1, max = root.val, depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(), sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode next = queue.poll();
                sum += next.val;
                TreeNode l = next.left, r = next.right;
                if (l != null) queue.add(l);
                if (r != null) queue.add(r);
            }
            depth++;
            if (max < sum) {
                max = sum;
                ans = depth;
            }
        }
        return ans;
    }

    //199. Binary Tree Right Side View
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        if (root.right == null && root.left == null) {
            ans.add(root.val);
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size() - 1;
            for (int i = 0; i < size; i++) {
                addChildren(queue.poll(), queue);
            }
            TreeNode next = queue.poll();
            ans.add(next.val);
            addChildren(next, queue);
        }
        return ans;
    }

    private void addChildren(TreeNode node, Queue<TreeNode> queue) {
        TreeNode l = node.left, r = node.right;
        if (l != null) queue.add(l);
        if (r != null) queue.add(r);
    }

    //    328. Odd Even Linked List
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode cur = head, b = head.next, e = b, last = e.next;
        cur.next = last;
        e = last.next;
        b.next = e;
        last.next = b;
        cur = cur.next;
        if (e == null) return head;
        last = e.next;
        while (last != null) {
            cur.next = last;
            e.next = last.next;
            last.next = b;
            cur = cur.next;
            e = e.next;
            if (e == null) break;
            last = e.next;
        }
        return head;
    }

    //    872. Leaf-Similar Trees
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack = new Stack<>();
        int[] vals = new int[101];
        int i = 0;
        stack.push(root1);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            TreeNode l = cur.left, r = cur.right;
            boolean f = false;
            if (r != null) {
                stack.push(r);
                f = true;
            }
            if (l != null) {
                stack.push(l);
                f = true;
            }
            if (!f) vals[i++] = cur.val;
        }
        int j = 0;
        stack = new Stack<>();
        stack.push(root2);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            TreeNode l = cur.left, r = cur.right;
            boolean f = false;
            if (r != null) {
                stack.push(r);
                f = true;
            }
            if (l != null) {
                stack.push(l);
                f = true;
            }
            if (!f && vals[j++] != cur.val) return false;
        }
        return i == j;
    }

    //104. Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        nodes.push(root);
        int max = 0;
        depths.push(1);
        while (!nodes.isEmpty()) {
            TreeNode cur = nodes.pop();
            int depth = depths.pop();
            boolean f = false;
            TreeNode l = cur.left, r = cur.right;
            if (l != null) {
                nodes.push(l);
                depth++;
                depths.push(depth);
                f = true;
            }
            if (r != null) {
                nodes.push(r);
                if (!f) {
                    depth++;
                    f = true;
                }
                depths.push(depth);
            }
            if (f && max < depth) max = depth;
        }
        return max;
    }

    //    2095. Delete the Middle Node of a Linked List
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        int l = 1;
        ListNode cur = head;
        while (cur.next != null) {
            l++;
            cur = cur.next;
        }
        if (l == 2) {
            head.next = null;
            return head;
        }
        cur = head;
        int marker = l / 2 - 1;
        for (int i = 0; i < marker; i++) {
            cur = cur.next;
        }
        ListNode tmp = cur;
        tmp.next = cur.next.next;
        return head;
    }

    //    394. Decode String
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        char[] ans = new char[100_000];
        int p = 0;
        Stack<Integer> ns = new Stack<>();
        Stack<char[]> strs = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ']') {
                char[] str = multiply(strs.pop(), ns.pop());
                if (ns.isEmpty()) {
                    System.arraycopy(str, 0, ans, p, str.length);
                    p += str.length;
                } else {
                    if (!strs.isEmpty()) {
                        char[] str1 = strs.pop();
                        char[] merge = new char[str1.length + str.length];
                        System.arraycopy(str1, 0, merge, 0, str1.length);
                        System.arraycopy(str, 0, merge, str1.length, str.length);
                        strs.push(merge);
                    } else
                        strs.push(str);
                }
                continue;
            }
            char[] str = new char[30];
            int k = 0;
            if (c > 48 && c < 58) {
                char[] digits = new char[3];
                while (i < chars.length - 1 && c > 48 && c < 58) {
                    digits[k++] = c;
                    c = chars[++i];
                }
                ns.push(toNumber(digits, k));
                k = 0;
                c = chars[++i];
                while (i < chars.length - 1 && c > 96 && c < 123) {
                    str[k++] = c;
                    c = chars[++i];
                }
                i--;
                char[] str1 = new char[k];
                System.arraycopy(str, 0, str1, 0, k);
                strs.push(str1);
                continue;
            }
            str[k++] = c;
            c = chars[++i];
            while (i < chars.length - 1) {
                if (c < 97 || c > 122) break;
                str[k++] = c;
                c = chars[++i];
            }
            char[] str1 = new char[k];
            System.arraycopy(str, 0, str1, 0, k);
            if (ns.isEmpty()) {
                System.arraycopy(str1, 0, ans, p, str1.length);
                p += str1.length;
            } else strs.push(str1);
        }
        if (!strs.isEmpty()) {
            char[] str = strs.pop();
            System.arraycopy(str, 0, ans, p, str.length);
            p += str.length;
        }
        return new String(ans, 0, p);
    }

    private char[] multiply(char[] str, int k) {
        int l = str.length;
        char[] res = new char[l * k];
        for (int i = 0; i < k; i++) {
            System.arraycopy(str, 0, res, l * i, l);
        }
        return res;
    }

    private int toNumber(char[] digits, int k) {
        int dec = 1, res = 0;
        for (int i = k - 1; i >= 0; i--) {
            res += (digits[i] - 48) * dec;
        }
        return res;
    }

    //    735. Asteroid Collision
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            collide(stack, asteroids[i]);
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    private void collide(Stack<Integer> stack, int b) {
        if (stack.isEmpty()) {
            stack.push(b);
            return;
        }
        int a = stack.peek();
        do {
            if (a > 0) {
                if (b > 0) {
                    stack.push(b);
                    return;
                }
                int sum = a + b;
                if (sum < 0) {
                    stack.pop();
                    stack.push(b);
                } else if (sum == 0) {
                    stack.pop();
                    return;
                }
            } else {
                stack.push(b);
                return;
            }
            if (stack.size() < 2) return;
            b = stack.pop();
            a = stack.peek();
        }
        while (!stack.isEmpty() && (a > 0 && b < 0));
        stack.push(b);
    }

    //2390. Removing Stars From a String
    public String removeStars(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c != '*') stack.push(c);
            else stack.pop();
        }
        if (stack.isEmpty()) return "";
        char[] ans = new char[stack.size()];
        int i = ans.length - 1;
        do {
            ans[i--] = stack.pop();
        } while (!stack.isEmpty());
        return new String(ans);
    }

    //    2352. Equal Row and Column Pairs
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> rows = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = 0;
            for (int j = 0; j < n; j++) {
                key = grid[i][j] + 7 * key;
            }
            Integer qty = rows.get(key);
            if (qty == null) qty = 1;
            else qty++;
            rows.put(key, qty);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int key = 0;
            for (int j = 0; j < n; j++)
                key = grid[j][i] + 7 * key;
            ans += rows.getOrDefault(key, 0);
        }
        return ans;
    }
//1657. Determine if Two Strings Are Close

    public boolean closeStrings(String word1, String word2) {
        char[] chars1 = word1.toCharArray(), chars2 = word2.toCharArray();
        if (chars1.length != chars2.length) return false;
        int[] hash1 = new int[26], hash2 = new int[26];
        for (int i = 0; i < chars1.length; i++) {
            hash1[chars1[i] - 97]++;
            hash2[chars2[i] - 97]++;
        }
        int[] h11 = new int[100_001], h12 = new int[100_001];
        for (int i = 0; i < 26; i++) {
            int h1 = hash1[i], h2 = hash2[i];
            if (h1 != 0 && h2 == 0 || h1 == 0 && h2 != 0) {
                return false;
            }
            h11[h1]++;
            h12[h2]++;
        }
        for (int i = 1; i < 100_001; i++) {
            if (h11[i] != h12[i]) return false;
        }
        return true;
    }

    //206. Reverse Linked List
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "val=" + val;
        }

    }

    public ListNode reverseList(ListNode head) {
        if (head != null) {
            Stack<ListNode> stack = new Stack<>();
            ListNode cur = head;
            while (cur.next != null) {
                stack.push(cur);
                cur = cur.next;
            }
            head = cur;
            while (!stack.isEmpty()) {
                cur.next = stack.pop();
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }

    //================================================================================================
    //1493. Longest Subarray of 1's After Deleting One Element
    public int longestSubarray(int[] nums) {
        int l = 0, r = 0, nZeroes = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int cur = r - l - 1;
                if (max < cur) max = cur;
                if (nZeroes == 0) {
                    nZeroes = 1;
                } else {
                    while (nums[l++] != 0 && l <= r) ;
                }
            }
            r++;
        }
        int cur = r - l - 1;
        if (max < cur) max = cur;
        return max;
    }

    //1207. Unique Number of Occurrences
    public boolean uniqueOccurrences(int[] arr) {
        int[] qts = new int[2001];
        int[] hashes = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            qts[arr[i] + 1000]++;
        }
        for (int i = 0; i < qts.length; i++) {
            hashes[qts[i]]++;
        }
        for (int i = 1; i < hashes.length; i++) if (hashes[i] > 1) return false;
        return true;
    }

    //1004. Max Consecutive Ones III
    public int longestOnes(int[] nums, int k) {
        if (k == nums.length) return k;
        int cur = 0, max = 0, qty = k, lastOne = -1;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n == 0) {
                if (qty > 0) {
                    cur++;
                    qty--;
                    continue;
                }
                if (max < cur) max = cur;
                cur = 0;
                qty = k;
                if (lastOne != -1) {
                    i = lastOne;
                    cur = 1;
                    lastOne = -1;
                    continue;
                }
                while (i < nums.length && nums[i] == 0) i++;
                if (i < nums.length) i--;
            } else {
                if (lastOne == -1 && i != 0 && nums[i - 1] == 0) lastOne = i;
                cur++;
            }
        }
        if (max < cur) max = cur;
        if (max != nums.length && max == cur && qty > 0) max += qty;
        return max;
    }

    //1456. Maximum Number of Vowels in a Substring of Given Length
    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        char[] vowels = new char[118];
        vowels[97] = 1;
        vowels[101] = 1;
        vowels[105] = 1;
        vowels[111] = 1;
        vowels[117] = 1;
        int cur = 0;
        for (int i = 0; i < k && i < chars.length; i++) {
            char c = chars[i];
            if (c < 118 && vowels[c] == 1) cur++;
        }
        if (cur == k || k == chars.length) return cur;
        int l = 0, r = k, max = cur;
        while (r < chars.length) {
            char left = chars[l], right = chars[r];
            if (left < 118 && vowels[left] == 1) cur--;
            l++;
            if (right < 118 && vowels[right] == 1) cur++;
            r++;
            if (cur == k) return k;
            if (max < cur) max = cur;
        }
        return max;
    }

    //2215. Find the Difference of Two Arrays
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int[] hash1 = new int[2002], hash2 = new int[2002];
        for (int i = 0; i < nums1.length; i++) {
            hash1[nums1[i] + 1000] = 1;
        }
        for (int i = 0; i < nums2.length; i++) {
            hash2[nums2[i] + 1000] = 1;
        }
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < 2002; i++) {
            if (hash1[i] == 1 && hash2[i] == 0) l1.add(i - 1000);
            else if (hash2[i] == 1 && hash1[i] == 0) l2.add(i - 1000);
        }
        res.add(l1);
        res.add(l2);
        return res;
    }

    //    724
    public int pivotIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int last = sums[sums.length - 1];
        for (int i = 0; i < sums.length - 1; i++) {
            if (sums[i] == last - sums[i + 1]) return i;
        }
        return last == 0 ? 0 : -1;
    }

    //1679
    public int maxOperations(int[] nums, int k) {
        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] + nums[1] == k ? 1 : 0;
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, ans = 0;
        do {
            int left = nums[l], right = nums[r];
            int sum = left + right;
            if (sum == k) {
                ans++;
                l++;
                r--;
                continue;
            }
            if (sum > k) r--;
            else l++;
        } while (r > l);
        return ans;
    }

    // 443
    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        int l = 0, count = 1;
        char c = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == c) {
                count++;
                continue;
            }
            chars[l++] = c;
            c = chars[i];
            if (count == 1) {
                continue;
            }
            char[] length = toChars(count);
            System.arraycopy(length, 0, chars, l, length.length);
            l += length.length;
            count = 1;
        }
        chars[l++] = c;
        if (count != 1) {
            char[] length = toChars(count);
            System.arraycopy(length, 0, chars, l, length.length);
            l += length.length;
        }
        return l;
    }

    private char[] toChars(int arg) {
        int length = arg >= 1000 ? 4 : arg >= 100 ? 3 : arg >= 10 ? 2 : 1;
        char[] result = new char[length];
        int dec = 1;
        for (int i = 1; i < length; i++) {
            dec *= 10;
        }
        for (int i = length - 1; i >= 0; i--) {
            result[length - i - 1] = (char) ((arg / dec) + 48);
            arg = arg % dec;
            dec /= 10;
        }
        return result;
    }

    //643
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == k) return getAverage(nums, 0, k - 1);
        int l = 0, r = k - 1, sum = 0, max = Integer.MIN_VALUE;
        while (r < nums.length) {
            sum = getSum(nums, l, r);
            if (sum > max) max = sum;
            l++;
            r++;
        }
        return ((double) max) / k;
    }

    private int getSum(int[] array, int from, int to) {
        int sum = 0;
        for (int i = from; i <= to; i++) sum += array[i];
        return sum;
    }

    private double getAverage(int[] array, int from, int to) {
        return ((double) getSum(array, from, to)) / array.length;
    }
//------------------------------

    //283
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) return;
        int l = -1, r = -1;
        for (int i = 0; i < nums.length; i++) {
            if (l == -1 && nums[i] != 0) continue;
            if (l == -1) {
                l = r = i;
            }
            while (r < nums.length && nums[r] == 0) r++;
            if (r == nums.length) return;
            nums[l] = nums[r];
            nums[r] = 0;
            i = r;
            l++;
        }
    }

    //334
    public boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        if (length < 3) return false;
        int min = nums[0], mid = Integer.MAX_VALUE;
        for (int i = 1; i < length; i++) {
            int next = nums[i];
            if (next > mid) return true;
            if (next > min) {
                mid = Math.min(next, mid);
            }
            min = Math.min(next, min);
        }
        return false;
    }

    //238
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        boolean z = false, sz = false;
        for (int i : nums) {
            if (i != 0) {
                product *= i;
            } else {
                if (z) sz = true;
                z = true;
            }
        }
        int[] ans = new int[nums.length];
        if (sz) return ans;
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] == 0 ? product : z ? 0 : product / nums[i];
        }
        return ans;
    }

    //345
    //==============================================================
    public String reverseVowels(String s) {
        if (s.length() == 1) return s;
        boolean[] vowels = new boolean[128];
        vowels[97] = true;
        vowels[101] = true;
        vowels[105] = true;
        vowels[111] = true;
        vowels[117] = true;
        vowels[65] = true;
        vowels[69] = true;
        vowels[73] = true;
        vowels[79] = true;
        vowels[85] = true;
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            while (l < r && !vowels[chars[l]]) l++;
            while (r > l && !vowels[chars[r]]) r--;
            swap(chars, l, r);
            l++;
            r--;
        }
        return new String(chars);
    }

    private void swap(char[] chars, int l, int r) {
        char c = chars[l];
        chars[l] = chars[r];
        chars[r] = c;
    }

    //==============================================================
    //605
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        if (flowerbed.length == 1) {
            return flowerbed[0] == 0;
        }
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }
        if (n == 0) return true;
        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            flowerbed[flowerbed.length - 1] = 1;
            n--;
        }
        if (n == 0) return true;
        for (int i = 2; i < flowerbed.length - 1; i++) {
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                n--;
                flowerbed[i] = 1;
            }
            if (n == 0) return true;
        }
        return false;
    }

    //1768
//    ================================================================================
    public String mergeAlternately(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray(), ans = new char[w1.length + w2.length];
        boolean isW1 = w1.length > w2.length;
        int minL = isW1 ? w2.length : w1.length, j = 0;
        for (int i = 0; i < minL; i++) {
            ans[j++] = w1[i];
            ans[j++] = w2[i];
        }
        if (w1.length != w2.length) {
            if (isW1) copy(w1, ans, minL, j);
            else copy(w2, ans, minL, j);
        }
        return new String(ans);
    }

    private void copy(char[] src, char[] dest, int startSrc, int startDest) {
        for (int i = startSrc; i < src.length; i++) {
            dest[startDest++] = src[i];
        }
    }

    //=====================================================================================
    //1071
//===============================================================
    public String gcdOfStrings(String str1, String str2) {
        char[] chars1 = str1.toCharArray(), chars2 = str2.toCharArray();
        boolean isStr1Longer = chars1.length > chars2.length;
        if (isStr1Longer ? checkPrefix(chars1, chars2, chars2.length) : checkPrefix(chars2, chars1, chars1.length)) {
            return isStr1Longer ? str2 : str1;
        }
        int gcd = isStr1Longer ? gcd(chars1.length, chars2.length) : gcd(chars2.length, chars1.length);
        char[] prefix = Arrays.copyOf(chars1, gcd);
        if (checkPrefix(chars1, prefix, gcd) && checkPrefix(chars2, prefix, gcd)) return new String(prefix);
        return "";
    }

    private boolean checkPrefix(char[] chars, char[] prefix, int l) {
        if (chars.length % l != 0) return false;
        int j = 0;
        for (char c : chars) {
            if (prefix[j++] != c) return false;
            if (l == j) j = 0;
        }
        return true;
    }

    //    i2 <= i1
    private int gcd(int i1, int i2) {
        if (i1 == i2) return i1;
        int rem = i1 % i2;
        if (rem == 0) return i2;
        int ans = i2;
        do {
            int tmp = rem;
            rem = ans % rem;
            ans = tmp;
        } while (rem != 0);
        return ans;
    }
//    ==========================================================================================================
}
