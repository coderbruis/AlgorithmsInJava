package com.bruis.algorithminjava.algorithm.leetcode;

/**
 * @Description
 * @Author luohaiyang
 * @Date 2022/6/24
 */
public class MaximumSubarray_53 {

    public static void main(String[] args) {
        // 条件：
        // 1. 连续数组（不可以排序）；

        // 解题思路：
        // 1. 暴力解法；（超时）
        // 2. 正确解法-动态规划；

        // 有卡顿、纠结的点：
        // 1. 算法起始条件、结束条件；

        int[] nusm = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(violentSolution(nusm));
    }

    public static int violentSolution(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }
        int max = nums[0];;
        for (int i = 0; i < n; i++) {
            int subTotal = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                }
                subTotal += nums[j];
                if (max < subTotal) {
                    max = subTotal;
                }
            }
        }
        return max;
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }
        int max = nums[0];
        int i = 0, j = i + 1;
        while (j < n) {
            if (max < nums[j]) {
                max = nums[j];
            }
            int totalMax = 0;
            for (int k = i; k < j; k++) {
                totalMax += nums[i] + nums[j];
            }
            if (max < totalMax) {
                max = totalMax;
            }
            j++;
        }
        return max;
    }
}
