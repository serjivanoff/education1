package com.education.algos.leetcode;

import javax.swing.table.TableStringConverter;
import java.util.Arrays;

import static java.lang.Math.abs;

public class ThreeSumClosest {

    public static void main(String[] args) {
//        int[] nums = new int[]{147, 465, -917, -321, 551, 982, -967, -672, 670, -859, -776, 290, -406, 223, 123, -266, 730, 339, 792, 588, 138, 822, 474, -615, 386, -392, 559, 364, 124, 829, -505, 553, -284, -458, -826, -791, -67, -798, 932, -828, -739, 65, -782, -159, 363, -123, 893, -992, -662, -65, -352, -649, -357, 780, -690, -584, -660, -427, 802, 113, 856, 34, -145, -97, -8, 488, 467, -24, 967, 96, -915, 309, -931, 989, -789, 886, -568, 451, 965, -344, 917, -994, 865, -537, 241, -761, 812, 768, 648, 594, -702, -640, 845, 350, -408, 984, 870, 246, -107, 508, -860, -298, 514, 349, 960, -663, -616, -87, 566, -449, 161, 522, 293, 270, -276, 928, -612, 117, -263, 721, -692, -712, 995, 729, 115, 463, 328, 397, -781, -253, 782, -542, 71, 919, 286, -732, -271, 401, -820, 51, -232, -170, -189, 154, -487, -221, 632, 860, 38, -224, 839, -227, 656, 194, -331, -422, -997, 784, 640, -367, 385, 202, 520, -553, -44, 208};
//        int[] nums = new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5};
        int[] nums = new int[]{2,3,8,9,10};
        ThreeSumClosest quiz = new ThreeSumClosest();
        System.out.println(quiz.threeSumClosest(nums, 16));
    }

    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        if (length == 3) return threeSum(nums, 0, 1, 2);
        Arrays.sort(nums);
        int sum = threeSum(nums, length - 3, length - 2, length - 1);
        if (sum <= target) return sum;
        sum = threeSum(nums, 0, 1, 2);
        if (sum >= target) return sum;
        for (int l = 0; l < length - 2; l++) {
            int c = l + 1, r = length - 1, cur = threeSum(nums, l, c, r), loc = cur;
            while (c < r - 1 && target != loc) {
                if (loc < target) c++;
                else r--;
                loc = threeSum(nums, l, c, r);
                if (abs(loc - target) < abs(cur - target)) {
                    cur = loc;
                    if (target == cur) return target;
                }
            }
            if (abs(cur - target) < abs(sum - target)) {
                sum = cur;
                if (target == sum) return target;
            }
        }
        return sum;
    }

    private int threeSum(int[] nums, int l, int c, int r) {
        return nums[r] + nums[c] + nums[l];
    }
}
