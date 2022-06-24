package com.bruis.algorithminjava.algorithm.leetcode;

/**
 * @Description
 * @Author luohaiyang
 * @Date 2022/4/28
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        return twoPointer(numbers, target);
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param numbers
     * @param target
     * @return
     */
    private int[] twoPointer(int[] numbers, int target) {
        int n = numbers.length;
        if (n < 2) {
            return numbers;
        }
        int i = 0, j = n - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            }
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[0];
    }

    /**
     * 暴力法：
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param numbers
     * @param target
     * @return
     */
    private int[] forceSolution(int[] numbers, int target) {
        int n = numbers.length;
        if (n < 2) {
            return numbers;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[0];
    }
}
