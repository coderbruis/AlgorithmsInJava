package com.bruis.algorithminjava.algorithm.sort;

/**
 *
 * 二分查找法
 *
 * @author LuoHaiYang
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int n, int target) {

        // 在 [left, right]范围里寻找target
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            int nums = arr[mid];

            if (nums == target) {
                return mid;
            } else if (nums > target) {
                left = mid + 1;
            } else {
                // nums < target
                right = mid - 1;
            }
        }
        return -1;
    }
}
