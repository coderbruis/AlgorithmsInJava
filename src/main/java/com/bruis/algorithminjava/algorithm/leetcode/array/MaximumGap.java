package com.bruis.algorithminjava.algorithm.leetcode.array;

/**
 * 最大间距
 *
 * url：https://leetcode-cn.com/problems/maximum-gap/
 *
 * @author LuoHaiYang
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        // 排序
        quickSort(nums);
        int n = nums.length;

        int max = nums[1] - nums[0];

        for (int i = 2; i < n; i++) {
            max = max(max, nums[i] - nums[i-1]);
        }
        return max;
    }

    private void quickSort(int[] nums) {
        int n = nums.length;
        quickSort3ways(nums, 0, n-1);
    }

    private void quickSort3ways(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = nums[left];
        int i = left + 1, lt = left, gt = right + 1;

        while (i < gt) {
            if (nums[i] < p) {
                swap(nums, i, lt + 1);
                i++;
                lt++;
            } else if (nums[i] > p) {
                swap(nums, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        swap(nums, left, lt);
        quickSort3ways(nums, left, lt - 1);
        quickSort3ways(nums, gt, right);
    }

    private int max(int i, int j) {
        return i > j ? i : j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] test = {3,6,9,1,20,15,11,30,31};
        MaximumGap maximumGap = new MaximumGap();
        System.out.println(maximumGap.maximumGap(test));
    }
}
