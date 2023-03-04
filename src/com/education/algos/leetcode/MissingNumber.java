package leetcode;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
//        int[] nums = {1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int S = 0;
        for(int n: nums)
            S += n;
        return nums.length * (nums.length + 1) / 2  - S;
    }

    public static int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0) {
            return 0;
        }
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] - nums[i - 1]) != 1) {
                return nums[i - 1] + 1;
            }
        }
        return nums.length;
    }
}
