package com.education.algos.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFBT {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n % 2 == 0) return res;
        res.add(new TreeNode(0));
        if (n == 1) return res;
        for (int i = 3; i < n; i += 2) {
            int qty = 0;
        }
        return res;
    }
}