package com.bruis.algorithminjava.algorithm;

/**
 * @author LuoHaiYang
 * @Date 2020-05-18
 *
 * url: https://leetcode-cn.com/problems/maximum-product-subarray/
 *
 */
public class MaximumProductSubarray {


    /**
     * 问题1 ：算法没有包括数组头部元素的比较；
     * 问题2 : 数组没有考虑到每个元素本身大小的比较；
     *
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        //  2, 3, -2, 4, 5, 8, -1, -3, 10
        //     [   ]
        //

        int length = nums.length;

        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            int result = nums[0] * nums[1];
            int anotherResult = nums[0] > nums[1] ? nums[0] : nums[1];
            return result > anotherResult ? result : anotherResult;
        }

        int max = nums[0] * nums[1] > nums[0] ? nums[0] * nums[1] : nums[0];

        for (int i = 0; i < length; i++) {
            int[] mul = new int[length];

            for (int j = i; j < length; j++) {
                mul[j] = nums[j];
            }

            for (int j = i + 1; j < length; j++) {
                int result = nums[j] * mul[j-1];
                //mul[j] = mul[j] > result ? mul[j] : result;
                mul[j] = result;
                if (nums[j] > max) {
                    max = nums[j];
                }
                if (result > max) {
                    max = result;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int[] nums = {2, -1, 1, 1};
        //int[] nums = {2, 3, -2, 4, 5, 8, -1, -3, 10};
        System.out.println(maximumProductSubarray.maxProduct(nums));
    }
}
