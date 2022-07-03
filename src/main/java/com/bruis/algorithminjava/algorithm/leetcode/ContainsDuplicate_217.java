package com.bruis.algorithminjava.algorithm.leetcode;

import java.util.*;

/**
 * 217: Contains Duplicate
 * @Description
 * @Author luohaiyang
 * @Date 2022/6/24
 */
public class ContainsDuplicate_217 {

    public static void main(String[] args) {
        int[] test = {1, 2, 30, 22, 3, 4, 5, 1};
        System.out.println(containsDuplicate(test));
    }

    public static boolean containsDuplicate(int[] nums) {
        // 数组类型题思考步骤：
        // 1) 入参是否合法，是否越界等;
        // 2) 是否是有序；
        // 3) 是否有负数；

        // 题解思路：
        // 1. 暴力破解法; O(n^2);
        // 2. 桶排序？
        //   2.1 需要Map数据结构；
        //   2.2 不需要Map数据结构；
        // 3. 排序之后，判断前后数字是否一样；

        return false;
    }

    public static boolean setSolution(int[] nums) {
        int n = nums.length;
        if (n < 1) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 通过排序来进行筛选
     * @param nums
     * @return
     */
    public static boolean sortSolution(int[] nums) {
        int n = nums.length;
        if (n < 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 基于桶排序
     * @param nums
     * @return
     */
    public static boolean bucketMapSolution(int[] nums) {
        int n = nums.length;
        if (n < 1) {
            return false;
        }

        Map<Integer, Integer> duplicateMap = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            if (!duplicateMap.containsKey(nums[i])) {
                duplicateMap.put(nums[i], 1);
                continue;
            }
            return true;
        }
        return false;
    }

    /**
     * 暴力解法
     * @param nums
     * @return
     */
    public static boolean violentSolution(int[] nums) {
        if (nums.length < 1) {
            return false;
        }

        // 方法一：暴力解法
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i != j && nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
