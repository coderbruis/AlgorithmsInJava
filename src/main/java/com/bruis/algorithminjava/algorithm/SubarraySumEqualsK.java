package com.bruis.algorithminjava.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LuoHaiYang
 *
 * @Date 2020-05-15
 * 560. Subarray Sum Equals K
 * url: https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 *
 */
public class SubarraySumEqualsK {
    /**
     * O (n^3)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum01(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                int sum = 0;
                for (int i = left; i <= right; i++) {
                    sum += nums[i];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 1. 欠考虑情况
     *      ① 单个元素作为一个子数组；
     *      ② 所有元素值都相同的情况；
     *
     * 时间复杂：O (n^2)
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum02(int[] nums, int k) {
        int length = nums.length;
        int count = 0;

        // 0, 0, 0, 0
        // l
        //    r

        for (int left = 0; left < length; left++) {
            int right = left + 1;
            int sums = nums[left];
            if (sums == k) {
                count++;
            }
            while (right < length) {
                sums += nums[right++];
                if (sums == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum03(int[] nums, int k) {
        int length = nums.length;

        int[] preSum = new int[length + 1];
        preSum[0] = 0;
        for (int i = 0; i < length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        // 1, 2, 3, 4
        // 0  1  3  6  10
        //          l
        //              r

        int count = 0;
        for (int left = 0; left < length; left++) {
            int right = left + 1;
            while (right <= length) {
                if (preSum[right++] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     *
     * O (n)
     * 前缀和 + 哈希表
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum04(int[] nums, int k) {
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        // 1. 可以进行排序不？
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        //int[] nums = {0,0,0,0,0,0,0,0,0,0};
        int[] nums = {1, 2, 3, 4};
        System.out.println(subarraySumEqualsK.subarraySum04(nums, 5));
    }
}
