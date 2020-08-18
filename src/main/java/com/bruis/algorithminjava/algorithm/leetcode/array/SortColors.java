package com.bruis.algorithminjava.algorithm.leetcode.array;

/**
 *
 * 颜色分类
 *
 * url：https://leetcode-cn.com/problems/sort-colors/
 *
 * @author LuoHaiYang
 */
public class SortColors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {
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
        sort(nums, left, lt - 1);
        sort(nums, gt, right);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] test = {0, 1};
        sortColors.sortColors(test);
    }
}
