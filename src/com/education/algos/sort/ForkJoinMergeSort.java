package sort;


import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinMergeSort {
    private static final int ARRAY_LENGTH = 200_000_000;
//    private static final int WORKERS_NUMBER = 8;
    private static final int THRESHOLD = ARRAY_LENGTH / 8;

    public static void main(String[] args) {
        int[] array = generateArray(ARRAY_LENGTH);
        long start = System.currentTimeMillis();
//        ForkJoinPool pool = new ForkJoinPool();
//        int[] sorted = pool.invoke(new ForkJoinMergeSorter(array));
        int[] sorted = new ForkJoinMergeSorter(array).compute();
        long time = 0L;
        for (int i = 0; i < 5; i++) {
            long s = System.currentTimeMillis();
//            sorted = pool.invoke(new ForkJoinMergeSorter(array));
            sorted = new ForkJoinMergeSorter(array).compute();
            time += System.currentTimeMillis() - s;
        }
        System.out.println("Average time: " + time/5);
        long duration = System.currentTimeMillis() - start;
        System.out.println("duration: " + duration);
//        pool.shutdown();
    }


    private static int[] generateArray(int n) {
        Random random = new Random(42);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = random.nextInt(500);
        }
        return result;
    }

    private static int[] mergeSort(int[] arr) {
        Stack<Node> stack = new Stack<>();
        Node firstNode = divideOnce(arr);
        stack.push(firstNode);
        while (!isStackFullyTraversed(stack)) {
            Node node = stack.peek();
            if (node.sortedMerged == null && node.left.length > 1) {
                stack.push(divideOnce(node.left));
            } else if (node.left.length == 1) {
                if (node.right.length > 1) {
                    if (node.sortedMerged == null) {
                        stack.push(divideOnce(node.right));
                        continue;
                    }
                    node = stack.pop();
                    int[] sortedMerged = merge(node.left, node.sortedMerged);
                    saveSortedMerged(stack, sortedMerged);
                    continue;
                }
                node = stack.pop();
                int[] sortedMerged = merge(node.left, node.right);
                saveSortedMerged(stack, sortedMerged);
            } else if (isNodeFullyTraversed(node)) {
                node = stack.pop();
                saveSortedMerged(stack, node.sortedMerged);
            } else {
                stack.push(divideOnce(stack.peek().right));
            }
        }
        return firstNode.sortedMerged;
    }

    private static boolean isStackFullyTraversed(Stack<Node> stack) {
        return stack.size() == 1 && isNodeFullyTraversed(stack.peek());
    }

    private static boolean isNodeFullyTraversed(Node n) {
        return n.sortedMerged != null && n.sortedMerged.length == n.left.length + n.right.length;
    }

    private static void saveSortedMerged(Stack<Node> stack, int[] sorted) {
        stack.peek().sortedMerged = merge(stack.peek().sortedMerged, sorted);
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        if (arr1 == null) {
            return arr2;
        }
        int[] result = new int[arr1.length + arr2.length];
        for (int a1 = 0, a2 = 0, r = 0; a1 < arr1.length || a2 < arr2.length; ) {
            if (a1 == arr1.length) {
                result[r++] = arr2[a2++];
                continue;
            }
            if (a2 == arr2.length) {
                result[r++] = arr1[a1++];
                continue;
            }
            if (arr1[a1] <= arr2[a2]) {
                result[r++] = arr1[a1++];
            } else {
                result[r++] = arr2[a2++];
            }
        }
        return result;
    }

    private static Node divideOnce(int[] arr) {
        int middle = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return new Node(left, right);
    }

    private static class Node {
        int[] left;
        int[] right;
        int[] sortedMerged;

        public Node(int[] left, int[] right) {
            this.left = left;
            this.right = right;
        }
    }

    private static class ForkJoinMergeSorter extends RecursiveTask<int[]> {
        final int[] array;

        private ForkJoinMergeSorter(int[] array) {
            this.array = array;
        }

        @Override
        protected int[] compute() {
            if (array.length > THRESHOLD) {
                int middle = array.length / 2;
                ForkJoinMergeSorter left = new ForkJoinMergeSorter(Arrays.copyOfRange(array, 0, middle));
                ForkJoinMergeSorter right = new ForkJoinMergeSorter(Arrays.copyOfRange(array, middle, array.length));
                left.fork();
                right.fork();
                int[] rightSide = right.join();
                int[] leftSide = left.join();
                return merge(leftSide, rightSide);
            }
            return mergeSort(array);
        }
    }
}