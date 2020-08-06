package com.bruis.algorithminjava.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LuoHaiYang
 *
 * url: https://leetcode-cn.com/problems/two-sum/
 *
 */
public class TwoSum {

    /**
     *
     * nums = [2, 7, 11, 15], target = 9
     *
     * 返回: [0, 1]
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        if (nums.length < 2) {
            return nums;
        }

        /**
         * 1. （原始）暴力解法：
         *
         * 时间换空间
         * 时间复杂度：O(n^2)
         * 空间复杂度：O(1)
         *
         */
        int[] result = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            result[0] = i;
            int ret = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (ret == nums[j]) {
                    result[1] = j;
                    return result;
                }
            }
        }
        //return nums;

        //========================================================= 结题方法分割线 ===============================================================

        /**
         * 2.  暴力解法：
         *
         * 空间换时间
         * 时间复杂度：O(n)
         * 空间复杂度：O(n)
         *
         *  这里为什么要用数组索引作为map的value呢？
         *  这是为了方便当匹配到 target - nums[i]时取到对应
         *  元素的索引。
         *
         *
         * 总结：  对于要利用空间换时间的算法，多数都利用哈希表来实现。
         *
         *
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int ret = target - nums[i];
            if (map.containsKey(ret)) {
                return new int[] {map.get(nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        System.out.println(twoSum(nums, target));
    }
}
