package com.bruis.algorithminjava.algorithm.sort;

/**
 *
 * 二分查找法
 *
 * @author LuoHaiYang
 */
public class BinarySearch {

    // 需要排序号的数组，时间复杂度是O(logN)
    public static int binarySearch(int[] arr, int target) {
        // [l...r] 左右闭区间
        int l = 0, r = arr.length - 1;
        // l=r也要判断，例如这种场景：{5}, l=r=0，需要判断
        while (l <= r) {
            // 不要(l+r)/2，防止int越界
            int mid = l + (r-l)/2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
