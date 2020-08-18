package com.bruis.algorithminjava.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 逆序对
 * <p>
 * url： https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 *
 * @author LuoHaiYang
 */
public class ReversePairs {

    /* ================================ 解法一 ================================*/

    /**
     * 暴力解法O(n^2)，超时
     *
     * @param nums
     * @return
     */
    public int reversePairs2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int reverseNum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    reverseNum++;
                }
            }
        }
        return reverseNum;
    }

    /* ================================ 解法二 ================================*/

    /**
     * 使用自顶向下的归并排序算法计算逆序对，用来额外的空间。
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        return getReversePairs(nums);
    }

    private int getReversePairs(int[] nums) {
        int n = nums.length;
        return getReversePairs(nums, 0, n - 1);
    }

    private int getReversePairs(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int result = 0;
        int mid = (left + right) / 2;
        result += getReversePairs(nums, left, mid) + getReversePairs(nums, mid + 1, right) + reversePairs(nums, left, mid, right);
        return result;
    }

    private int reversePairs(int[] nums, int left, int mid, int right) {
        int[] aux = Arrays.copyOfRange(nums, left, right + 1);
        int i = left, j = mid + 1;

        int res = 0;

        for (int k = left; k <= right; k++) {
            if (i > mid) {
                nums[k] = aux[j - left];
                j++;
            } else if (j > right) {
                nums[k] = aux[i - left];
                i++;
            } else if (aux[i - left] <= aux[j - left]) {
                nums[k] = aux[i - left];
                i++;
            } else {
                nums[k] = aux[j - left];
                j++;
                res += (mid - i) + 1;
            }
        }
        return res;
    }

    /* ================================ 题解三（优化） ================================*/

    /**
     *
     * 相比解法二时间复杂度常数和空间复杂度更低
     *
     * @param nums
     * @return
     */
    public int reversePairs3(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);

        int count = mergeCount(nums, temp, 0, nums.length - 1);
        return count;
    }

    private int mergeCount(int[] nums, int[] temp, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = (start + end) >> 1;
        int left = mergeCount(temp, nums, start, mid);
        int right = mergeCount(temp, nums, mid + 1, end);
        int count = 0;

        //merge()
        //遍历左区域指针
        int i = mid;
        //遍历右区域指针
        int j = end;

        //临时区域指针
        int k = end;
        while (i >= start && j >= mid + 1) {
            if (nums[i] > nums[j]) {
                count += j - mid;
                temp[k--] = nums[i--];
            } else {
                temp[k--] = nums[j--];
            }
        }

        //如果还有剩下没遍历的
        while (i >= start) {
            temp[k--] = nums[i--];
        }
        while (j >= mid + 1) {
            temp[k--] = nums[j--];
        }

        return count + left + right;
    }

    public int reversePairs4(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        //int count = mergeCount2();
        return 0;
    }

    private int mergeCount2(int[] nums, int[] temp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) << 1;
        //int left = mergeCount2(nums, );
        return 0;
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        int[] nums = {7, 5, 6, 4};
        //int[] nums = {1,3,2,3,1};
        System.out.println(reversePairs.reversePairs3(nums));
    }


}
