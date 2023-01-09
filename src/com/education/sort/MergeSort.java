package sort;

import java.util.*;
import java.util.concurrent.*;

public class MergeSort {
    //    private static final int[] array = {30, 63, 48, 84, 70, 25, 5, 18, 19, 93, 82, 2, 76, 92, 76, 32, 56, 70, 43, 9};
    private static final int WORKERS_NUMBER = 4;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array = generateArray(200_000_000);
        long start = System.currentTimeMillis();
        parallelMergeSort(array, WORKERS_NUMBER);
        long time = 0L;
        for (int i = 0; i < 5; i++) {
            long s = System.currentTimeMillis();
            parallelMergeSort(array, WORKERS_NUMBER);
            time += System.currentTimeMillis() - s;
            System.out.println("--------------------------------------------");
        }
        System.out.println("Average time: " + time/5);
        long duration = System.currentTimeMillis() - start;
        System.out.println("duration: " + duration);
    }

    private static void parallelMergeSort(int[] array, int workersQty) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(workersQty);
        List<int[]> arrays = divideByNumber(array, workersQty);
        List<Future<int[]>> sortedParts = new ArrayList<>(workersQty);
        for (int i = 0; i < workersQty; i++) {
            int[] part = arrays.get(i);
            sortedParts.add(executor.submit(() -> mergeSort(part)));
        }
        int[] result = null;
        long start = System.currentTimeMillis();
        while(true) {
            if (sortedParts.stream().allMatch(Future::isDone)) {
                break;
            }
        }
        System.out.println("Sorting took: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        for (int i = 0; i < workersQty; i++) {
            result = merge(result, sortedParts.get(i).get());
        }
        System.out.println("merging took: " + (System.currentTimeMillis() - start));
//        System.out.println(Arrays.toString(result));
        executor.shutdown();

//        while (!sortedParts.isEmpty()) {
//            int[] result = null;
//            for (int i = 0; i < sortedParts.size(); i++) {
//                if (sortedParts.get(i).isDone()) {
//                    int[] sortedPart = sortedParts.get(i).get();
//                    result = merge(result, sortedPart);
//                    sortedParts.remove(i);
//                    break;
//                }
//            }
//        }
    }

    private static List<int[]> divideByNumber(int[] array, int parts) {
        List<int[]> result = new ArrayList<>(parts);
        int factor = array.length / parts;
        for (int i = 0; i < parts; i++) {
            result.add(Arrays.copyOfRange(array, i * factor, (i + 1) * factor));
        }
        return result;
    }

    private static int[] generateArray(int n) {
        Random random = new Random(42);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
//            result[i] = random.nextInt(Integer.MAX_VALUE);
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

    static int[] mergeSortStacks(int[] A) {
        Stack<int[]> stack = new Stack<int[]>();
        Stack<int[]> stack2 = new Stack<int[]>();

        for (int i = 0; i < A.length; i++) {
            stack.push(new int[]{A[i]});
        }
        while (stack.size() > 1) {
            while (stack.size() > 1) {

                int[] r = stack.pop();
                int[] l = stack.pop();
                int[] merged = merge(l, r);
                stack2.push(merged);
            }
            while (stack2.size() > 1) {

                int[] r = stack2.pop();
                int[] l = stack2.pop();
                int[] merged = merge(l, r);
                stack.push(merged);
            }
        }
        return stack.isEmpty() ? stack2.pop() : stack.pop();


    }
}
