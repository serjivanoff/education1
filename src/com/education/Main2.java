package com.education;

import java.util.Collections;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> maxes = new Main2().get3Maxes(List.of(16, 7, 7, 7, 7, 8, 9, 16));
        System.out.println(maxes);
    }

    private List<Integer> get3Maxes(List<Integer> input) {
        if (input == null || input.isEmpty()) {
//            some Logging
            return Collections.emptyList();
        }
        if (input.size() < 4) {
            return input;
        }
        int max1 = input.get(0), max2 = input.get(1), max3 = input.get(2);
        if (max2 > max1) {
            int a = max1;
            max1 = max2;
            max2 = a;
        }
        if (max3 > max1) {
            int a = max1;
            max1 = max3;
            max3 = a;
        }
        if (max3 > max2) {
            int a = max1;
            max1 = max2;
            max2 = a;
        }
        for (int i = 3; i < input.size(); i++) {
            int current = input.get(i);
            if (current > max1) {
                max3 = max2;
                max2 = max1;
                max1 = current;
                continue;
            }
            if (current > max2) {
                max3 = max2;
                max2 = current;
                continue;
            }
            if (current > max3) {
                max3 = current;
            }
        }
        return List.of(max1, max2, max3);
    }

}
