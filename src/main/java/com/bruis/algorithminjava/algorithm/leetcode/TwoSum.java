package com.bruis.algorithminjava.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author luohaiyang
 * @Date 2022/4/28
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // 暴力破解法
//        return forceSolution(nums, target);
        return optimizeSolution01(nums, target);
    }

    /**
     * 对optimizeSolution01进行优化，少进行一次for循环
     * 时间复杂度: O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    private int[] optimizeSolution02(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> arrayMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (arrayMap.containsKey(target - num)) {
                return new int[]{arrayMap.get(target - num), i};
            }
            arrayMap.put(num, i);
        }
        return new int[0];
    }

    /**
     * 借助jdk hashmap，
     * 时间复杂度: O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    private int[] optimizeSolution01(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> arrayMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int targetVal = target - num;
            arrayMap.put(targetVal, i);
        }
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (arrayMap.containsKey(num)) {
                int index = arrayMap.get(num);
                if (index > i) {
                    return new int[]{i, index};
                } else {
                    return new int[]{index, i};
                }
            }
        }
        return new int[0];
    }

    /**
     * 暴力破解法
     * 时间复杂度：o(n^2)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    private int[] forceSolution(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int val = target - num;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == val) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
